package com.kit.csg.crawler.stock.entity;

/**
 * Created by Robin on 2016/9/12.
 */

/**
 * Created by Robin on 2016-06-15.
 */
public class Industry_OrganizationStructur {
    private String OG_ID;
    private String OG_NAME;
    private int OG_LEVEL;
    private String OG_PARENT;

    public String getOG_ID() {
        return OG_ID;
    }

    public void setOG_ID(String OG_ID) {
        this.OG_ID = OG_ID;
    }

    public String getOG_NAME() {
        return OG_NAME;
    }

    public void setOG_NAME(String OG_NAME) {
        this.OG_NAME = OG_NAME;
    }

    public int getOG_LEVEL() {
        return OG_LEVEL;
    }

    public void setOG_LEVEL(int OG_LEVEL) {
        this.OG_LEVEL = OG_LEVEL;
    }

    public String getOG_PARENT() {
        return OG_PARENT;
    }

    public void setOG_PARENT(String OG_PARENT) {
        this.OG_PARENT = OG_PARENT;
    }
}