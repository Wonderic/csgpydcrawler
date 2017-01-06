package com.kit.csg.crawler.typhoon.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by furthers on 2016/12/14.
 */
@ConfigurationProperties(prefix = "typhoon.source.jpdigital")
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
