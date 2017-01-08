package com.kit.csg.crawler.typhoon.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * Created by huanm on 2016/12/14.
 */
@PropertySource(value = { "classpath:application.properties" })
public class TyphoonConfig implements EnvironmentAware{
    private final Logger logger = LoggerFactory.getLogger(TyphoonConfig.class);
    @Value("${Sourcezjwater.base}")
    private String zjwaterBase;
    @Value("${Sourcezjwater.typhoonList}")
    private String zjwatertyphoonList;
    @Value("${Sourcezjwater.tyhoonActivity}")
    private String zjwatertyhoonActivity;
    @Value("${Sourcezjwater.typhoonInfo}")
    private String zjwatertyphoonInfo;
    @Value("${typhoon.routes.jpdigital.typhoonInfo}")
    private String jpdigitalTyphoonInfo;
    @Value("${typhoon.source.jpdigital.typhoonList}")
    private String jpdigitalTyphoonList;

    @Override
    public void setEnvironment(Environment environment) {
        logger.info(environment.getProperty("JAVA_HOME"));
        this.setZjwaterBase(environment.getProperty("Sourcezjwater.base"));
        this.setZjwatertyhoonActivity(environment.getProperty("Sourcezjwater.tyhoonActivity"));
        this.setZjwatertyphoonList(environment.getProperty("Sourcezjwater.typhoonList"));
        this.setZjwatertyphoonInfo(environment.getProperty("Sourcezjwater.typhoonInfo"));
        this.setJpdigitalTyphoonInfo(environment.getProperty("typhoon.routes.jpdigital.typhoonInfo"));
        this.setJpdigitalTyphoonList(environment.getProperty("typhoon.source.jpdigital.typhoonList"));

    }

    public String getZjwaterBase() {
        return zjwaterBase;
    }

    public void setZjwaterBase(String zjwaterBase) {
        this.zjwaterBase = zjwaterBase;
    }

    public String getZjwatertyphoonList() {
        return zjwatertyphoonList;
    }

    public void setZjwatertyphoonList(String zjwatertyphoonList) {
        this.zjwatertyphoonList = zjwatertyphoonList;
    }

    public String getZjwatertyhoonActivity() {
        return zjwatertyhoonActivity;
    }

    public void setZjwatertyhoonActivity(String zjwatertyhoonActivity) {
        this.zjwatertyhoonActivity = zjwatertyhoonActivity;
    }

    public String getZjwatertyphoonInfo() {
        return zjwatertyphoonInfo;
    }

    public void setZjwatertyphoonInfo(String zjwatertyphoonInfo) {
        this.zjwatertyphoonInfo = zjwatertyphoonInfo;
    }

    public String getJpdigitalTyphoonInfo() {
        return jpdigitalTyphoonInfo;
    }

    public void setJpdigitalTyphoonInfo(String jpdigitalTyphoonInfo) {
        this.jpdigitalTyphoonInfo = jpdigitalTyphoonInfo;
    }

    public String getJpdigitalTyphoonList() {
        return jpdigitalTyphoonList;
    }

    public void setJpdigitalTyphoonList(String jpdigitalTyphoonList) {
        this.jpdigitalTyphoonList = jpdigitalTyphoonList;
    }
}
