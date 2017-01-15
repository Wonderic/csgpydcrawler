package com.kit.csg.crawler.stock.vo;

import java.math.BigDecimal;

public class PowereconIntype {
    private BigDecimal indextypeId;

    private String indetypename;

    private String unit;

    private BigDecimal statastreeid;

    private BigDecimal selftreeid;

    private String comment;

    private String exp;

    private String scope;

    private String source;

    private String sourcekey;

    private String timetype;

    public BigDecimal getIndextypeId() {
        return indextypeId;
    }

    public void setIndextypeId(BigDecimal indextypeId) {
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

    public BigDecimal getStatastreeid() {
        return statastreeid;
    }

    public void setStatastreeid(BigDecimal statastreeid) {
        this.statastreeid = statastreeid;
    }

    public BigDecimal getSelftreeid() {
        return selftreeid;
    }

    public void setSelftreeid(BigDecimal selftreeid) {
        this.selftreeid = selftreeid;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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

    public String getTimetype() {
        return timetype;
    }

    public void setTimetype(String timetype) {
        this.timetype = timetype;
    }
}