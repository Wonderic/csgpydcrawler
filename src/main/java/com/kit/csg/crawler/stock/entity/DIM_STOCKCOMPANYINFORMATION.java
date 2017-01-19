package com.kit.csg.crawler.stock.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Robin on 2016/8/30.
 */
@Entity
@Table(name="DIM_STOCKCOMPANYINFORMATION")
public class DIM_STOCKCOMPANYINFORMATION implements Serializable {
    @Id
    @Column
    private String COMPANYCODE;
    @Column
    private String COMPANYNAME;
    @Column
    private String STOCKACODE;
    @Column
    private String STOCKANAME;
    @Column
    private Timestamp STOCKADATE;
    @Column
    private String STOCKBCODE;
    @Column
    private String STOCKBNAME;
    @Column
    private Timestamp STOCKBDATE;
    @Column
    private String PROVIDENAME;
    @Column
    private String CITY;
    @Column
    private String CSRC;

    public String getCITY() {
        return CITY;
    }

    public void setCITY(String CITY) {
        this.CITY = CITY;
    }

    @Id
    @Column(name = "COMPANYCODE", nullable = false, length = 255)
    public String getCOMPANYCODE() {
        return COMPANYCODE;
    }

    public void setCOMPANYCODE(String COMPANYCODE) {
        this.COMPANYCODE = COMPANYCODE;
    }

    @Basic
    @Column(name = "COMPANYNAME", nullable = true, length = 255)
    public String getCOMPANYNAME() {
        return COMPANYNAME;
    }

    public void setCOMPANYNAME(String COMPANYNAME) {
        this.COMPANYNAME = COMPANYNAME;
    }

    @Basic
    @Column(name = "STOCKACODE", nullable = true, length = 255)
    public String getSTOCKACODE() {
        return STOCKACODE;
    }

    public void setSTOCKACODE(String STOCKACODE) {
        this.STOCKACODE = STOCKACODE;
    }

    @Basic
    @Column(name = "STOCKANAME", nullable = true, length = 255)
    public String getSTOCKANAME() {
        return STOCKANAME;
    }

    public void setSTOCKANAME(String STOCKANAME) {
        this.STOCKANAME = STOCKANAME;
    }

    @Basic
    @Column(name = "STOCKADATE", nullable = true)
    public Timestamp getSTOCKADATE() {
        return STOCKADATE;
    }

    public void setSTOCKADATE(Timestamp STOCKADATE) {
        this.STOCKADATE = STOCKADATE;
    }

    @Basic
    @Column(name = "STOCKBCODE", nullable = true, length = 255)
    public String getSTOCKBCODE() {
        return STOCKBCODE;
    }

    public void setSTOCKBCODE(String STOCKBCODE) {
        this.STOCKBCODE = STOCKBCODE;
    }

    @Basic
    @Column(name = "STOCKBNAME", nullable = true, length = 255)
    public String getSTOCKBNAME() {
        return STOCKBNAME;
    }

    public void setSTOCKBNAME(String STOCKBNAME) {
        this.STOCKBNAME = STOCKBNAME;
    }

    @Basic
    @Column(name = "STOCKBDATE", nullable = true)
    public Timestamp getSTOCKBDATE() {
        return STOCKBDATE;
    }

    public void setSTOCKBDATE(Timestamp STOCKBDATE) {
        this.STOCKBDATE = STOCKBDATE;
    }

    @Basic
    @Column(name = "PROVIDENAME", nullable = true, length = 255)
    public String getPROVIDENAME() {
        return PROVIDENAME;
    }

    public void setPROVIDENAME(String PROVIDENAME) {
        this.PROVIDENAME = PROVIDENAME;
    }

    @Basic
    @Column(name = "CSRC", nullable = true, length = 255)
    public String getCSRC() {
        return CSRC;
    }

    public void setCSRC(String CSRC) {
        this.CSRC = CSRC;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DIM_STOCKCOMPANYINFORMATION that = (DIM_STOCKCOMPANYINFORMATION) o;

        if (COMPANYCODE != null ? !COMPANYCODE.equals(that.COMPANYCODE) : that.COMPANYCODE != null) return false;
        if (COMPANYNAME != null ? !COMPANYNAME.equals(that.COMPANYNAME) : that.COMPANYNAME != null) return false;
        if (STOCKACODE != null ? !STOCKACODE.equals(that.STOCKACODE) : that.STOCKACODE != null) return false;
        if (STOCKANAME != null ? !STOCKANAME.equals(that.STOCKANAME) : that.STOCKANAME != null) return false;
        if (STOCKADATE != null ? !STOCKADATE.equals(that.STOCKADATE) : that.STOCKADATE != null) return false;
        if (STOCKBCODE != null ? !STOCKBCODE.equals(that.STOCKBCODE) : that.STOCKBCODE != null) return false;
        if (STOCKBNAME != null ? !STOCKBNAME.equals(that.STOCKBNAME) : that.STOCKBNAME != null) return false;
        if (STOCKBDATE != null ? !STOCKBDATE.equals(that.STOCKBDATE) : that.STOCKBDATE != null) return false;
        if (PROVIDENAME != null ? !PROVIDENAME.equals(that.PROVIDENAME) : that.PROVIDENAME != null) return false;
        return CSRC != null ? CSRC.equals(that.CSRC) : that.CSRC == null;

    }

    @Override
    public int hashCode() {
        int result = COMPANYCODE != null ? COMPANYCODE.hashCode() : 0;
        result = 31 * result + (COMPANYNAME != null ? COMPANYNAME.hashCode() : 0);
        result = 31 * result + (STOCKACODE != null ? STOCKACODE.hashCode() : 0);
        result = 31 * result + (STOCKANAME != null ? STOCKANAME.hashCode() : 0);
        result = 31 * result + (STOCKADATE != null ? STOCKADATE.hashCode() : 0);
        result = 31 * result + (STOCKBCODE != null ? STOCKBCODE.hashCode() : 0);
        result = 31 * result + (STOCKBNAME != null ? STOCKBNAME.hashCode() : 0);
        result = 31 * result + (STOCKBDATE != null ? STOCKBDATE.hashCode() : 0);
        result = 31 * result + (PROVIDENAME != null ? PROVIDENAME.hashCode() : 0);
        result = 31 * result + (CSRC != null ? CSRC.hashCode() : 0);
        return result;
    }
}
