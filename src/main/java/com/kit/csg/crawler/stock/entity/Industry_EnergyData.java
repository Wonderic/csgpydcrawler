package com.kit.csg.crawler.stock.entity;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Robin on 2016-06-15.
 */
public class Industry_EnergyData {

    static SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private String ENID;
    private BigDecimal DL;
    private Date ENDATE;
    private String ENSOURCE;
    private int ENINTERVAL;
    private String LAPC_ID;

    public String getENID() {
        return ENID;
    }

    public void setENID(String ENID) {
        this.ENID = ENID;
    }

    public BigDecimal getDL() {
        return DL;
    }

    public void setDL(BigDecimal DL) {
        this.DL = DL;
    }

    public Date getENDATE() {
        return ENDATE;
    }

    public void setENDATE(Date ENDATE) {
        this.ENDATE = ENDATE;
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

    public String getLAPC_ID() {
        return LAPC_ID;
    }

    public void setLAPC_ID(String LAPC_ID) {
        this.LAPC_ID = LAPC_ID;
    }

    @Override
    public String toString() {
        return "Industry_EnergyData{" +
                "ENID='" + ENID + '\'' +
                ", DL=" + DL +
                ", ENDATE=" + simpleDateFormat.format(ENDATE) +
                ", ENSOURCE='" + ENSOURCE + '\'' +
                ", ENINTERVAL=" + ENINTERVAL +
                ", LAPC_ID='" + LAPC_ID + '\'' +
                '}';
    }
}
