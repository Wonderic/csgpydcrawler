package com.kit.csg.crawler.stock.service;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.kit.csg.crawler.stock.entity.*;
import com.kit.csg.crawler.stock.repository.*;
import com.kit.csg.utils.HTTPUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.http.ParseException;
import org.apache.http.client.utils.DateUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.util.*;

@Service("stockService")
@Transactional
public class StockService {
    @Resource(name = "stockCodeLastDateRepository")
    StockCodeLastDateRepository stockCodeLastDateRepository;

    @Resource(name = "stockFinanceRepository")
    StockFinanceRepository stockFinanceRepository;

    @Resource(name = "stockMonthPriceRepository")
    StockMonthPriceRepository stockMonthPriceRepository;

    @Resource(name="stockMarketRepository")
    StockMarketRepository stockMarketRepository;

    public Map crawlData(){
        Map resultMap = new HashMap();
        resultMap.put("type","stock");
        try{
            resultMap.put("stockMarket",getStockMarket());
            resultMap.put("stockPrice",getStockPrice());
        }catch (Exception e){
            e.printStackTrace();
        }
        return resultMap;
    }

    @Transactional(propagation= Propagation.REQUIRES_NEW)
    public void saveData(Map map){
    }

    public static void main(String[] args)  {
        try{
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    /**
     * 获取证券指数
     * @throws Exception
     */
    public List<StockMarket> getStockMarket() throws Exception
    {
//		http://www.k780.com/api 注册该网站获取当前股市 修改appkey与
        List<StockMarket> stockMarketList = new ArrayList<>();
        String baseUrl = "http://api.k780.com:88/?app=finance.globalindex&appkey=19264&sign=627a9ccb533cc051bd341cbce1e1ee1f&format=json";
        String jsonStr = HTTPUtils.getHtml(baseUrl);

        String[] parsePatterns = {"yyyy-MM-dd"};

        if(!jsonStr.equals(""))
        {
            JSONObject jo= JSON.parseObject(jsonStr);
            JSONObject jo_result=jo.getJSONObject("result");
            StockMarket stockMarket=new StockMarket();
            Iterator io=jo_result.keySet().iterator();

            String stockname = "";
            String INDEXDATA = "";
            String RCID;
            Date tmpdate = null;

            while(io.hasNext())
            {
                String key=io.next().toString();
                System.out.print(key+"\t");
                JSONObject ja_result=jo_result.getJSONObject(key);
                RCID= UUID.randomUUID().toString().replace("-","");
                tmpdate= DateUtils.parseDate(ja_result.getString("uptime").substring(0,10),parsePatterns);
                stockname=ja_result.getString("inxnm");
                INDEXDATA=ja_result.getString("last_price");
                stockMarket.setId(RCID);
                stockMarket.setItemDate(new Timestamp(tmpdate.getTime()));
                stockMarket.setMarketName(stockname);
                stockMarket.setIndexData(BigDecimal.valueOf(Double.parseDouble(INDEXDATA)));
                stockMarketList.add(stockMarket);
            }
            System.out.println(DateFormatUtils.format(System.currentTimeMillis(),"yyyy-MM-dd HH:mm:ss")+" 大盘股票获取成功");
        }
        else
            System.out.println("没获取到数据");
        return stockMarketList;
    }


    /**
     * 获取股票价格数据
     */
    public List<StockpriceEtl> getStockPrice()
    {
        List<StockpriceEtl> stockpriceEtlList = new ArrayList<>();
        List<StockCodeLastDate> stockCodeLastDateList  = stockCodeLastDateRepository.findAll();
        stockCodeLastDateList.forEach(o->{
            String stockcode = o.getStockcode();
            String url;
            String year;
            String season;
            String[] parsePatterns = {"yyyy-MM-dd","yyyy"};
            year="1989";
            season="1";
            HTTPUtils htmlParse = new HTTPUtils();

            url="http://quotes.money.163.com/trade/lsjysj_"+stockcode+".html?year="+year+"&season="+season;
            String bhtml;
            bhtml = HTTPUtils.getHtml(url);

            if (bhtml.equals("")) {
                System.err.println("网址不正确");
            }
            else
            {
                Document doc = Jsoup.parse(bhtml);
                //获取最早年份
                Elements elmsYear=doc.getElementsByAttributeValue("name", "year");
                Elements optYear=elmsYear.get(0).getElementsByTag("option");
                year=optYear.last().text();
                String curYear=DateFormatUtils.format(System.currentTimeMillis(), parsePatterns[1]);
                for(int m=Integer.parseInt(year);m<=Integer.parseInt(curYear);m++)
                {
                    for(int n=1;n<5;n++)
                    {
                        year=String.valueOf(m);
                        season=String.valueOf(n);
                        url="http://quotes.money.163.com/trade/lsjysj_"+stockcode+".html?year="+year+"&season="+season;
                        bhtml = HTTPUtils.getHtml(url);
                        doc = Jsoup.parse(bhtml);

                        Elements els = doc.getElementsByClass("table_bg001");
                        Element tb=els.get(0);
                        Elements rows=tb.getElementsByTag("tr");
                        Elements cols=rows.get(0).getElementsByTag("th");
                        Date tmpDate=null;
                        String sPrice;
                        BigDecimal bdPrice;
                        int irow;
                        irow=rows.size();
                        StockpriceEtl se=new StockpriceEtl();
                        if(irow>1)
                        {
                            for(int x=1;x<irow;x++)
                            {
                                cols=rows.get(x).getElementsByTag("td");

                                try {
                                    tmpDate=DateUtils.parseDate(cols.get(0).text(),parsePatterns);
                                    sPrice=cols.get(4).text();
                                    bdPrice=BigDecimal.valueOf(Double.parseDouble(sPrice));
                                    se.setPrice(bdPrice);
                                    se.setStockcode(stockcode);
                                    se.setItemdate(tmpDate);
                                    stockpriceEtlList.add(se);
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        else
                            System.out.println(stockcode+" year:"+year+" season:"+season+" no data");
                    }
                }
            }
        });
        return stockpriceEtlList;
    }
}