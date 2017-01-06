package com.kit.csg.crawler.typhoon.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by huanm on 2016/5/15.
 */

@Entity
@Table(name = "CLOUD_TYPHOON_SUMMARY")
public class TyphoonSummary implements Serializable{
    @Id
    @Column
	private String id;

    @Column
	private int typhoonNum;

    @Column
	private String typhoonNameZh;

    @Column
	private String typhoonNameEn;

    @Column
	private Timestamp birthDate;

    @Column
	private Timestamp deathDate;

    @Column
	private String lifeTime;

    @Column
	private int minPressure;
    @Column
	private int typhoonStatus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTyphoonNum() {
        return typhoonNum;
    }

    public void setTyphoonNum(int typhoonNum) {
        this.typhoonNum = typhoonNum;
    }

    public String getTyphoonNameZh() {
        return typhoonNameZh;
    }

    public void setTyphoonNameZh(String typhoonNameZh) {
        this.typhoonNameZh = typhoonNameZh;
    }

    public String getTyphoonNameEn() {
        return typhoonNameEn;
    }

    public void setTyphoonNameEn(String typhoonNameEn) {
        this.typhoonNameEn = typhoonNameEn;
    }

    public Timestamp getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Timestamp birthDate) {
        this.birthDate = birthDate;
    }

    public Timestamp getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(Timestamp deathDate) {
        this.deathDate = deathDate;
    }

    public String getLifeTime() {
        return lifeTime;
    }

    public void setLifeTime(String lifeTime) {
        this.lifeTime = lifeTime;
    }

    public int getMinPressure() {
        return minPressure;
    }

    public void setMinPressure(int minPressure) {
        this.minPressure = minPressure;
    }

    public int getTyphoonStatus() {
        return typhoonStatus;
    }

    public void setTyphoonStatus(int typhoonStatus) {
        this.typhoonStatus = typhoonStatus;
    }
}
