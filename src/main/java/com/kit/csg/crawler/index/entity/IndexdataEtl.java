package com.kit.csg.crawler.index.entity;

import java.util.Date;

public class IndexdataEtl {
    private String indexdataname;

    private Date itemdate;

    private String zonename;

    private String price;

    private String dbcode;

    public String getIndexdataname() {
        return indexdataname;
    }

    public void setIndexdataname(String indexdataname) {
        this.indexdataname = indexdataname;
    }

    public Date getItemdate() {
        return itemdate;
    }

    public void setItemdate(Date itemdate) {
        this.itemdate = itemdate;
    }

    public String getZonename() {
        return zonename;
    }

    public void setZonename(String zonename) {
        this.zonename = zonename;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDbcode() {
        return dbcode;
    }

    public void setDbcode(String dbcode) {
        this.dbcode = dbcode;
    }
}