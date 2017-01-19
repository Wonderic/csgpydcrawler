package com.kit.csg.crawler.stock.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Robin on 2016-08-17.
 */

@Entity
@Table(name = "POWERECON_STOCKFINANCE")
public class POWERECON_STOCKFINANCE  implements Serializable {
    @Id
    @Column(columnDefinition = "nvarchar2(32)")
    private String SFID;
    @Column
    private Timestamp SFDATE;
    @Column(columnDefinition = "nvarchar2(255)")
    private String STOCKCODE;
    @Column(columnDefinition = "number(0,0)")
    
    private Double MAINBUSSINCOME=null;
    @Column(columnDefinition = "number(0,0)")
    
    private Double MAINBUSSPROFIT=null;
    @Column(columnDefinition = "number(0,0)")
    
    private Double OPERATINGPROFIT=null;
    @Column(columnDefinition = "number(0,0)")
    
    private Double INVESTMINCOME=null;
    @Column(columnDefinition = "number(0,0)")
    
    private Double NONOPERATPROF=null;
    @Column(columnDefinition = "number(0,0)")
    
    private Double TOTALPROFIT =null;
    @Column(columnDefinition = "number(0,0)")
    
    private Double NETPROFIT =null;
    @Column(columnDefinition = "number(0,0)")
    
    private Double NETPROFITADNRPAL =null;
    @Column(columnDefinition = "number(0,0)")
    
    private Double NETCASH=null;
    @Column(columnDefinition = "number(0,0)")
    
    private Double NETINCCA=null;
    @Column(columnDefinition = "number(0,0)")
    
    private Double TOTALASSET =null;
    @Column(columnDefinition = "number(0,0)")
    
    private Double CURRASSET=null;
    @Column(columnDefinition = "number(0,0)")
    
    private Double TOTALLIABILITIES=null;
    @Column(columnDefinition = "number(0,0)")
    
    private Double CURRLIABILITIES=null;
    @Column(columnDefinition = "number(0,0)")
    
    private Double NEASRERATIO=null;

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

    public Timestamp getTime() {
        return getSFDATE();
    }

    public void setTime(Timestamp time) {
        setSFDATE(time);
    }

    public void setValue(Double value){
        setMAINBUSSINCOME(value);
        setMAINBUSSPROFIT(value);
        setOPERATINGPROFIT(value);
        setINVESTMINCOME(value);
        setNONOPERATPROF(value);
        setTOTALPROFIT(value);
        setNETPROFIT(value);
        setNETPROFITADNRPAL(value);
        setNETCASH(value);
        setNETINCCA(value);
        setTOTALASSET(value);
        setCURRASSET(value);
        setTOTALASSET(value);
        setTOTALLIABILITIES(value);
        setCURRLIABILITIES(value);
        setNEASRERATIO(value);

    }

    
    public String toString() {
        return "POWERECON_STOCKFINANCE{" +
                "SFID='" + SFID + '\'' +
                ", SFDATE=" + SFDATE +
                ", STOCKCODE='" + STOCKCODE + '\'' +
                ", MAINBUSSINCOME=" + MAINBUSSINCOME +
                ", MAINBUSSPROFIT=" + MAINBUSSPROFIT +
                ", OPERATINGPROFIT=" + OPERATINGPROFIT +
                ", INVESTMINCOME=" + INVESTMINCOME +
                ", NONOPERATPROF=" + NONOPERATPROF +
                ", TOTALPROFIT=" + TOTALPROFIT +
                ", NETPROFIT=" + NETPROFIT +
                ", NETPROFITADNRPAL=" + NETPROFITADNRPAL +
                ", NETCASH=" + NETCASH +
                ", NETINCCA=" + NETINCCA +
                ", TOTALASSET=" + TOTALASSET +
                ", CURRASSET=" + CURRASSET +
                ", TOTALLIABILITIES=" + TOTALLIABILITIES +
                ", CURRLIABILITIES=" + CURRLIABILITIES +
                ", NEASRERATIO=" + NEASRERATIO +
                '}';
    }

    public String toDUALString() {
        return "select '"+SFID+"','"+SFDATE+"','"+STOCKCODE+"','"+MAINBUSSINCOME+"','"+MAINBUSSPROFIT+"','"+OPERATINGPROFIT+"','"+INVESTMINCOME+"','"+NONOPERATPROF+"','"+TOTALPROFIT+"','"+NETPROFIT+"','"+NETPROFITADNRPAL+"','"+NETCASH+"','"+NETINCCA+"','"+TOTALASSET+"','"+CURRASSET+"','"+TOTALLIABILITIES+"','"+CURRLIABILITIES+"','"+NEASRERATIO+"' from dual";
    }
}
