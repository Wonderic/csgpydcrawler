package com.kit.csg.crawler.stock.entity;

import java.sql.Timestamp;

/**
 * Created by Robin on 2016-08-17.
 */
public class CustomerFinance {
    private String SFID;
    private Timestamp SFDATE;
    private String STOCKCODE;
    private Double MAINBUSSINCOME;
    private Double MAINBUSSPROFIT;
    private Double OPERATINGPROFIT;
    private Double INVESTMINCOME;
    private Double NONOPERATPROF;
    private Double TOTALPROFIT;
    private Double NETPROFIT;
    private Double NETPROFITADNRPAL;
    private Double NETCASH;
    private Double NETINCCA;
    private Double TOTALASSET;
    private Double CURRASSET;
    private Double TOTALLIABILITIES;
    private Double CURRLIABILITIES;
    private Double NEASRERATIO;

    public String getSFID() {
        return SFID;
    }

    public void setSFID(String SFID) {
        this.SFID = SFID;
    }

    public Timestamp getSFDATE() {
        return SFDATE;
    }

    public void setSFDATE(Timestamp SFDATE) {
        this.SFDATE = SFDATE;
    }

    public String getSTOCKCODE() {
        return STOCKCODE;
    }

    public void setSTOCKCODE(String STOCKCODE) {
        this.STOCKCODE = STOCKCODE;
    }

    public Double getMAINBUSSINCOME() {
        return MAINBUSSINCOME;
    }

    public void setMAINBUSSINCOME(Double MAINBUSSINCOME) {
        this.MAINBUSSINCOME = MAINBUSSINCOME;
    }

    public Double getMAINBUSSPROFIT() {
        return MAINBUSSPROFIT;
    }

    public void setMAINBUSSPROFIT(Double MAINBUSSPROFIT) {
        this.MAINBUSSPROFIT = MAINBUSSPROFIT;
    }

    public Double getOPERATINGPROFIT() {
        return OPERATINGPROFIT;
    }

    public void setOPERATINGPROFIT(Double OPERATINGPROFIT) {
        this.OPERATINGPROFIT = OPERATINGPROFIT;
    }

    public Double getINVESTMINCOME() {
        return INVESTMINCOME;
    }

    public void setINVESTMINCOME(Double INVESTMINCOME) {
        this.INVESTMINCOME = INVESTMINCOME;
    }

    public Double getNONOPERATPROF() {
        return NONOPERATPROF;
    }

    public void setNONOPERATPROF(Double NONOPERATPROF) {
        this.NONOPERATPROF = NONOPERATPROF;
    }

    public Double getTOTALPROFIT() {
        return TOTALPROFIT;
    }

    public void setTOTALPROFIT(Double TOTALPROFIT) {
        this.TOTALPROFIT = TOTALPROFIT;
    }

    public Double getNETPROFIT() {
        return NETPROFIT;
    }

    public void setNETPROFIT(Double NETPROFIT) {
        this.NETPROFIT = NETPROFIT;
    }

    public Double getNETPROFITADNRPAL() {
        return NETPROFITADNRPAL;
    }

    public void setNETPROFITADNRPAL(Double NETPROFITADNRPAL) {
        this.NETPROFITADNRPAL = NETPROFITADNRPAL;
    }

    public Double getNETCASH() {
        return NETCASH;
    }

    public void setNETCASH(Double NETCASH) {
        this.NETCASH = NETCASH;
    }

    public Double getNETINCCA() {
        return NETINCCA;
    }

    public void setNETINCCA(Double NETINCCA) {
        this.NETINCCA = NETINCCA;
    }

    public Double getTOTALASSET() {
        return TOTALASSET;
    }

    public void setTOTALASSET(Double TOTALASSET) {
        this.TOTALASSET = TOTALASSET;
    }

    public Double getCURRASSET() {
        return CURRASSET;
    }

    public void setCURRASSET(Double CURRASSET) {
        this.CURRASSET = CURRASSET;
    }

    public Double getTOTALLIABILITIES() {
        return TOTALLIABILITIES;
    }

    public void setTOTALLIABILITIES(Double TOTALLIABILITIES) {
        this.TOTALLIABILITIES = TOTALLIABILITIES;
    }

    public Double getCURRLIABILITIES() {
        return CURRLIABILITIES;
    }

    public void setCURRLIABILITIES(Double CURRLIABILITIES) {
        this.CURRLIABILITIES = CURRLIABILITIES;
    }

    public Double getNEASRERATIO() {
        return NEASRERATIO;
    }

    public void setNEASRERATIO(Double NEASRERATIO) {
        this.NEASRERATIO = NEASRERATIO;
    }
}
