package com.cg.drinkdelight.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "product_stock")
public class ProductStock {
	@Id
	@GeneratedValue
	private int pId;
	private String pName;
	private double pPrice;
	private int pQuantity;
	@JsonFormat(pattern = "dd-MM-yyyy", timezone = "Asia/Calcutta")
	private Date exitDate;
	@JsonFormat(pattern = "dd-MM-yyyy", timezone = "Asia/Calcutta")
	private Date mfDate;
	@JsonFormat(pattern = "dd-MM-yyyy", timezone = "Asia/Calcutta")
	private Date expDate;
	@JsonFormat(pattern = "dd-MM-yyyy", timezone = "Asia/Calcutta")
	private Date pDeliveryDate;

	public ProductStock() {
	}

	public ProductStock(int pId, String pName, double pPrice, int pQuantity, Date exitDate, Date mfDate, Date expDate,
			Date pDeliveryDate) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.pPrice = pPrice;
		this.pQuantity = pQuantity;
		this.exitDate = exitDate;
		this.mfDate = mfDate;
		this.expDate = expDate;
		this.pDeliveryDate = pDeliveryDate;
	}

	@Override
	public String toString() {
		return "ProductStock [pId=" + pId + ", pName=" + pName + ", pPrice=" + pPrice + ", pQuantity=" + pQuantity
				+ ", exitDate=" + exitDate + ", mfDate=" + mfDate + ", expDate=" + expDate + ", pDeliveryDate="
				+ pDeliveryDate + "]";
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public double getpPrice() {
		return pPrice;
	}

	public void setpPrice(double pPrice) {
		this.pPrice = pPrice;
	}

	public int getpQuantity() {
		return pQuantity;
	}

	public void setpQuantity(int pQuantity) {
		this.pQuantity = pQuantity;
	}

	public Date getExitDate() {
		return exitDate;
	}

	public void setExitDate(Date exitDate) {
		this.exitDate = exitDate;
	}

	public Date getMfDate() {
		return mfDate;
	}

	public void setMfDate(Date mfDate) {
		this.mfDate = mfDate;
	}

	public Date getExpDate() {
		return expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

	public Date getpDeliveryDate() {
		return pDeliveryDate;
	}

	public void setpDeliveryDate(Date pDeliveryDate) {
		this.pDeliveryDate = pDeliveryDate;
	}

}
