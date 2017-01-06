package com.kit.csg.crawler.typhoon.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
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
	private BigDecimal typhoonLng;
	@Column
	private BigDecimal typhoonLat;
	@Column
	private int winddStrength;
	@Column
	private int centeredPressure;
	@Column
	private Timestamp dispTime;
	@Column
	private int typhoonClass;
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

	public BigDecimal getTyphoonLng() {
		return typhoonLng;
	}

	public void setTyphoonLng(BigDecimal typhoonLng) {
		this.typhoonLng = typhoonLng;
	}

	public BigDecimal getTyphoonLat() {
		return typhoonLat;
	}

	public void setTyphoonLat(BigDecimal typhoonLat) {
		this.typhoonLat = typhoonLat;
	}

	public int getWinddStrength() {
		return winddStrength;
	}

	public void setWinddStrength(int winddStrength) {
		this.winddStrength = winddStrength;
	}

	public int getCenteredPressure() {
		return centeredPressure;
	}

	public void setCenteredPressure(int centeredPressure) {
		this.centeredPressure = centeredPressure;
	}

	public Timestamp getDispTime() {
		return dispTime;
	}

	public void setDispTime(Timestamp dispTime) {
		this.dispTime = dispTime;
	}

	public int getTyphoonClass() {
		return typhoonClass;
	}

	public void setTyphoonClass(int typhoonClass) {
		this.typhoonClass = typhoonClass;
	}

	public String getTyphoonId() {
		return typhoonId;
	}

	public void setTyphoonId(String typhoonId) {
		this.typhoonId = typhoonId;
	}
}
