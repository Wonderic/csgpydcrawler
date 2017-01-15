package com.kit.csg.crawler.stock.vo;

import java.util.Date;

/**
 * Created by Robin on 2016/9/20.
 */
public class ELTP_DR_CLEAR_EVENT {
    private String ID;
    private String FLAG;
    private Double MPID;
    private Date BTIME;
    private Date ETIME;
    private Double VALUE1;
    private String STATUS;
    private String TYPE1;
    private Date DT;
    private String TYPE2;
    private Integer INTERVAL1;
    private String NOTE;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFLAG() {
        return FLAG;
    }

    public void setFLAG(String FLAG) {
        this.FLAG = FLAG;
    }

    public Double getMPID() {
        return MPID;
    }

    public void setMPID(Double MPID) {
        this.MPID = MPID;
    }

    public Date getBTIME() {
        return BTIME;
    }

    public void setBTIME(Date BTIME) {
        this.BTIME = BTIME;
    }

    public Date getETIME() {
        return ETIME;
    }

    public void setETIME(Date ETIME) {
        this.ETIME = ETIME;
    }

    public Double getVALUE1() {
        return VALUE1;
    }

    public void setVALUE1(Double VALUE1) {
        this.VALUE1 = VALUE1;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

    public String getTYPE1() {
        return TYPE1;
    }

    public void setTYPE1(String TYPE1) {
        this.TYPE1 = TYPE1;
    }

    public Date getDT() {
        return DT;
    }

    public void setDT(Date DT) {
        this.DT = DT;
    }

    public String getTYPE2() {
        return TYPE2;
    }

    public void setTYPE2(String TYPE2) {
        this.TYPE2 = TYPE2;
    }

    public Integer getINTERVAL1() {
        return INTERVAL1;
    }

    public void setINTERVAL1(Integer INTERVAL1) {
        this.INTERVAL1 = INTERVAL1;
    }

    public String getNOTE() {
        return NOTE;
    }

    public void setNOTE(String NOTE) {
        this.NOTE = NOTE;
    }
}
