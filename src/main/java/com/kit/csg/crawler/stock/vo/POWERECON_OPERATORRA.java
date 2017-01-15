package com.kit.csg.crawler.stock.vo;

import java.sql.Timestamp;

/**
 * Created by Robin on 2016/9/26.
 */
public class POWERECON_OPERATORRA {
    private String ORID;
    private String OG_ID;
    private String ENTY_ID;
    private Double OPERATORRATE;
    private Timestamp ORDATETIME;
    private String ENSOURCE;
    private int ENINTERVAL;

    public String getORID() {
        return ORID;
    }

    public void setORID(String ORID) {
        this.ORID = ORID;
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

    public Timestamp getORDATETIME() {
        return ORDATETIME;
    }

    public void setORDATETIME(Timestamp ORDATETIME) {
        this.ORDATETIME = ORDATETIME;
    }

    public String getENSOURCE() {
        return ENSOURCE;
    }

    public void setENSOURCE(String ENSOURCE) {
        this.ENSOURCE = ENSOURCE;
    }

    public Double getOPERATORRATE() {
        return OPERATORRATE;
    }

    public void setOPERATORRATE(Double OPERATORRATE) {
        this.OPERATORRATE = OPERATORRATE;
    }

    public int getENINTERVAL() {
        return ENINTERVAL;
    }

    public void setENINTERVAL(int ENINTERVAL) {
        this.ENINTERVAL = ENINTERVAL;
    }
}
