package com.kit.csg.crawler.stock.job;

import com.kit.csg.crawler.stock.service.StockService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Map;


@Component
public class StockJob implements Job{

    @Autowired
    private StockService stockService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        String startTime = SimpleDateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM).format(System.currentTimeMillis());
        System.out.println(startTime+" — StockJob Job Start");

        Map data = stockService.crawlData();
//      boolean sendResult = SOAPUtils.send(data);
        if(true){
            stockService.saveData(data);
        }


        String endTime = SimpleDateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM).format(System.currentTimeMillis());
        System.out.println(endTime+" — StockJob Job End");
    }
}
