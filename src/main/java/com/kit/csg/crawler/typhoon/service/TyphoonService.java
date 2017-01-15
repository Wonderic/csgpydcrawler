package com.kit.csg.crawler.typhoon.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kit.csg.crawler.typhoon.config.TyphoonConfig;
import com.kit.csg.crawler.typhoon.entity.TyphoonRoute;
import com.kit.csg.crawler.typhoon.entity.TyphoonSummary;
import com.kit.csg.utils.HTTPUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.*;

@Service("typhoonService")
public class TyphoonService {

    @Autowired
    private TyphoonConfig typhoonConfig;

    public Map crawlData(){
        Map data = getTyphoonData();
        return data;
    }
    private Map getTyphoonData(){
        Map resultMap = new HashMap();
        resultMap.put("type","typhoon");
//        Integer year =  Calendar.getInstance().get(Calendar.YEAR);
        Integer year=2016;
        Map jpList = getTyphoonDataJPDIGITAL(year);
        Map ajList = getTyphoonDataZJWATER(year);

        List<TyphoonSummary> summaryList = new ArrayList();
        List<TyphoonRoute> routeList = new ArrayList();

        jpList.forEach((k1,v1)->{
            ajList.forEach((k2,v2)->{
                if(k1.equals(k2)){
                    TyphoonSummary summary = new TyphoonSummary();
                    Map jpSummaryMap = (Map)((Map)v1).get("summary");
                    List jpRoutesList = (List)((Map)v1).get("routes");

                    Map zjSummaryMap = (Map)v2;

                    String id = UUID.randomUUID().toString();
                    Integer typhoonNum = Integer.parseInt((String)k1);
                    String typhoonNameEn = (String)jpSummaryMap.get("enname");
                    String typhoonNameZh = (String)zjSummaryMap.get("name");
                    Timestamp birthDate = new Timestamp(Timestamp.valueOf((jpSummaryMap.get("birth")) + ":00").getTime());
                    Timestamp deathDate = new Timestamp(Timestamp.valueOf((jpSummaryMap.get("death")) + ":00").getTime());
                    String liftTime = new java.text.DecimalFormat("#").format((deathDate.getTime() - birthDate.getTime())/(1000*60*60));
                    Integer minPressure = Integer.valueOf((String)jpSummaryMap.get("minpress"));
                    Integer typhoonStatus = Integer.valueOf((String)zjSummaryMap.get("isactive"));

                    summary.setId(id);
                    summary.setTyphoonNum(typhoonNum);
                    summary.setTyphoonNameEn(typhoonNameEn);
                    summary.setTyphoonNameZh(typhoonNameZh);
                    summary.setBirthDate(birthDate);
                    summary.setDeathDate(deathDate);
                    summary.setLifeTime(liftTime);
                    summary.setMinPressure(minPressure);
                    summary.setTyphoonStatus(typhoonStatus);
                    summaryList.add(summary);

                    for(Object route:jpRoutesList){
                        Map routeMap = (Map)route;
                        TyphoonRoute typhoonRoute = new TyphoonRoute();

                        String routeId = UUID.randomUUID().toString();
                        Integer centeredPressure = Integer.valueOf((String)routeMap.get("pressure"));
                        Timestamp dispTime = new Timestamp(Timestamp.valueOf(((String)(routeMap.get("time"))).substring(0,16) + ":00").getTime());
                        Integer typhoonClass = Integer.valueOf((String)routeMap.get("class"));
                        BigDecimal typhoonLat = BigDecimal.valueOf(Double.valueOf((String)routeMap.get("lat")));
                        BigDecimal typhoonLng = BigDecimal.valueOf(Double.valueOf((String)routeMap.get("lng")));
                        Integer winddStrength = Integer.valueOf((String)routeMap.get("wind"));

                        typhoonRoute.setId(routeId);
                        typhoonRoute.setTyphoonId(id);
                        typhoonRoute.setTyphoonNum(typhoonNum.toString());
                        typhoonRoute.setCenteredPressure(centeredPressure);
                        typhoonRoute.setDispTime(dispTime);
                        typhoonRoute.setTyphoonClass(typhoonClass);
                        typhoonRoute.setTyphoonLat(typhoonLat);
                        typhoonRoute.setTyphoonLng(typhoonLng);
                        typhoonRoute.setWinddStrength(winddStrength);

                        routeList.add(typhoonRoute);
                    }
                }
            });
        });

        resultMap.put("summary",summaryList);
        resultMap.put("route",routeList);
        return resultMap;
    }

    private Map getTyphoonDataJPDIGITAL(Integer year){
        Map activities=new HashMap();
        Map typhoonLists=typhoonListJPDIGITAL(year);
        typhoonLists.forEach((k,v)->{
            Map detail=new HashMap();
            List route=typhoonroutesJPDIGITAL(k.toString());
            detail.put("summary",v);
            detail.put("routes",route);
            activities.put(k.toString(),detail);
        });
        return activities;
    }

    private Map getTyphoonDataZJWATER(Integer year){
        String url=typhoonConfig.getZjwatertyphoonList();
        if (null==year){
            LocalDate localDate=LocalDate.now();
            url=url+localDate.getYear();
        }else {
            url=url+String.valueOf(year);
        }
        Document document= null;
        Map<String,Map> results=new HashMap<>();
        try {
            document= Jsoup.connect(url).timeout(10000).get();
            Elements phoons=document.getElementsByTag("TyphoonListModel");
            phoons.parallelStream().forEach(e->{
                String tfid=e.getElementsByTag("tfid").text();
                String name=e.getElementsByTag("name").text();
                String enname=e.getElementsByTag("enname").text();
                String starttime=e.getElementsByTag("starttime").text();
                String endtime=e.getElementsByTag("endtime").text();
                String isactive=e.getElementsByTag("isactive").text();
                String warnlevel=e.getElementsByTag("warnlevel").text();
                Map result=new HashMap();
                result.put("tfid",tfid);
                result.put("name",name);
                result.put("enname",enname);
                result.put("birth",starttime);
                result.put("death",endtime);
                result.put("isactive",isactive);
                result.put("warnlevel",warnlevel);
                results.put(tfid,result);
            });
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
        return results;
    }

    private Map typhoonListJPDIGITAL(Integer year){
        Document document= null;
        Map summary=new HashMap();
        String summary_year=typhoonConfig.getJpdigitalTyphoonList();
        if (null==year){
            LocalDate localDate=LocalDate.now();
            summary_year=summary_year.replace("{year}",String.valueOf(localDate.getYear()));
        }else {
            summary_year=summary_year.replace("{year}",String.valueOf(year));
        }
        try {
            document=Jsoup.connect(summary_year).timeout(6000).get();
            Elements elements = document.getElementsByClass("TABLELIST");
            if(!elements.isEmpty()){
                Element datatable= elements.get(0);
                Elements trs=datatable.children().get(0).children();
                if (trs.size()<=1){
                    return null;
                }else {
                    trs.remove(0);
                    trs.forEach(e->{
//                    Elements datarow=e.getAllElements();
                        Map<String,String> row=new HashMap();
                        row.put("tfid",e.child(1).text());
                        row.put("enname",e.child(2).text());
                        row.put("basin",e.child(3).text());
                        row.put("birth",e.child(4).text());
                        row.put("death",e.child(5).text());
                        row.put("minpress",e.child(7).text());
                        summary.put(e.child(1).text(),row);
                    });
                }
            }
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
        return summary;
    }

    private List typhoonroutesJPDIGITAL(String tfid){
        String url=typhoonConfig.getJpdigitalTyphoonInfo();
        url=url.replace("{tfid}",tfid);
        List result=new ArrayList();
        JSONObject jsonObject=JSONObject.parseObject(HTTPUtils.get(url));
        JSONArray jsonArray=JSONArray.parseArray(jsonObject.getString("features"));
        jsonArray.forEach(o -> {
            JSONObject info=(JSONObject) o;
            JSONObject geometry= JSONObject.parseObject(info.getString("geometry"));
            JSONArray coordinates=geometry.getJSONArray("coordinates");
            String lng=coordinates.getString(0);
            String lat=coordinates.getString(1);
            JSONObject properties= JSONObject.parseObject(info.getString("properties"));
            Map tf=new HashMap();
            tf.put("tfid",tfid);
            tf.put("lng",lng);
            tf.put("lat",lat);
            tf.put("wind",properties.get("wind"));
            tf.put("pressure",properties.get("pressure"));
            tf.put("class",properties.get("class"));
            tf.put("time",properties.get("display_time"));
            result.add(tf);
        });
        return result;
    }

}
