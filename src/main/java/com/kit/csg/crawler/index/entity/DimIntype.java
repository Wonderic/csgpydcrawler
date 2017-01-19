package com.kit.csg.crawler.index.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "DIM_INTYPE")
public class DimIntype implements Serializable {
    @Id
    @Column(name = "INDEXTYPE_ID")
    private String indextypeId;
    @Column(name = "INDETYPENAME")
    private String indetypename;
    @Column(name = "UNIT")
    private String unit;
    @Column(name = "STATASTREEID")
    private String statastreeid;
    @Column(name = "SELFTREEID")
    private String selftreeid;
    @Column(name = "COMM")
    private String comm;
    @Column(name = "EXP")
    private String exp;
    @Column(name = "SCOPE")
    private String scope;
    @Column(name = "SOURCE")
    private String source;
    @Column(name = "SOURCEKEY")
    private String sourcekey;
    @Column(name = "TIMETYPE")
    private String timeType;

    public String getIndextypeId() {
        return indextypeId;
    }

    public void setIndextypeId(String indextypeId) {
        this.indextypeId = indextypeId;
    }

    public String getIndetypename() {
        return indetypename;
    }

    public void setIndetypename(String indetypename) {
        this.indetypename = indetypename;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getStatastreeid() {
        return statastreeid;
    }

    public void setStatastreeid(String statastreeid) {
        this.statastreeid = statastreeid;
    }

    public String getSelftreeid() {
        return selftreeid;
    }

    public void setSelftreeid(String selftreeid) {
        this.selftreeid = selftreeid;
    }

    public String getComm() {
        return comm;
    }

    public void setComm(String comm) {
        this.comm = comm;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSourcekey() {
        return sourcekey;
    }

    public void setSourcekey(String sourcekey) {
        this.sourcekey = sourcekey;
    }

    public String getTimeType() {
        return timeType;
    }

    public void setTimeType(String timeType) {
        this.timeType = timeType;
    }
}