package com.kit.csg.crawler.stock.entity;

/**
 * Created by Robin on 2016/10/11.
 */

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

/** 上市公司月股票价格数据
 *
 **/
@Entity
@Table(name="POWERECON_STOCKMONTHPRICE")
public class POWERECON_STOCKMONTHPRICE implements Serializable {
    /**
     *流水号
     **
     */
    @Id
    @Column(columnDefinition = "nvarchar2(255 )",insertable =  false, updatable = false)
    @org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private String SMPID;
    /** 股票代码
     *
     **/
    @Column(columnDefinition = "number(0,0)",insertable =  false, updatable = false)
    private String STOCKCODE;
    /** 开盘价
     *
     **/
    @Column(columnDefinition = "number(0,0)",insertable =  false, updatable = false)
    private Double OPENQUOTATION=0D;
    /** 收盘价
     *
     **/
    @Column(columnDefinition = "number(0,0)",insertable =  false, updatable = false)
    private Double CLOSINGPRICE=0D;
    /** 最高价格
     *
     **/
    @Column(columnDefinition = "number(0,0)",insertable =  false, updatable = false)
    private Double MAXPRICE=0D;
    /** 最低价格
     *
     */
    @Column(columnDefinition = "number(0,0)",insertable =  false, updatable = false)
    private Double MINPRICE=0D;
    /**
     *  日期时间
     */@Column(insertable =  false, updatable = false)
    private Timestamp PDATE;
    /**
     * 类型   01为复权,02 为不复权
     */
    private String TYPE;

    public String getTYPE() {
        return TYPE;
    }

    public void setTYPE(String TYPE) {
        this.TYPE = TYPE;
    }

    public Timestamp getPDATE() {
        return PDATE;
    }

    public void setPDATE(Timestamp PDATE) {
        this.PDATE = PDATE;
    }

    public String getSMPID() {
        return SMPID;
    }

    public void setSMPID(String SMPID) {
        this.SMPID = SMPID;
    }

    public String getSTOCKCODE() {
        return STOCKCODE;
    }

    public void setSTOCKCODE(String STOCKCODE) {
        this.STOCKCODE = STOCKCODE;
    }

    public Double getOPENQUOTATION() {
        return OPENQUOTATION;
    }

    public void setOPENQUOTATION(Double OPENQUOTATION) {
        this.OPENQUOTATION = OPENQUOTATION;
    }

    public Double getCLOSINGPRICE() {
        return CLOSINGPRICE;
    }

    public void setCLOSINGPRICE(Double CLOSINGPRICE) {
        this.CLOSINGPRICE = CLOSINGPRICE;
    }

    public Double getMAXPRICE() {
        return MAXPRICE;
    }

    public void setMAXPRICE(Double MAXPRICE) {
        this.MAXPRICE = MAXPRICE;
    }

    public Double getMINPRICE() {
        return MINPRICE;
    }

    public void setMINPRICE(Double MINPRICE) {
        this.MINPRICE = MINPRICE;
    }

    
    public Timestamp getTime() {
        return getPDATE();
    }

    
    public void setTime(Timestamp time) {
        setPDATE(time);
    }


    
    public Double getValue() {
        return getCLOSINGPRICE();
    }

    
    public void setValue(Double value) {
        setCLOSINGPRICE(value);
    }

    
    public String toString() {
        return "POWERECON_STOCKMONTHPRICE{" +
                "SMPID='" + SMPID + '\'' +
                ", STOCKCODE='" + STOCKCODE + '\'' +
                ", OPENQUOTATION=" + OPENQUOTATION +
                ", CLOSINGPRICE=" + CLOSINGPRICE +
                ", MAXPRICE=" + MAXPRICE +
                ", MINPRICE=" + MINPRICE +
                ", PDATE=" + PDATE +
                ", TYPE='" + TYPE + '\'' +
                '}';
    }
}