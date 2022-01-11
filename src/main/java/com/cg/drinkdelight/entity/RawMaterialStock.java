package com.cg.drinkdelight.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "raw_material_stock")
public class RawMaterialStock {

	@Id
	@GeneratedValue
	private int id;
	@Column(name = "rm_name")
	private String name;
	@Column(name = "rm_unit_price")
	private double unitPrice;
	@Column(name = "rm_quantity")
	private int quantity;
	@Column(name = "rm_process_date")
	@JsonFormat(pattern = "dd-MM-yyyy", timezone = "Asia/Calcutta")
	private Date processDate;
	@Column(name = "rm_mfg_date")
	@JsonFormat(pattern = "dd-MM-yyyy", timezone = "Asia/Calcutta")
	private Date mfgDate;
	@Column(name = "rm_expiry_date")
	@JsonFormat(pattern = "dd-MM-yyyy", timezone = "Asia/Calcutta")
	private Date expiryDate;
	@Column(name = "rm_delivery_date")
	@JsonFormat(pattern = "dd-MM-yyyy", timezone = "Asia/Calcutta")
	private Date deliveryDate;
	
	public RawMaterialStock() {
	}

	public RawMaterialStock(int id, String name, double unitPrice, int quantity, Date processDate, Date mfgDate,
			Date expiryDate, Date deliveryDate) {
		super();
		this.id = id;
		this.name = name;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.processDate = processDate;
		this.mfgDate = mfgDate;
		this.expiryDate = expiryDate;
		this.deliveryDate = deliveryDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getProcessDate() {
		return processDate;
	}

	public void setProcessDate(Date processDate) {
		this.processDate = processDate;
	}

	public Date getMfgDate() {
		return mfgDate;
	}

	public void setMfgDate(Date mfgDate) {
		this.mfgDate = mfgDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	
}
