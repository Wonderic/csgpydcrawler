package com.kit.csg.crawler.stock.service;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.kit.csg.crawler.stock.repository.*;
import com.kit.csg.crawler.stock.vo.*;
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
    @Resource(name = "stockCompanyInformationRepository")
    StockCompanyInformationRepository stockCompanyInformationRepository;

    @Resource(name = "stockCompanyRelationRepository")
    StockCompanyRelationRepository stockCompanyRelationRepository;

    @Resource(name = "stockFinanceRepository")
    StockFinanceRepository stockFinanceRepository;

    @Resource(name = "stockMonthPriceRepository")
    StockMonthPriceRepository stockMonthPriceRepository;

    @Resource(name="stockMarketRepository")
    StockMarketRepository stockMarketRepository;

    public boolean crawlData(){
        return false;
    }


/*
    @Autowired
    PowereconStockmarketMapper psm ;
    @Autowired
    StockpriceEtlMapper spem;
    @Autowired
    NbsIndexinfoHgMapper nihm;
    @Autowired
    NbsIndexinfoZoneMapper nizm;
    @Autowired
    NbsNeedIndexMapper nnim;
    @Autowired
    IndexdataEtlMapper idem;
    @Autowired
    NbsDoneIndexMapper ndim;
    @Autowired
    NbsDifftreeIndexMapper ndtim;
    @Autowired
    PowereconIntypeMapper pim;


    public Date ist;
    public Date iet;
    public Date lastSt;
    public Date lastEt;
    public int lastPosition;
    public int times=0;
    public int firsttime;
    @Autowired
    JdbcTemplate jdbcTemplate;

    public StockService(){
        String[] parsePatterns = {"yyyy-MM-dd"};
        String str = "1951-01-01";
        String str2 = "2016-01-01";
        try {
            ist= DateUtils.parseDate(str,parsePatterns);
            iet=DateUtils.parseDate(str2,parsePatterns);
            //iet=Calendar.getInstance().getTime();
            firsttime=0;
            lastSt=ist;
            lastEt=iet;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
*/

    public static void main(String[] args)  {
        try{
            //getStockMarket();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    /**
     * 获取证券指数
     * @throws Exception
     */
    public void getStockMarket() throws Exception
    {
//		http://www.k780.com/api 注册该网站获取当前股市 修改appkey与
        String baseUrl = "http://api.k780.com:88/?app=finance.globalindex&appkey=19264&sign=627a9ccb533cc051bd341cbce1e1ee1f&format=json";
        String jsonStr = HTTPUtils.getHtml(baseUrl);

        String[] parsePatterns = {"yyyy-MM-dd"};

        if(!jsonStr.equals(""))
        {
            JSONObject jo= JSON.parseObject(jsonStr);
            JSONObject jo_result=jo.getJSONObject("result");
            StockMarket stockMarket=new StockMarket();
            List<StockMarket> psa=new ArrayList<StockMarket>();

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
            }
            System.out.println(DateFormatUtils.format(System.currentTimeMillis(),"yyyy-MM-dd HH:mm:ss")+" 大盘股票获取成功");
        }
        else
            System.out.println("没获取到数据");
    }

    /**
     * 获取指标数据
     * @throws Exception
     */
    public void getIndexData() throws Exception
    {
        String[] baiduIndexType={"先行指数","一致指数","PPI","PMI"};
        String[][] baiduIndexName = { { "统计局统计先行指数", "百度预测先行指数" }, { "统计局统计一致指数", "百度预测一致指数" },
                { "统计局统计工业品出厂价格指数", "百度预测工业品出厂价格指数" }, { "统计局统计制造业采购经理指数(PMI)", "百度预测制造业采购经理指数" } };
        for(int i=0;i<baiduIndexType.length;i++)
            dealBaidu(baiduIndexType[i],baiduIndexName[i]);

        System.out.println("百度抽取完成");
//        jdbcTemplate.execute("call PROC_ETL_INDEXDATA()");
    }

    /**
     * 获取阿里指数
     * @throws Exception
     */
    public void  dealAli() throws Exception
    {
//        List<Map> hm=pim.selectAliSrcList();

        List<Map> hm = null;
        for(int i=0;i<hm.size();i++)
        {
            Map indexmap=hm.get(i);


            try {
                Thread.sleep(3000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            String[] indexids=indexmap.get("INDEXTYPEIDS").toString().split(",");
            String[] indexnames=indexmap.get("INDNAMES").toString().split(",");

            String baseUrl = indexmap.get("SOURCEKEY").toString();

            HtmlPage page = HTTPUtils.htmlSave(baseUrl);
            DomElement de=page.getElementById("main-chart-val");
            String jsonval=de.getAttribute("value");

            String indexname;
            JSONObject jo = (JSONObject)JSONUtils.parse(jsonval);
            //1688市场采购指数
            JSONObject jo_purchaseIndex1688=jo.getJSONObject("purchaseIndex1688");
            int m=0;
            for(int j=0;j<indexnames.length;j++)
            {
                if(indexnames[j].contains("1688市场采购指数"))
                    m=j;
            }
            indexname=indexids[m];
            JSONArray index_history=jo_purchaseIndex1688.getJSONObject("index").getJSONArray("history");
            insertAliData(index_history,indexname);
            //淘宝指数
            JSONObject jo_purchaseIndexTb=jo.getJSONObject("purchaseIndexTb");
            m=0;
            for(int j=0;j<indexnames.length;j++)
            {
                if(indexnames[j].contains("淘宝采购指数"))
                    m=j;
            }
            indexname=indexids[m];
            index_history=jo_purchaseIndexTb.getJSONObject("index").getJSONArray("history");
            insertAliData(index_history,indexname);
            //1688市场供应指数
            JSONObject jo_supplyIndex=jo.getJSONObject("supplyIndex");
            m=0;
            for(int j=0;j<indexnames.length;j++)
            {
                if(indexnames[j].contains("1688市场供应指数"))
                    m=j;
            }
            indexname=indexids[m];
            index_history=jo_supplyIndex.getJSONObject("index").getJSONArray("history");
            insertAliData(index_history,indexname);
        }
        System.out.println(DateFormatUtils.format(System.currentTimeMillis(),"yyyy-MM-dd")+" 阿里指数完成");

    }

    /**
     * 插入 阿里指标数据
     * @param ja
     * @param indexname
     */
    public void insertAliData(JSONArray ja,String indexname)
    {
        String strzone="";
        String strdata;
        String dbcode="阿里";
        Date dtime=null;
        BigDecimal bdPrice;
        String[] datef={"yyyy-MM-dd"};

        Date yestoday=new Date();
        //yestoday=DateUtils.truncate(DateUtils.addDays(yestoday, -1),Calendar.DAY_OF_MONTH);

        List<IndexdataEtl> lidde=new ArrayList<IndexdataEtl>();
        int n =0;

        int iday=0;
        boolean isbreak=false;
        IndexdataEtlExample idee=new IndexdataEtlExample();

        for(int i=ja.size();i>0;i--)
        {
           // dtime=DateUtils.addDays(yestoday, iday);
            bdPrice=BigDecimal.valueOf(ja.getDouble(i-1));
            IndexdataEtl idde=new IndexdataEtl();
            idde.setIndexdataname(indexname);
            idde.setZonename(strzone);
            idde.setDbcode(dbcode);
            idde.setItemdate(dtime);
            idde.setPrice(bdPrice);

            idee.clear();
            idee.createCriteria().andIndexdatanameEqualTo(indexname).andZonenameIsNull()
                    .andItemdateEqualTo(dtime).andDbcodeEqualTo(dbcode);

//            if(idem.countByExample(idee)==0)
//            {
//                //idem.insert(idde);
//                lidde.add(idde);
//                if(n%50==0)
//                {
//                    idem.insertBatch(lidde);
//                    lidde.clear();
//                }
//                n+=1;
//            }
//            iday-=1;
        }

//        if(lidde.size()>0)
//            idem.insertBatch(lidde);
    }

    /**
     *  获取百度指标
     * @param baiduIndexType
     * @param baiduIndexName
     * @throws Exception
     */
    public void dealBaidu(String baiduIndexType,String[] baiduIndexName) throws Exception
    {
        String encUrl = URLEncoder.encode(baiduIndexType, "UTF-8");
        String baseUrl = "http://trends.baidu.com/economy/api?&sample_name=index&classify=predict_index&index="+encUrl;
        String[] parsePatterns = {"yyyy-MM-dd"};
        HTTPUtils htmlParse = new HTTPUtils();
        String bdjson = HTTPUtils.getHtml(baseUrl);

        JSONObject jo = (JSONObject)JSONUtils.parse(bdjson);
        JSONArray predict=jo.getJSONArray("predict");
        String indexname;
        String strzone;
        String strdata;
        String strtime;
        String dbcode="百度";
        Date dtime;
        BigDecimal bdPrice;
        for(int i=0;i<predict.size();i++)
        {
            JSONObject node=predict.getJSONObject(i);
            indexname=baiduIndexName[0];
            strzone="";
            strdata=node.getString("forecast");
            strtime=node.getString("date");
            dtime=DateUtils.parseDate(strtime+"-01",parsePatterns);

            if(strdata.equals(""))
                bdPrice=BigDecimal.valueOf(Double.parseDouble("0"));
            else
                bdPrice=BigDecimal.valueOf(Double.parseDouble(strdata));

//            IndexdataEtl idde=new IndexdataEtl();
//            idde.setIndexdataname(indexname);
//            idde.setZonename(strzone);
//            idde.setDbcode(dbcode);
//            idde.setItemdate(dtime);
//            idde.setPrice(bdPrice);
//
//            IndexdataEtlExample idee=new IndexdataEtlExample();
//            idee.createCriteria().andIndexdatanameEqualTo(indexname).andZonenameIsNull()
//                    .andItemdateEqualTo(dtime).andDbcodeEqualTo(dbcode);
//
//            if(idem.countByExample(idee)==0)
//                idem.insert(idde);
//            else
//            {
//                IndexdataEtl iddeu=new IndexdataEtl();
//                iddeu.setPrice(bdPrice);
//                idem.updateByExampleSelective(iddeu, idee);
//            }
//
//            indexname=baiduIndexName[1];
//            strdata=node.getString("real");
//            if(strdata.equals(""))
//                bdPrice=BigDecimal.valueOf(Double.parseDouble("0"));
//            else
//                bdPrice=BigDecimal.valueOf(Double.parseDouble(strdata));
//
//            idde.setIndexdataname(indexname);
//            idde.setZonename(strzone);
//            idde.setDbcode(dbcode);
//            idde.setItemdate(dtime);
//            idde.setPrice(bdPrice);
//
//            idee.clear();
//            idee.createCriteria().andIndexdatanameEqualTo(indexname).andZonenameIsNull()
//                    .andItemdateEqualTo(dtime).andDbcodeEqualTo(dbcode);
//
//            if(idem.countByExample(idee)==0)
//                idem.insert(idde);
//            else
//            {
//                IndexdataEtl iddeu=new IndexdataEtl();
//                iddeu.setPrice(bdPrice);
//                idem.updateByExampleSelective(iddeu, idee);
//            }
        }

    }

    /**
     * 获取统计局指标数据
     * @throws Exception
     */
    public void getNBSIndexData() throws Exception
    {

        NbsNeedIndexExample nnie=new NbsNeedIndexExample();
        String[] parsePatterns = {"yyyyMMdd"};

//        List<NbsNeedIndex> lsnni=nnim.selectByExample(nnie);
        List<NbsNeedIndex> lsnni=null;

        for(NbsNeedIndex vnni:lsnni)
        {
            String dbcode=vnni.getFscode();
            String id=vnni.getIndexcode();
            String oldid=id;

            NbsIndexinfoHg nih=new NbsIndexinfoHg();
            NbsIndexinfoHgKey nihk=new NbsIndexinfoHgKey();
            nihk.setIndexcode(id);
            nihk.setIndexdatetype(dbcode);

//            nih=nihm.selectByPrimaryKey(nihk);
            if(nih.getRealcode()!=null)
                id=nih.getRealcode();


            long start,end;
            start=System.currentTimeMillis();
            String pattern="yyyy-MM-dd HH:mm:ss";
            System.out.print(dbcode+","+id+",start:"+DateFormatUtils.format(start, pattern));

            if (dbcode.contains("fs") || dbcode.contains("cs")) {//分省,主要城市

                String encPart = "{\"wdcode\":\"zb\",\"valuecode\":\"" + id + "\"}";
                String encPart2 = "{\"wdcode\":\"sj\",\"valuecode\":\"1980-\"}";


                if(dbcode.contains("csnd"))
                {

                    encPart2 = "{\"wdcode\":\"reg\",\"valuecode\":\"000000\"}";
                }

                if(dbcode.contains("csyd"))
                {
                    encPart2 = "{\"wdcode\":\"reg\",\"valuecode\":\"00\"}";
                }

                String encUrl = URLEncoder.encode(encPart, "UTF-8");
                String encUrl2 = URLEncoder.encode(encPart2, "UTF-8");
                String baseUrl = "http://data.stats.gov.cn/easyquery.htm?m=QueryData&dbcode="+dbcode
                        +"&rowcode=reg&colcode=sj&wds=["+encUrl+"]&dfwds=["+encUrl2+"]";

                HTTPUtils htmlParse = new HTTPUtils();
                String strJson = HTTPUtils.getHtml(baseUrl);

                if (!strJson.equals("")) {
                    JSONObject jo = (JSONObject)JSONUtils.parse(strJson);
                    JSONObject returndata = jo.getJSONObject("returndata");
                    JSONArray datanodes = returndata.getJSONArray("datanodes");

                    List<IndexdataEtl> lidde=new ArrayList<IndexdataEtl>();
                    int n =0;


                    for (int i = 0; i < datanodes.size(); i++) {
                        JSONObject node = datanodes.getJSONObject(i);
                        String strcodetime = node.getString("code");
                        String strdata = node.getJSONObject("data").getString("strdata");
                        String strcode = oldid;
                        String strzone = strcodetime.split("_")[1];
                        String strtime = strcodetime.split("_")[2];
                        strcode = strcode.substring(strcode.indexOf(".") + 1);
                        strzone = strzone.substring(strzone.indexOf(".") + 1);
                        strtime = strtime.substring(strtime.indexOf(".") + 1);
                        Date dtime;


                        if(strtime.length()==4)
                            dtime=DateUtils.parseDate(strtime+"0101",parsePatterns);
                        else if(strtime.length()==5)
                        {
                            if(strtime.substring(4).equals("A"))
                                dtime=DateUtils.parseDate(strtime.substring(0, 4)+"0101",parsePatterns);
                            else if(strtime.substring(4).equals("B"))
                                dtime=DateUtils.parseDate(strtime.substring(0, 4)+"0401",parsePatterns);
                            else if(strtime.substring(4).equals("C"))
                                dtime=DateUtils.parseDate(strtime.substring(0, 4)+"0701",parsePatterns);
                            else
                                dtime=DateUtils.parseDate(strtime.substring(0, 4)+"1001",parsePatterns);
                        }
                        else
                            dtime=DateUtils.parseDate(strtime+"01",parsePatterns);

                        BigDecimal bdPrice;

                        if(strdata.equals(""))
                            bdPrice=BigDecimal.valueOf(Double.parseDouble("0"));
                        else
                        {
                            bdPrice=BigDecimal.valueOf(Double.parseDouble(strdata));


                            IndexdataEtl idde=new IndexdataEtl();
                            idde.setIndexdataname(strcode);
                            idde.setZonename(strzone);
                            idde.setDbcode(dbcode);
                            idde.setItemdate(dtime);
                            idde.setPrice(bdPrice);

                            IndexdataEtlExample idee=new IndexdataEtlExample();

                            idee.clear();

                            idee.createCriteria().andIndexdatanameEqualTo(strcode).andZonenameEqualTo(strzone)
                                    .andItemdateEqualTo(dtime).andDbcodeEqualTo(dbcode);

//                            if(idem.countByExample(idee)==0)
//                            {
//                                lidde.add(idde);
//                                if(n%50==0)
//                                {
//                                    idem.insertBatch(lidde);
//                                    lidde.clear();
//                                }
//                                n+=1;
//                            }
                        }
                    }
//                    if(lidde.size()>0)
//                        idem.insertBatch(lidde);

                }
                end=System.currentTimeMillis();
                NbsDoneIndex ndi=new NbsDoneIndex();
                ndi.setIndexcode(id);
                ndi.setFscode(dbcode);
//                ndim.insert(ndi);
                System.out.println(",end:"+DateFormatUtils.format(end, pattern)+",end:"+(end-start)/1000+" s");
            }
            else //全国指标
            {
                String encPart = "{\"wdcode\":\"zb\",\"valuecode\":\"" + id + "\"}";
                String encPart2 = "{\"wdcode\":\"reg\",\"valuecode\":\"\"}";

                String encUrl = URLEncoder.encode(encPart, "UTF-8");
                String encUrl2 = URLEncoder.encode(encPart2, "UTF-8");
                String baseUrl = "http://data.stats.gov.cn/easyquery.htm?m=QueryData&dbcode=hgyd&rowcode=zb&colcode=sj&wds=[]&dfwds=["+encUrl+"]";

                HTTPUtils htmlParse = new HTTPUtils();
                String strJson = HTTPUtils.getHtml(baseUrl);

                if (!strJson.equals("")) {
                    JSONObject jo = (JSONObject)JSONUtils.parse(strJson);
                    JSONObject returndata = jo.getJSONObject("returndata");
                    JSONArray wdnodes = returndata.getJSONArray("wdnodes");
                    JSONArray datanodes = returndata.getJSONArray("datanodes");
                    JSONArray wdnodes_nodes = wdnodes.getJSONObject(0).getJSONArray("nodes");
                    Map<Object, Object> dict = new HashMap<Object, Object>();
                    for (int i = 0; i < wdnodes_nodes.size(); i++) {
                        JSONObject node = wdnodes_nodes.getJSONObject(i);
                        dict.put(node.get("code").toString(), node.get("cname").toString());
                        System.out.println(node.get("code").toString()+":"+node.get("cname").toString());
                    }

                    for (int i = 0; i < datanodes.size(); i++) {
                        JSONObject node = datanodes.getJSONObject(i);
                        String strcodetime = node.getString("code");
                        String strdata = node.getJSONObject("data").getString("strdata");
                        String strcode = strcodetime.split("_")[0];
                        String strtime = strcodetime.split("_")[1];
                        strcode = strcode.substring(strcode.indexOf(".") + 1);
                        strtime = strtime.substring(strtime.indexOf(".") + 1);
                        System.out.println(strtime + "\t" + dict.get(strcode) + "\t" + strdata);
                    }
                }
            }
        }
    }

    public void getNBSInfo() throws Exception
    {
        String[] hgtype={"hgyd","hgjd","hgnd"};
        String[] fstype={"fsyd","fsjd","fsnd"};
        String[] cstype={"csyd","csnd"};

        //取指标
        String hgurl;

        String urlcode="{\"wdcode\":\"zb\",\"valuecode\":\"A0101\"}";
        String urlcode2="{\"wdcode\":\"reg\",\"valuecode\":\"000000\"}";
        urlcode=URLEncoder.encode(urlcode,"UTF-8");
        urlcode2=URLEncoder.encode(urlcode2,"UTF-8");
        //城市
        hgurl="http://data.stats.gov.cn/easyquery.htm?m=QueryData&dbcode=csnd&rowcode=reg&colcode=sj&wds=["+urlcode+"]&dfwds=["+urlcode2+"]";
        //取地区
        HTTPUtils htmlParse = new HTTPUtils();
        String sJson= HTTPUtils.getHtml(hgurl);
        JSONObject jo=(JSONObject)JSONUtils.parse(sJson);
        JSONObject returndata=jo.getJSONObject("returndata");
        JSONArray wdnodes=returndata.getJSONArray("wdnodes");
        JSONArray wdnodes_nodes=wdnodes.getJSONObject(1).getJSONArray("nodes");
        for(int i=0;i<wdnodes_nodes.size();i++)
        {
            JSONObject distrect=wdnodes_nodes.getJSONObject(i);
            String code=distrect.getString("code");
            String cname=distrect.getString("cname");
            NbsIndexinfoZone niz=new NbsIndexinfoZone();
            niz.setZonecode(code);
            niz.setZonename(cname);
            NbsIndexinfoZoneExample nize=new NbsIndexinfoZoneExample();
            nize.createCriteria().andZonecodeEqualTo(code);
//            if(nizm.countByExample(nize)==0)
//                nizm.insert(niz);
        }

    }

    /**
     * 获取统计局指标信息
     * @param url
     */
    public void dealIndexInfo(String url)
    {
        HTTPUtils htmlParse = new HTTPUtils();
        String sJson= HTTPUtils.getHtml(url);
        JSONArray ja=(JSONArray)JSONUtils.parse(sJson);
        NbsIndexinfoHg nih=new NbsIndexinfoHg();
        for(int i=0;i<ja.size();i++)
        {
            JSONObject jo=ja.getJSONObject(i);
            String dbcode=jo.getString("dbcode");
            String id=jo.getString("id");
            String isParent=jo.getString("isParent");
            String name=jo.getString("name");
            String pid=jo.getString("pid");
            nih.setIndexcode(id);
            nih.setIndexdataname(name);
            nih.setIndexdatetype(dbcode);
            nih.setIsparent(isParent);
            nih.setParentcode(pid);

            NbsIndexinfoHgExample nihe1=new NbsIndexinfoHgExample();
            nihe1.createCriteria().andIndexcodeEqualTo(id).andIndexdatetypeEqualTo(dbcode);
//
//            if(nihm.countByExample(nihe1)==0)
//                nihm.insert(nih);

            if(isParent.equals("true"))
            {
                String hgurl=url.replaceAll("id=\\w+&", "id="+id+"&");
                //System.out.println(hgurl);
                dealIndexInfo(hgurl);
            }
            else
            {
                if(i%9==0)
                    System.out.println(id+"\t"+name+"\t"+dbcode+"\t"+isParent);
                String encPart,encPart2;

                if(dbcode.contains("fs"))
                    encPart2="{\"wdcode\":\"reg\",\"valuecode\":\"\"}";
                else
                    encPart2="";

                encPart="{\"wdcode\":\"zb\",\"valuecode\":\""+id+"\"}";

                if(dbcode.contains("cs"))
                {
                    encPart2="{\"wdcode\":\"reg\",\"valuecode\":\"\"}";
                    encPart="{\"wdcode\":\"zb\",\"valuecode\":\""+id+"\"}";
                }

                String encUrl,encUrl2;
                try {
                    encUrl = URLEncoder.encode(encPart,"UTF-8");
                    encUrl2 = URLEncoder.encode(encPart2,"UTF-8");
                    String baseUrl = "http://data.stats.gov.cn/easyquery.htm?m=QueryData&dbcode=hgnd&rowcode=zb"
                            +"&colcode=sj&wds=["+encUrl2+"]&dfwds=["+encUrl+"]";
                    baseUrl=baseUrl.replaceAll("dbcode=\\w+&", "dbcode="+dbcode+"&");
                    String last= HTTPUtils.getHtml(baseUrl);
                    if(!last.equals(""))
                    {
                        JSONObject jolast=(JSONObject)JSONUtils.parse(last);
                        if(jolast.getString("returncode").equals("200"))
                        {
                            JSONObject returndata=jolast.getJSONObject("returndata");
                            JSONArray wdnodes=returndata.getJSONArray("wdnodes");
                            JSONArray wdnodes_nodes=wdnodes.getJSONObject(0).getJSONArray("nodes");
                            for (int n =0;n<wdnodes_nodes.size();n++)
                            {
                                JSONObject node=wdnodes_nodes.getJSONObject(n);

                                String lid=node.getString("code");
                                String lname=node.getString("cname");
                                String lpid=id;
                                String lisParent="flase";
                                String ldbcode=dbcode;
                                String lunit=node.getString("unit");

                                nih.setIndexcode(lid);
                                nih.setIndexdataname(lname);
                                nih.setParentcode(lpid);
                                nih.setIsparent(lisParent);
                                nih.setIndexdatetype(ldbcode);
                                nih.setUnit(lunit);
                                //System.out.println(lid+"\t"+lname+"\t"+id);
                                NbsIndexinfoHgExample nihe=new NbsIndexinfoHgExample();
                                nihe.createCriteria().andIndexcodeEqualTo(lid).andIndexdatetypeEqualTo(dbcode);
//                                if(nihm.countByExample(nihe)>0)
//                                {
//                                    if(!lunit.equals(""))
//                                    {
//                                        NbsIndexinfoHg nihu=new NbsIndexinfoHg();
//                                        nihu.setUnit(lunit);
//                                        nihm.updateByExampleSelective(nihu, nihe);
//                                    }
//                                }
//                                else
//                                    nihm.insert(nih);
                            }
                        }
                        else
                            System.out.println(id+"\t"+baseUrl);
                    }


                } catch (UnsupportedEncodingException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }


            }


        }

    }

    /**
     * 检验统计局指标信息
     * @throws Exception
     */
    public void correctNBSInfo() throws Exception
    {

        NbsNeedIndexExample nnie=new NbsNeedIndexExample();
        String[] parsePatterns = {"yyyyMMdd"};


//        List<NbsNeedIndex> lsnni=nnim.selectByExample(nnie);
        List<NbsNeedIndex> lsnni=null;

        for(NbsNeedIndex vnni:lsnni)
        {
            NbsIndexinfoHgExample nihe=new NbsIndexinfoHgExample();

            String dbcode=vnni.getFscode();
            String id=vnni.getIndexcode();
            nihe.createCriteria().andIndexcodeEqualTo(id).andIndexdatetypeEqualTo(dbcode);

//            List<NbsIndexinfoHg> lnih=nihm.selectByExample(nihe);
            List<NbsIndexinfoHg> lnih=null;
            String indexname=lnih.get(0).getIndexdataname();

            long start,end;
            start=System.currentTimeMillis();
            String pattern="yyyy-MM-dd HH:mm:ss";
            System.out.print(dbcode+","+id+",start:"+DateFormatUtils.format(start, pattern));

            if (dbcode.contains("fs") || dbcode.contains("cs")) {//分省,主要城市

                String encPart = "{\"wdcode\":\"zb\",\"valuecode\":\"" + id + "\"}";
                String encPart2 = "{\"wdcode\":\"sj\",\"valuecode\":\"1980-\"}";


                if(dbcode.contains("csnd"))
                {
                    encPart2 = "{\"wdcode\":\"reg\",\"valuecode\":\"000000\"}";
                }

                if(dbcode.contains("csyd"))
                {
                    encPart2 = "{\"wdcode\":\"reg\",\"valuecode\":\"00\"}";
                }

                String encUrl = URLEncoder.encode(encPart, "UTF-8");
                String encUrl2 = URLEncoder.encode(encPart2, "UTF-8");
                String baseUrl = "http://data.stats.gov.cn/easyquery.htm?m=QueryData&dbcode="+dbcode
                        +"&rowcode=reg&colcode=sj&wds=["+encUrl+"]&dfwds=["+encUrl2+"]";

                HTTPUtils htmlParse = new HTTPUtils();
                String strJson = HTTPUtils.getHtml(baseUrl);

                if (!strJson.equals("")) {
                    JSONObject jo = (JSONObject)JSONUtils.parse(strJson);
                    JSONObject returndata = jo.getJSONObject("returndata");
                    JSONArray wdnodes = returndata.getJSONArray("wdnodes");
                    //JSONArray datanodes = returndata.getJSONArray("datanodes");
                    JSONArray wdnodes_nodes = wdnodes.getJSONObject(0).getJSONArray("nodes");

                    if(wdnodes_nodes.getJSONObject(0).isEmpty())
                        insertDiff(id,dbcode,"",indexname);
                    else
                    {
                        for(int m=0;m<wdnodes_nodes.size();m++)
                        {
                            JSONObject cinfo=wdnodes_nodes.getJSONObject(m);
                            String code=cinfo.getString("code");
                            String cname=cinfo.getString("cname");

                            if (code.equals(id))
                            {
                                String tcname;
                                if(cname.contains("("))
                                    tcname=cname.substring(0, cname.indexOf("("));
                                else
                                    tcname=cname;

                                String tindexname;
                                if(indexname.contains("("))
                                    tindexname=indexname.substring(0, indexname.indexOf("("));
                                else
                                    tindexname=indexname;

                                if(!tcname.equals(tindexname))
                                {
                                    insertDiff(id,dbcode,cname,indexname);
                                }
                            }
                        }
                    }
                }
                end=System.currentTimeMillis();
                System.out.println(",end:"+DateFormatUtils.format(end, pattern)+",end:"+(end-start)/1000+" s");
            }
        }
    }

    /**
     *  插入不同的统计局数据
     * @param ic
     * @param fc
     * @param in
     * @param tn
     */
    public void insertDiff(String ic,String fc,String in,String tn)
    {
        NbsDifftreeIndex ndti=new NbsDifftreeIndex();
        ndti.setIndexcode(ic);
        ndti.setFscode(fc);
        ndti.setIndexname(in);
        ndti.setTreenodename(tn);
//        ndtim.insert(ndti);
    }

    public void getStockPrice() throws Exception
    {
        File fsklst= new File(this.getClass().getResource("/com/kit/config/stocklist.txt").getPath());
        String strStkLst= FileUtils.readFileToString(fsklst);
        String[] sStockArray=strStkLst.split(",(\r\n)?");
        for(int i =0 ;i < sStockArray.length;i++)
        {
            dealStockPrice(sStockArray[i]);
        }
    }

    /**
     * 获取股票价格数据
     * @param stockcode 股票代码
     */
    public void dealStockPrice(String stockcode)
    {
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
            //判断当前数据库是否有数据
            StockpriceEtlExample spee=new StockpriceEtlExample();
            spee.createCriteria().andStockcodeEqualTo(stockcode);
//            String sMaxYear=spem.selectMaxYear(spee);
            String sMaxYear=null;

            if(sMaxYear!=null)
            {
                System.out.println(stockcode+" have data");
                year=sMaxYear;
            }
            else
            {
                System.out.println(stockcode+" nodata before");
            }

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

                                StockpriceEtlExample spee2=new StockpriceEtlExample();
                                spee2.createCriteria().andStockcodeEqualTo(stockcode)
                                        .andItemdateEqualTo(tmpDate);

//                                if(spem.countByExample(spee2)==0)
//                                    spem.insert(se);

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
    }
}