package com.kit.csg.crawler.stock.entity;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Robin on 2016-06-15.
 */
public class IndustryElectricity {

    static SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private String ICID;
    private String OG_ID;
    private String ENTY_ID;
    private BigDecimal DL;
    private Date ICDATETIME;
    private String ENSOURCE;
    private int ENINTERVAL;

    public String getICID() {
        return ICID;
    }

    public void setICID(String ICID) {
        this.ICID = ICID;
    }

    public String getOG_ID() {
        return OG_ID;
    }

    public void setOG_ID(String OG_ID) {
        this.OG_ID = OG_ID;
    }

    public String getENTY_ID() {
        return ENTY_ID;
    }

    public void setENTY_ID(String ENTY_ID) {
        this.ENTY_ID = ENTY_ID;
    }

    public BigDecimal getDL() {
        return DL;
    }

    public void setDL(BigDecimal DL) {
        this.DL = DL;
    }

    public Date getICDATETIME() {
        return ICDATETIME;
    }

    public void setICDATETIME(Date ICDATETIME) {
        this.ICDATETIME = ICDATETIME;
    }

    public String getENSOURCE() {
        return ENSOURCE;
    }

    public void setENSOURCE(String ENSOURCE) {
        this.ENSOURCE = ENSOURCE;
    }

    public int getENINTERVAL() {
        return ENINTERVAL;
    }



    public void setENINTERVAL(int ENINTERVAL) {
        this.ENINTERVAL = ENINTERVAL;
    }
    @Override
    public String toString() {

        return "IndustryElectricity{" +
                "ICID='" + ICID + '\'' +
                ", OG_ID='" + OG_ID + '\'' +
                ", ENTY_ID='" + ENTY_ID + '\'' +
                ", DL=" + DL +
                ", ICDATETIME=" + simpleDateFormat.format(ICDATETIME) +
                ", ENSOURCE='" + ENSOURCE + '\'' +
                ", ENINTERVAL=" + ENINTERVAL +
                '}';
    }
}
