package com.kit.csg.crawler.index.job;

import com.kit.csg.crawler.index.service.IndexService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Map;

@Component
public class IndexJob implements Job{

    @Autowired
    private IndexService indexService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        String startTime = SimpleDateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM).format(System.currentTimeMillis());
        System.out.println(startTime+" — Index Job Start");

        Map data = indexService.crawlData();
//      boolean sendResult = SOAPUtils.send(data);
        if(true){
            indexService.saveData(data);
        }
        String endTime = SimpleDateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM).format(System.currentTimeMillis());
        System.out.println(endTime+" — Index Job End");
    }
}
