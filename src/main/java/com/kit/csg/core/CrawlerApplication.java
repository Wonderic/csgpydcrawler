package com.kit.csg.core;

import com.kit.csg.crawler.index.job.IndexJob;
import com.kit.csg.crawler.internet.job.InternetJob;
import com.kit.csg.crawler.stock.job.StockJob;
import com.kit.csg.crawler.typhoon.job.TyphoonJob;
import com.kit.csg.crawler.weather.job.WeatherJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages={"com.kit.csg"})
@EntityScan(basePackages = "com.kit.csg.crawler")
@EnableJpaRepositories(basePackages = "com.kit.csg.crawler")
public class CrawlerApplication {
    public static void main(String[] args) {
		SpringApplication.run(CrawlerApplication.class, args);
		Scheduler scheduler=null;
		try {
			scheduler= StdSchedulerFactory.getDefaultScheduler();
			SpringBeanJobFactory springBeanJobFactory = new SpringBeanJobFactory();
			scheduler.setJobFactory(springBeanJobFactory);
			scheduler.start();

			//台风数据
			JobDetail typhoonJobDetail= JobBuilder.newJob(TyphoonJob.class).withIdentity("typhoon","csgpydcrawler").build();

			//天气数据
			JobDetail weatherJobDetail= JobBuilder.newJob(WeatherJob.class).withIdentity("weather","csgpydcrawler").build();

			//股票数据
			JobDetail stockJobDetail= JobBuilder.newJob(StockJob.class).withIdentity("stock","csgpydcrawler").build();

			//统计局数据
			JobDetail indexJobDetail= JobBuilder.newJob(IndexJob.class).withIdentity("index","csgpydcrawler").build();

			//百度、阿里数据
			JobDetail internetJobDetail= JobBuilder.newJob(InternetJob.class).withIdentity("internet","csgpydcrawler").build();

			scheduler.scheduleJob(typhoonJobDetail,TriggerBuilder.newTrigger().withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(20).repeatForever()).build());
			scheduler.scheduleJob(weatherJobDetail,TriggerBuilder.newTrigger().withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(20).repeatForever()).build());
			scheduler.scheduleJob(stockJobDetail,TriggerBuilder.newTrigger().withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(20).repeatForever()).build());
			scheduler.scheduleJob(indexJobDetail,TriggerBuilder.newTrigger().withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(20).repeatForever()).build());
			scheduler.scheduleJob(internetJobDetail,TriggerBuilder.newTrigger().withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(20).repeatForever()).build());
		}catch (SchedulerException e){
			e.printStackTrace();
		}
	}
}
