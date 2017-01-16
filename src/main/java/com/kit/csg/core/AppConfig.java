package com.kit.csg.core;

import com.kit.csg.crawler.typhoon.config.TyphoonConfig;
import org.quartz.spi.JobFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootConfiguration
@ComponentScan
@EnableTransactionManagement
@EnableJpaRepositories
@PropertySource(value = { "classpath:application.properties" })
public class AppConfig
{
    @Autowired
    private Environment env;

    @Bean
    public JobFactory jobFactory(){
        return new SpringBeanJobFactory();
    }

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(JobFactory jobFactory){
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setJobFactory(jobFactory);
        return schedulerFactoryBean;
    }

    @Bean(name="typhoonConfig")
    public TyphoonConfig typhoonConfig(){
        TyphoonConfig typhoonConfig = new TyphoonConfig();
        typhoonConfig.setZjwaterBase(env.getProperty("typhoon.source.zjwater.base"));
        typhoonConfig.setZjwatertyphoonInfo(env.getProperty("typhoon.source.zjwater.typhoonInfo"));
        typhoonConfig.setZjwatertyphoonList(env.getProperty("typhoon.source.zjwater.typhoonList"));
        typhoonConfig.setZjwatertyhoonActivity(env.getProperty("typhoon.source.zjwater.tyhoonActivity"));

        typhoonConfig.setJpdigitalTyphoonInfo(env.getProperty("typhoon.routes.jpdigital.typhoonInfo"));
        typhoonConfig.setJpdigitalTyphoonList(env.getProperty("typhoon.source.jpdigital.typhoonList"));
        return typhoonConfig;
    }

}