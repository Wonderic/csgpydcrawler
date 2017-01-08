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

/**
 * Created by huanm on 2016/12/6.
 */
@Component
public class TyphoonJob implements Job{

    @Autowired
    private TyphoonService typhoonService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
//        Map details1= typhoonService.typhoonListZJWATER(2016);
//        String base=SpringProperties.getProperty("Sourcezjwater.base");
//        String details=HTTPUtils.get("http://localhost:8080/typhoon/details");
        String startTime = SimpleDateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM).format(System.currentTimeMillis());
        System.out.println(startTime+" — TyphoonJob Job Start");

        Map details = typhoonService.typhoon(2016);
        String endTime = SimpleDateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM).format(System.currentTimeMillis());
        System.out.println(startTime+" — TyphoonJob Job End");
    }
}
