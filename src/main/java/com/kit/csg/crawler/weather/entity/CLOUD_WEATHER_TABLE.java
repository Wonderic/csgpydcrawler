package com.kit.csg.crawler.weather.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;


@Entity
@Table(name = "CLOUD_WEATHER_TABLE")
public class CLOUD_WEATHER_TABLE implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column
    private String PROVINCE;
    @Column
    private String CITY_NAME;
    @Column
    private String CITY_CODE;
    @Column
    private String CREATE_DATE;
    @Column
    private String YUJING;
    @Column
    private String ALARMTEXT;
    @Column
    private String WARNING;
    @Column
    private String TEMP0;
    @Column
    private String TEMP1;
    @Column
    private String TEMP2;
    @Column
    private String TEMP3;
    @Column
    private String TEMP4;
    @Column
    private String TEMP5;
    @Column
    private String TEMP6;
    @Column
    private String WEATHER0;
    @Column
    private String WEATHER1;
    @Column
    private String WEATHER2;
    @Column
    private String WEATHER3;
    @Column
    private String WEATHER4;
    @Column
    private String WEATHER5;
    @Column
    private String WEATHER6;
    @Column
    private String WIND0;
    @Column
    private String WIND1;
    @Column
    private String WIND2;
    @Column
    private String WIND3;
    @Column
    private String WIND4;
    @Column
    private String WIND5;
    @Column
    private String WIND6;
    @Column
    private String INTIME;
    @Column
    private String TEMPNOW;
    @Column
    private String SHIDU;
    @Column
    private String WINDINFO;
    @Column
    private String FEELTEMP;
    @Column
    private String SHIDUNOW;
    @Column
    private String TODAYSUN;
    @Column
    private String TOMORROWSUN;
    @Column
    private String AQIDATA;
    @Column
    private String PM2DOT5DATA;
    @Column
    private String PM10DATA;
    @Column
    private Integer DATATYPE;
    @Column
    private Double PRECIPITATION;
    @Id
    @Column
    private String ID;
    @Column
    private Timestamp NEW_DATE;

    public String getPROVINCE() {
        return PROVINCE;
    }

    public void setPROVINCE(String PROVINCE) {
        this.PROVINCE = PROVINCE;
    }

    public String getCITY_NAME() {
        return CITY_NAME;
    }

    public void setCITY_NAME(String CITY_NAME) {
        this.CITY_NAME = CITY_NAME;
    }

    public String getCITY_CODE() {
        return CITY_CODE;
    }

    public void setCITY_CODE(String CITY_CODE) {
        this.CITY_CODE = CITY_CODE;
    }

    public String getCREATE_DATE() {
        return CREATE_DATE;
    }

    public void setCREATE_DATE(String CREATE_DATE) {
        this.CREATE_DATE = CREATE_DATE;
    }

    public String getYUJING() {
        return YUJING;
    }

    public void setYUJING(String YUJING) {
        this.YUJING = YUJING;
    }

    public String getALARMTEXT() {
        return ALARMTEXT;
    }

    public void setALARMTEXT(String ALARMTEXT) {
        this.ALARMTEXT = ALARMTEXT;
    }

    public String getWARNING() {
        return WARNING;
    }

    public void setWARNING(String WARNING) {
        this.WARNING = WARNING;
    }

    public String getTEMP0() {
        return TEMP0;
    }

    public void setTEMP0(String TEMP0) {
        this.TEMP0 = TEMP0;
    }

    public String getTEMP1() {
        return TEMP1;
    }

    public void setTEMP1(String TEMP1) {
        this.TEMP1 = TEMP1;
    }

    public String getTEMP2() {
        return TEMP2;
    }

    public void setTEMP2(String TEMP2) {
        this.TEMP2 = TEMP2;
    }

    public String getTEMP3() {
        return TEMP3;
    }

    public void setTEMP3(String TEMP3) {
        this.TEMP3 = TEMP3;
    }

    public String getTEMP4() {
        return TEMP4;
    }

    public void setTEMP4(String TEMP4) {
        this.TEMP4 = TEMP4;
    }

    public String getTEMP5() {
        return TEMP5;
    }

    public void setTEMP5(String TEMP5) {
        this.TEMP5 = TEMP5;
    }

    public String getTEMP6() {
        return TEMP6;
    }

    public void setTEMP6(String TEMP6) {
        this.TEMP6 = TEMP6;
    }

    public String getWEATHER0() {
        return WEATHER0;
    }

    public void setWEATHER0(String WEATHER0) {
        this.WEATHER0 = WEATHER0;
    }

    public String getWEATHER1() {
        return WEATHER1;
    }

    public void setWEATHER1(String WEATHER1) {
        this.WEATHER1 = WEATHER1;
    }

    public String getWEATHER2() {
        return WEATHER2;
    }

    public void setWEATHER2(String WEATHER2) {
        this.WEATHER2 = WEATHER2;
    }

    public String getWEATHER3() {
        return WEATHER3;
    }

    public void setWEATHER3(String WEATHER3) {
        this.WEATHER3 = WEATHER3;
    }

    public String getWEATHER4() {
        return WEATHER4;
    }

    public void setWEATHER4(String WEATHER4) {
        this.WEATHER4 = WEATHER4;
    }

    public String getWEATHER5() {
        return WEATHER5;
    }

    public void setWEATHER5(String WEATHER5) {
        this.WEATHER5 = WEATHER5;
    }

    public String getWEATHER6() {
        return WEATHER6;
    }

    public void setWEATHER6(String WEATHER6) {
        this.WEATHER6 = WEATHER6;
    }

    public String getWIND0() {
        return WIND0;
    }

    public void setWIND0(String WIND0) {
        this.WIND0 = WIND0;
    }

    public String getWIND1() {
        return WIND1;
    }

    public void setWIND1(String WIND1) {
        this.WIND1 = WIND1;
    }

    public String getWIND2() {
        return WIND2;
    }

    public void setWIND2(String WIND2) {
        this.WIND2 = WIND2;
    }

    public String getWIND3() {
        return WIND3;
    }

    public void setWIND3(String WIND3) {
        this.WIND3 = WIND3;
    }

    public String getWIND4() {
        return WIND4;
    }

    public void setWIND4(String WIND4) {
        this.WIND4 = WIND4;
    }

    public String getWIND5() {
        return WIND5;
    }

    public void setWIND5(String WIND5) {
        this.WIND5 = WIND5;
    }

    public String getWIND6() {
        return WIND6;
    }

    public void setWIND6(String WIND6) {
        this.WIND6 = WIND6;
    }

    public String getINTIME() {
        return INTIME;
    }

    public void setINTIME(String INTIME) {
        this.INTIME = INTIME;
    }

    public String getTEMPNOW() {
        return TEMPNOW;
    }

    public void setTEMPNOW(String TEMPNOW) {
        this.TEMPNOW = TEMPNOW;
    }

    public String getSHIDU() {
        return SHIDU;
    }

    public void setSHIDU(String SHIDU) {
        this.SHIDU = SHIDU;
    }

    public String getWINDINFO() {
        return WINDINFO;
    }

    public void setWINDINFO(String WINDINFO) {
        this.WINDINFO = WINDINFO;
    }

    public String getFEELTEMP() {
        return FEELTEMP;
    }

    public void setFEELTEMP(String FEELTEMP) {
        this.FEELTEMP = FEELTEMP;
    }

    public String getSHIDUNOW() {
        return SHIDUNOW;
    }

    public void setSHIDUNOW(String SHIDUNOW) {
        this.SHIDUNOW = SHIDUNOW;
    }

    public String getTODAYSUN() {
        return TODAYSUN;
    }

    public void setTODAYSUN(String TODAYSUN) {
        this.TODAYSUN = TODAYSUN;
    }

    public String getTOMORROWSUN() {
        return TOMORROWSUN;
    }

    public void setTOMORROWSUN(String TOMORROWSUN) {
        this.TOMORROWSUN = TOMORROWSUN;
    }

    public String getAQIDATA() {
        return AQIDATA;
    }

    public void setAQIDATA(String AQIDATA) {
        this.AQIDATA = AQIDATA;
    }

    public String getPM2DOT5DATA() {
        return PM2DOT5DATA;
    }

    public void setPM2DOT5DATA(String PM2DOT5DATA) {
        this.PM2DOT5DATA = PM2DOT5DATA;
    }

    public String getPM10DATA() {
        return PM10DATA;
    }

    public void setPM10DATA(String PM10DATA) {
        this.PM10DATA = PM10DATA;
    }

    public Integer getDATATYPE() {
        return DATATYPE;
    }

    public void setDATATYPE(Integer DATATYPE) {
        this.DATATYPE = DATATYPE;
    }

    public Double getPRECIPITATION() {
        return PRECIPITATION;
    }

    public void setPRECIPITATION(Double PRECIPITATION) {
        this.PRECIPITATION = PRECIPITATION;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Timestamp getNEW_DATE() {
        return NEW_DATE;
    }

    public void setNEW_DATE(Timestamp NEW_DATE) {
        this.NEW_DATE = NEW_DATE;
    }
}
