package com.kit.csg.crawler.internet.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Component
public class InternetJob implements Job{

//    @Autowired
//    private StockService stockService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        String startTime = SimpleDateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM).format(System.currentTimeMillis());
        System.out.println(startTime+" — InternetJob Job Start");

        String endTime = SimpleDateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM).format(System.currentTimeMillis());
        System.out.println(endTime+" — InternetJob Job End");
    }
}
