package com.kit.csg.crawler.index.service;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.kit.csg.crawler.index.entity.IndexdataEtl;
import com.kit.csg.crawler.stock.entity.*;
import com.kit.csg.crawler.stock.repository.*;
import com.kit.csg.utils.HTTPUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.http.client.utils.DateUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.*;

@Service("indexService")
@Transactional
public class IndexService {

    @Resource(name = "stockFinanceRepository")
    StockFinanceRepository stockFinanceRepository;

    @Resource(name = "stockMonthPriceRepository")
    StockMonthPriceRepository stockMonthPriceRepository;

    @Resource(name="stockMarketRepository")
    StockMarketRepository stockMarketRepository;

    public Map crawlData(){
        Map resultMap = new HashMap();
        resultMap.put("type","index");
        try{
            resultMap.put("baiduIndex",getBaiduIndexData());
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
            //getStockMarket();
//            getBaiduIndexData();
            //getNBSIndexData();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    /**
     * 获取指标数据
     * @throws Exception
     */
    public List<IndexdataEtl> getBaiduIndexData() throws Exception
    {
        List<IndexdataEtl> indexdataEtlList = new ArrayList<>();
        String[] baiduIndexTypes={"先行指数","一致指数","PPI","PMI"};
        String[][] baiduIndexNames = { { "统计局统计先行指数", "百度预测先行指数" }, { "统计局统计一致指数", "百度预测一致指数" },
                { "统计局统计工业品出厂价格指数", "百度预测工业品出厂价格指数" }, { "统计局统计制造业采购经理指数(PMI)", "百度预测制造业采购经理指数" } };
        for(int i=0;i<baiduIndexTypes.length;i++) {
            String baiduIndexType = baiduIndexTypes[i];
            String[] baiduIndexName = baiduIndexNames[i];

            String encUrl = URLEncoder.encode(baiduIndexType, "UTF-8");
            String baseUrl = "http://trends.baidu.com/economy/api?&sample_name=index&classify=predict_index&index=" + encUrl;
            String[] parsePatterns = {"yyyy-MM-dd"};
            HTTPUtils htmlParse = new HTTPUtils();
            String bdjson = HTTPUtils.getHtml(baseUrl);

            JSONObject jo = JSON.parseObject(bdjson);
            JSONArray predict = jo.getJSONArray("predict");
            String indexname;
            String strzone;
            String strdata;
            String strtime;
            String dbcode = "百度";
            Date dtime;
            String bdPrice;
            for (int j = 0; j < predict.size(); j++) {
                JSONObject node = predict.getJSONObject(j);
                indexname = baiduIndexName[0];
                strzone = "";
                strdata = node.getString("forecast");
                strtime = node.getString("date");
                dtime = DateUtils.parseDate(strtime + "-01", parsePatterns);

                if (strdata.equals(""))
                    bdPrice = BigDecimal.valueOf(Double.parseDouble("0")).toString();
                else
                    bdPrice = BigDecimal.valueOf(Double.parseDouble(strdata)).toString();
                    IndexdataEtl indexdataEtl = new IndexdataEtl();
                    indexdataEtl.setIndexdataname(indexname);
                    indexdataEtl.setZonename(strzone);
                    indexdataEtl.setDbcode(dbcode);
                    indexdataEtl.setItemdate(dtime);
                    indexdataEtl.setPrice(bdPrice);
                    indexdataEtlList.add(indexdataEtl);
            }
        }
        System.out.println("百度抽取完成");
        return indexdataEtlList;
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
            JSONObject jo = JSON.parseObject(jsonval);
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
        String bdPrice;
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
            bdPrice=(BigDecimal.valueOf(ja.getDouble(i-1))).toString();
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

        JSONObject jo = JSON.parseObject(bdjson);
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
    public static void getNBSIndexData() throws Exception
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
                    JSONObject jo = JSON.parseObject(strJson);
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

                        String bdPrice;

                        if(strdata.equals(""))
                            bdPrice=BigDecimal.valueOf(Double.parseDouble("0")).toString();
                        else
                        {
                            bdPrice=BigDecimal.valueOf(Double.parseDouble(strdata)).toString();


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
                    JSONObject jo = JSON.parseObject(strJson);
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

    /*public static  void getNBSInfo() throws Exception
    {
        String[] hgtype={"hgyd","hgjd","hgnd"};
        String[] fstype={"fsyd","fsjd","fsnd"};
        String[] cstype={"csyd","csnd"};

        //取指标
        String hgurl;

        String urlcode="{\"wdcode\":\"zb\",\"valuecode\":\"A08020H\"}";
        String urlcode2="{\"wdcode\":\"reg\",\"valuecode\":\"000000\"}";
        urlcode=URLEncoder.encode(urlcode,"UTF-8");
        urlcode2=URLEncoder.encode(urlcode2,"UTF-8");
        //城市
        hgurl="http://data.stats.gov.cn/easyquery.htm?m=QueryData&dbcode=csnd&rowcode=reg&colcode=sj&wds=["+urlcode+"]&dfwds=["+urlcode2+"]";
        //取地区
        HTTPUtils htmlParse = new HTTPUtils();
        String sJson= HTTPUtils.getHtml(hgurl);
        JSONObject jo=JSON.parseObject(sJson);
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

    }*/

    public static  void getNBSInfo1() throws Exception
    {
        String[] hgtype={"hgyd","hgjd","hgnd"};
        String[] fstype={"fsyd","fsjd","fsnd"};
        String[] cstype={"csyd","csnd"};

        //取指标
//        String hgurl;
//
//        String urlcode="{\"wdcode\":\"zb\",\"valuecode\":\"A08020H\"}";
//        String urlcode2="{\"wdcode\":\"reg\",\"valuecode\":\"000000\"}";
//        urlcode=URLEncoder.encode(urlcode,"UTF-8");
//        urlcode2=URLEncoder.encode(urlcode2,"UTF-8");
        //城市
//        hgurl="http://data.stats.gov.cn/easyquery.htm?m=QueryData&dbcode=csnd&rowcode=reg&colcode=sj&wds=["+urlcode+"]&dfwds=["+urlcode2+"]";

        String encPart = "{\"wdcode\":\"zb\",\"valuecode\":\"" + "A0101" + "\"}";
        String encPart2 = "{\"wdcode\":\"reg\",\"valuecode\":\"\"}";

        String encUrl = URLEncoder.encode(encPart, "UTF-8");
        String encUrl2 = URLEncoder.encode(encPart2, "UTF-8");
        String baseUrl = "http://data.stats.gov.cn/easyquery.htm?m=QueryData&dbcode=hgyd&rowcode=zb&colcode=sj&wds=[]&dfwds=["+encUrl+"]";
        //取地区
        HTTPUtils htmlParse = new HTTPUtils();
        String sJson= HTTPUtils.getHtml(baseUrl);
        JSONObject jo=JSON.parseObject(sJson);
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
                        JSONObject jolast=JSON.parseObject(last);
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
                    JSONObject jo = JSON.parseObject(strJson);
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

}