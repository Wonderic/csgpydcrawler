package com.kit.csg.crawler.stock.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "STOCKCODE_LASTDATE")
public class StockCodeLastDate {
    @Id
    @Column
    private String stockcode;
    @Column
    private String stype;
    @Column
    private Timestamp lasttime;

    public String getStockcode() {
        return stockcode;
    }

    public void setStockcode(String stockcode) {
        this.stockcode = stockcode;
    }

    public String getStype() {
        return stype;
    }

    public void setStype(String stype) {
        this.stype = stype;
    }

    public Timestamp getLasttime() {
        return lasttime;
    }

    public void setLasttime(Timestamp lasttime) {
        this.lasttime = lasttime;
    }
}