package com.kit.csg.crawler.stock.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "POWERECON_STOCKMARKET")
public class StockMarket implements Serializable {
    /**
     * "ID"
     */
    @Id
    @Column(name = "ID")
    private String id;
    /**
     * "ITEMDATE"
     */
    @Column(name = "ITEMDATE")
    private Timestamp itemDate;
    /**
     * "MARKETNAME"
     */
    @Column(name = "MARKETNAME")
    private String marketName;
    /**
     * "INDEXDATA"
     */
    @Column(name = "INDEXDATA")
    private BigDecimal indexData;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Timestamp getItemDate() {
        return itemDate;
    }

    public void setItemDate(Timestamp itemDate) {
        this.itemDate = itemDate;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public BigDecimal getIndexData() {
        return indexData;
    }

    public void setIndexData(BigDecimal indexData) {
        this.indexData = indexData;
    }
}