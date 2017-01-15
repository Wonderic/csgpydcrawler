package com.kit.csg.crawler.stock.vo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Robin on 2016-06-22.
 */
public class Industry_OutageTime {
    private String OID;
    private String COSUMERID;
    private int OTCID;
    private Date ODATE;
    private Timestamp INTERRUPTIONBEGIN;
    private Timestamp INTERRUPTIONEND;
    private BigDecimal TIMESPAN;
    private int TEID;
    private int COSUMERINUMS;
    private BigDecimal INTERRUPTIONCAPA;
    private String OG_ID;

    public String getOID() {
        return OID;
    }

    public void setOID(String OID) {
        this.OID = OID;
    }

    public String getCOSUMERID() {
        return COSUMERID;
    }

    public void setCOSUMERID(String COSUMERID) {
        this.COSUMERID = COSUMERID;
    }

    public int getOTCID() {
        return OTCID;
    }

    public void setOTCID(int OTCID) {
        this.OTCID = OTCID;
    }

    public Date getODATE() {
        return ODATE;
    }

    public void setODATE(Date ODATE) {
        this.ODATE = ODATE;
    }

    public Timestamp getINTERRUPTIONBEGIN() {
        return INTERRUPTIONBEGIN;
    }

    public void setINTERRUPTIONBEGIN(Timestamp INTERRUPTIONBEGIN) {
        this.INTERRUPTIONBEGIN = INTERRUPTIONBEGIN;
    }

    public Timestamp getINTERRUPTIONEND() {
        return INTERRUPTIONEND;
    }

    public void setINTERRUPTIONEND(Timestamp INTERRUPTIONEND) {
        this.INTERRUPTIONEND = INTERRUPTIONEND;
    }

    public BigDecimal getTIMESPAN() {
        return TIMESPAN;
    }

    public void setTIMESPAN(BigDecimal TIMESPAN) {
        this.TIMESPAN = TIMESPAN;
    }

    public int getTEID() {
        return TEID;
    }

    public void setTEID(int TEID) {
        this.TEID = TEID;
    }

    public int getCOSUMERINUMS() {
        return COSUMERINUMS;
    }

    public void setCOSUMERINUMS(int COSUMERINUMS) {
        this.COSUMERINUMS = COSUMERINUMS;
    }

    public BigDecimal getINTERRUPTIONCAPA() {
        return INTERRUPTIONCAPA;
    }

    public void setINTERRUPTIONCAPA(BigDecimal INTERRUPTIONCAPA) {
        this.INTERRUPTIONCAPA = INTERRUPTIONCAPA;
    }

    public String getOG_ID() {
        return OG_ID;
    }

    public void setOG_ID(String OG_ID) {
        this.OG_ID = OG_ID;
    }
}
