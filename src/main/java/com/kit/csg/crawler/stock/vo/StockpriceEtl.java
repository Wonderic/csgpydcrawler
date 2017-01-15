package com.kit.csg.crawler.stock.vo;

import java.math.BigDecimal;
import java.util.Date;

public class StockpriceEtl {
    private String stockcode;

    private BigDecimal price;

    private Date itemdate;

    public String getStockcode() {
        return stockcode;
    }

    public void setStockcode(String stockcode) {
        this.stockcode = stockcode;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getItemdate() {
        return itemdate;
    }

    public void setItemdate(Date itemdate) {
        this.itemdate = itemdate;
    }
}