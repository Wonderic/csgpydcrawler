package com.kit.csg.crawler.typhoon.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "CLOUD_TYPHOON_ROUTE")
public class TyphoonRoute  implements Serializable {
	@Id
	@Column
	private String id;
	@Column
	private String typhoonNum;
	@Column
	private String typhoonLng;
	@Column
	private String typhoonLat;
	@Column
	private Integer winddStrength;
	@Column
	private Integer centeredPressure;
	@Column
	private Timestamp dispTime;
	@Column
	private Integer typhoonClass;
	@Column
	private String typhoonId;


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getTyphoonNum() {
		return typhoonNum;
	}

	public void setTyphoonNum(String typhoonNum) {
		this.typhoonNum = typhoonNum;
	}

	public String getTyphoonLng() {
		return typhoonLng;
	}

	public void setTyphoonLng(String typhoonLng) {
		this.typhoonLng = typhoonLng;
	}

	public String getTyphoonLat() {
		return typhoonLat;
	}

	public void setTyphoonLat(String typhoonLat) {
		this.typhoonLat = typhoonLat;
	}

	public Integer getWinddStrength() {
		return winddStrength;
	}

	public void setWinddStrength(Integer winddStrength) {
		this.winddStrength = winddStrength;
	}

	public Integer getCenteredPressure() {
		return centeredPressure;
	}

	public void setCenteredPressure(Integer centeredPressure) {
		this.centeredPressure = centeredPressure;
	}

	public Timestamp getDispTime() {
		return dispTime;
	}

	public void setDispTime(Timestamp dispTime) {
		this.dispTime = dispTime;
	}

	public Integer getTyphoonClass() {
		return typhoonClass;
	}

	public void setTyphoonClass(Integer typhoonClass) {
		this.typhoonClass = typhoonClass;
	}

	public String getTyphoonId() {
		return typhoonId;
	}

	public void setTyphoonId(String typhoonId) {
		this.typhoonId = typhoonId;
	}
}
