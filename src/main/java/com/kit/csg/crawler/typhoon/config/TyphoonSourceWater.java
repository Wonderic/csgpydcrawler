package com.kit.csg.crawler.typhoon.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by furthers on 2016/12/14.
 */
@ConfigurationProperties(prefix = "Sourcezjwater")
@PropertySource(value = { "classpath:application.properties" })
public class TyphoonSourceWater {
    private String base;
    private String typhoonList;
    private String tyhoonActivity;
    private String typhoonInfo;

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getTyphoonList() {
        return typhoonList;
    }

    public void setTyphoonList(String typhoonList) {
        this.typhoonList = typhoonList;
    }

    public String getTyhoonActivity() {
        return tyhoonActivity;
    }

    public void setTyhoonActivity(String tyhoonActivity) {
        this.tyhoonActivity = tyhoonActivity;
    }

    public String getTyphoonInfo() {
        return typhoonInfo;
    }

    public void setTyphoonInfo(String typhoonInfo) {
        this.typhoonInfo = typhoonInfo;
    }
}
