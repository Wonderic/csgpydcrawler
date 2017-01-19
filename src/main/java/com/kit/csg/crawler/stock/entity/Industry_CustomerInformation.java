package com.kit.csg.crawler.stock.entity;

/**
 * Created by Robin on 2016-06-15.
 */
public class Industry_CustomerInformation {
    private String LAPC_ID;
    private String CUSTOMER_ID;
    private String LAPC_NAME;
    private String OG_ID;
    private String CUSID;

    public String getCUSID() {
        return CUSID;
    }

    public void setCUSID(String CUSID) {
        this.CUSID = CUSID;
    }

    public String getOG_ID() {
        return OG_ID;
    }

    public void setOG_ID(String OG_ID) {
        this.OG_ID = OG_ID;
    }

    public String getLAPC_ID() {
        return LAPC_ID;
    }

    public void setLAPC_ID(String LAPC_ID) {
        this.LAPC_ID = LAPC_ID;
    }

    public String getCUSTOMER_ID() {
        return CUSTOMER_ID;
    }

    public void setCUSTOMER_ID(String CUSTOMER_ID) {
        this.CUSTOMER_ID = CUSTOMER_ID;
    }

    public String getLAPC_NAME() {
        return LAPC_NAME;
    }

    public void setLAPC_NAME(String LAPC_NAME) {
        this.LAPC_NAME = LAPC_NAME;
    }
}
