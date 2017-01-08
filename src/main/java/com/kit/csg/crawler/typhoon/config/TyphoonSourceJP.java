package com.kit.csg.crawler.typhoon.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by furthers on 2016/12/14.
 */
@ConfigurationProperties(prefix = "typhoon.source.jpdigital")
@PropertySource(value = { "classpath:application.properties" })
public class TyphoonSourceJP {
    private String typhoonList;
    private String typhoonInfo;

    public String getTyphoonList() {
        return typhoonList;
    }

    public void setTyphoonList(String typhoonList) {
        this.typhoonList = typhoonList;
    }

    public String getTyphoonInfo() {
        return typhoonInfo;
    }

    public void setTyphoonInfo(String typhoonInfo) {
        this.typhoonInfo = typhoonInfo;
    }
}
