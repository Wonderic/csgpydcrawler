package com.kit.csg.crawler.stock.entity;

import java.math.BigDecimal;
import java.util.Date;

public class PowereconStockmarket {
    private String id;

    private String marketname;

    private BigDecimal indexdata;

    private Date itemdate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMarketname() {
        return marketname;
    }

    public void setMarketname(String marketname) {
        this.marketname = marketname;
    }

    public BigDecimal getIndexdata() {
        return indexdata;
    }

    public void setIndexdata(BigDecimal indexdata) {
        this.indexdata = indexdata;
    }

    public Date getItemdate() {
        return itemdate;
    }

    public void setItemdate(Date itemdate) {
        this.itemdate = itemdate;
    }
}