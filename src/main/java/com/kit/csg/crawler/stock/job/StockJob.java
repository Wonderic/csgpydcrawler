package com.kit.csg.crawler.stock.job;

import com.kit.csg.crawler.stock.service.StockService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;


@Component
public class StockJob implements Job{

    @Autowired
    private StockService stockService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        String startTime = SimpleDateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM).format(System.currentTimeMillis());
        System.out.println(startTime+" — StockJob Job Start");

        stockService.crawlData();

        String endTime = SimpleDateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM).format(System.currentTimeMillis());
        System.out.println(endTime+" — StockJob Job End");
    }
}
