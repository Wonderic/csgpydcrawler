package com.kit.csg.crawler.typhoon.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kit.csg.utils.HTTPUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by huanm on 2016/12/14.
 */
@Service("typhoonService")
public class TyphoonService {
    @Autowired
    private Environment env;

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public Map typhoon(Integer year){
        TyphoonUtils phoonUtils=new TyphoonUtils();
        Map activities=new HashMap();
        Map typhoonLists=phoonUtils.typhoonListJPDIGITAL(year);
        typhoonLists.forEach((k,v)->{
            Map detail=new HashMap();
            List route=phoonUtils.phoonroutesJPDIGITAL(k.toString());
            detail.put("summary",v);
            detail.put("routes",route);
            activities.put(k.toString(),detail);
        });
        return activities;
    }

    public Map typhoonListZJWATER(Integer year){
        String url=env.getProperty("typhoon.source.zjwater.typhoonList");
//        String url=properties.getProperty("typhoon.source.zjwater.typhoonList");
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
    public Map typhoonInfoZJWATER(String tfid){
//        String url=properties.getProperty("typhoon.source.zjwater.typhoonInfo");
        return null;
    }
    public Map typhoonListJPDIGITAL(Integer year){
        Document document= null;
        Map summary=new HashMap();
        String summary_year=env.getProperty("typhoon.source.jpdigital.typhoonList");
//        String summary_year=TyphoonSourceWater.typhoonList;
//        String summary_year=properties.getProperty("typhoon.source.jpdigital.typhoonList");
        if (null==year){
            LocalDate localDate=LocalDate.now();
            summary_year=summary_year.replace("{year}",String.valueOf(localDate.getYear()));
        }else {
            summary_year=summary_year.replace("{year}",String.valueOf(year));
        }
        try {
            document=Jsoup.connect(summary_year).timeout(6000).get();
            Element datatable=document.getElementsByClass("TABLELIST").get(0);
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
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
        return summary;
    }
    public List phoonroutesJPDIGITAL(String tfid){
//        String url=TyphoonSourceJP.typhoonList;
        String url=env.getProperty("typhoon.routes.jpdigital.typhoonInfo");
//        String url=properties.getProperty("typhoon.routes.jpdigital.typhoonInfo");
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

    public HSSFSheet data2sheet(Map data){
        HSSFWorkbook workbook=new HSSFWorkbook();
        HSSFSheet sheet=workbook.createSheet("typhoon");
        String[] title={"台风编号","台风信息","台风路径"};
        HSSFRow headRow=sheet.createRow(1);
        for (int i = 0; i < title.length; i++) {
            Cell cell=headRow.createCell(i);
            cell.setCellValue(title[i]);
        }
        HSSFRow summary=sheet.createRow(2);

        HSSFRow tfroute=sheet.createRow(3);
//        tfidRow

        return sheet;
    }

}
