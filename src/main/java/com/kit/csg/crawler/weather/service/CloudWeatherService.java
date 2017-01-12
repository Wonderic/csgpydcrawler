package com.kit.csg.crawler.weather.service;

import com.kit.csg.crawler.weather.entity.CITY;
import com.kit.csg.crawler.weather.entity.CLOUD_WEATHER_TABLE;
import com.kit.csg.crawler.weather.repository.CityRepository;
import com.kit.csg.crawler.weather.repository.CloudWeatherRepository;
import com.kit.csg.utils.HTTPUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import javax.annotation.Resource;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service("cloudWeatherService")
@Transactional
public class CloudWeatherService {
    @Resource(name = "cloudWeatherRepository")
    CloudWeatherRepository cloudWeatherRepository;

    @Resource(name="cityRepository")
    CityRepository cityRepository;

    private static final String URL = "http://sixweather.3gpk.net/SixWeather.aspx?city=%s";

    public List<CLOUD_WEATHER_TABLE> findAll(){
      return  cloudWeatherRepository.findAll();
    }

    public void save(CLOUD_WEATHER_TABLE cloud_weather_table){
        cloudWeatherRepository.save(cloud_weather_table);
    }

    public void save(List<CLOUD_WEATHER_TABLE> list){
        cloudWeatherRepository.save(list);
    }

    public boolean crawlData() {
        String formatUrl;
        ArrayList<CLOUD_WEATHER_TABLE> weatherlist;
        ArrayList<CLOUD_WEATHER_TABLE> updateWeatherList;
        String result = "";

        // init
        weatherlist = new ArrayList<>();
        updateWeatherList = new ArrayList<>();

        List<CITY> cityList = cityRepository.findAll();

        //=============设置需要返回的数据量
        for (int i = 0; i < cityList.size(); i++) {
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            //下载数据
            try {
                formatUrl = String.format(URL,
                        URLEncoder.encode(cityList.get(i).getName()));
                result = HTTPUtils.HttpGetJson(formatUrl);
            } catch (IOException e) {
//                // TODO Auto-generated catch block
//                CityError ce = new CityError();
//                ce.setCityName(cityListss.get(i).getString("name"));
//                ce.setErrorInfo(e.getMessage());
//                logger.error(ce.toString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // System.out.println(result);
            CLOUD_WEATHER_TABLE weatherInfo = parseWeatherInfo(result);
            weatherlist.add(weatherInfo);
            if (weatherlist.size() >= 100) {
               // liveWeatherMapper.insertData(weatherlist);
                //SendData_ASN(weatherlist, Const.DayWeather.get());
                weatherlist =new ArrayList<>();
            }

        }
        if (weatherlist.size() > 0) {
            //SendData_ASN(weatherlist, Const.DayWeather.get());
        }

        return false;
    }


    public static CLOUD_WEATHER_TABLE parseWeatherInfo(String result) {
        CLOUD_WEATHER_TABLE weather_table = null;
        try {
            XmlPullParser xmlPullParser = XmlPullParserFactory.newInstance()
                    .newPullParser();
            xmlPullParser.setInput(new ByteArrayInputStream(result.getBytes()),
                    "UTF-8");
            int eventType = xmlPullParser.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                String nodeName = xmlPullParser.getName();
                switch (eventType) {

                    case XmlPullParser.START_DOCUMENT: // 开头
                        weather_table = new CLOUD_WEATHER_TABLE();
                        break;
                    case XmlPullParser.START_TAG:// tag 头
                        assert weather_table != null;
                        if (nodeName.equals("city")) {
                            weather_table.setCITY_NAME(xmlPullParser.nextText());
                        } else if (nodeName.equals("yujing")) {
                            weather_table.setYUJING(xmlPullParser.nextText());
                        } else if (nodeName.equals("alarmtext")) {
                            weather_table.setALARMTEXT(xmlPullParser.nextText());
                        } else if (nodeName.equals("warning")) {
                            weather_table.setWARNING(xmlPullParser.nextText());
                        } else if (nodeName.equals("temp0")) {
                            weather_table.setTEMP0(xmlPullParser.nextText());
                        } else if (nodeName.equals("temp1")) {
                            weather_table.setTEMP1(xmlPullParser.nextText());
                        } else if (nodeName.equals("temp2")) {
                            weather_table.setTEMP2(xmlPullParser.nextText());
                        } else if (nodeName.equals("temp3")) {
                            weather_table.setTEMP3(xmlPullParser.nextText());
                        } else if (nodeName.equals("temp4")) {
                            weather_table.setTEMP4(xmlPullParser.nextText());
                        } else if (nodeName.equals("temp5")) {
                            weather_table.setTEMP5(xmlPullParser.nextText());
                        } else if (nodeName.equals("temp6")) {
                            weather_table.setTEMP6(xmlPullParser.nextText());
                        } else if (nodeName.equals("weather0")) {
                            weather_table.setWEATHER0(xmlPullParser.nextText());
                        } else if (nodeName.equals("weather1")) {
                            weather_table.setWEATHER1(xmlPullParser.nextText());
                        } else if (nodeName.equals("weather2")) {
                            weather_table.setWEATHER2(xmlPullParser.nextText());
                        } else if (nodeName.equals("weather3")) {
                            weather_table.setWEATHER3(xmlPullParser.nextText());
                        } else if (nodeName.equals("weather4")) {
                            weather_table.setWEATHER4(xmlPullParser.nextText());
                        } else if (nodeName.equals("weather5")) {
                            weather_table.setWEATHER5(xmlPullParser.nextText());
                        } else if (nodeName.equals("weather6")) {
                            weather_table.setWEATHER6(xmlPullParser.nextText());
                        } else if (nodeName.equals("wind0")) {
                            weather_table.setWIND0(xmlPullParser.nextText());
                        } else if (nodeName.equals("wind1")) {
                            weather_table.setWIND1(xmlPullParser.nextText());
                        } else if (nodeName.equals("wind2")) {
                            weather_table.setWIND2(xmlPullParser.nextText());
                        } else if (nodeName.equals("wind3")) {
                            weather_table.setWIND3(xmlPullParser.nextText());
                        } else if (nodeName.equals("wind4")) {
                            weather_table.setWIND4(xmlPullParser.nextText());
                        } else if (nodeName.equals("wind5")) {
                            weather_table.setWIND5(xmlPullParser.nextText());
                        } else if (nodeName.equals("wind6")) {
                            weather_table.setWIND6(xmlPullParser.nextText());
                        } else if (nodeName.equals("intime")) {
                            weather_table.setINTIME(xmlPullParser.nextText());
                        } else if (nodeName.equals("tempNow")) {
                            weather_table.setTEMPNOW(xmlPullParser.nextText());
                        } else if (nodeName.equals("shidu")) {
                            weather_table.setSHIDU(xmlPullParser.nextText());
                        } else if (nodeName.equals("winNow")) {
                            weather_table.setWINDINFO(xmlPullParser.nextText());
                        } else if (nodeName.equals("feelTemp")) {
                            weather_table.setFEELTEMP(xmlPullParser.nextText());
                        } else if (nodeName.equals("shiduNow")) {
                            weather_table.setSHIDUNOW(xmlPullParser.nextText());
                        } else if (nodeName.equals("todaySun")) {
                            weather_table.setTODAYSUN(xmlPullParser.nextText());
                        } else if (nodeName.equals("tomorrowSun")) {
                            weather_table.setTOMORROWSUN(xmlPullParser.nextText());
                        } else if (nodeName.equals("AQIData")) {
                            weather_table.setAQIDATA(xmlPullParser.nextText());
                        } else if (nodeName.equals("PM2Dot5Data")) {
                            weather_table.setPM2DOT5DATA(xmlPullParser.nextText());
                        } else if (nodeName.equals("PM10Data")) {
                            weather_table.setPM10DATA(xmlPullParser.nextText());
                        }
                        break;

                    case XmlPullParser.END_TAG:// 结束tag 头
                        weather_table.setID(UUID.randomUUID().toString().replace("-", "").substring(1, 16));
                        break;

                    default:
                        break;
                }
                eventType = xmlPullParser.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return weather_table;
    }

}