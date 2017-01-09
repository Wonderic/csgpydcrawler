package com.kit.csg.crawler.typhoon.job;

import com.kit.csg.crawler.typhoon.service.TyphoonService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Map;

@Component
public class TyphoonJob implements Job{

    @Autowired
    private TyphoonService typhoonService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        String startTime = SimpleDateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM).format(System.currentTimeMillis());
        System.out.println(startTime+" — TyphoonJob Job Start");

        Map details1 = typhoonService.getTyphoonDataJPDIGITAL(2016);
        Map details2 = typhoonService.getTyphoonDataZJWATER(2016);
        System.out.println(details1.toString());
        System.out.println(details2.toString());

        String endTime = SimpleDateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM).format(System.currentTimeMillis());
        System.out.println(endTime+" — TyphoonJob Job End");
    }
}
