package com.kit.csg.crawler.weather.job;

import com.kit.csg.crawler.weather.service.CloudWeatherService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Map;

@Component
public class WeatherJob implements Job{

    @Autowired
    private CloudWeatherService cloudWeatherService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        String startTime = SimpleDateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM).format(System.currentTimeMillis());
        System.out.println(startTime+" — WeatherJob Job Start");


        Map data = cloudWeatherService.crawlData();
//        boolean sendResult = SOAPUtils.send(data);
        if(true){
            cloudWeatherService.saveData(data);
        }

        String endTime = SimpleDateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM).format(System.currentTimeMillis());
        System.out.println(endTime+" — WeatherJob Job End");
    }
}
