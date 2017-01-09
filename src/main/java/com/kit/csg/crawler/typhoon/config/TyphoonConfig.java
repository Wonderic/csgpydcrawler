package com.kit.csg.crawler.typhoon.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by huanm on 2016/12/14.
 */
@PropertySource(value = { "classpath:application.properties" })
@ConfigurationProperties
public class TyphoonConfig {
    private final Logger logger = LoggerFactory.getLogger(TyphoonConfig.class);
    String zjwaterBase;
    String zjwatertyphoonList;
    String zjwatertyhoonActivity;
    String zjwatertyphoonInfo;
    String jpdigitalTyphoonInfo;
    String jpdigitalTyphoonList;

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
