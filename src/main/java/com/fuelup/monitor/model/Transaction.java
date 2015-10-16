package com.fuelup.monitor.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({
	@NamedQuery(
	name = "fetchAllTrx",
	query = "SELECT t from Transaction t"
	)
})

@Entity
public class Transaction {

	@Id
	@Column(name="TRANSACTION_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long transactionID;
	
	@Column(name="TRANSACTION_DATE")
	private Date transactionDate;
	
	private String notes;
	
	private Double gallons;
	
	@Column(name="COST_PER_GALLON")
	private Double costPerGallon;
	
	@Column(name="TOTAL_COST")
	private Double totalCost;
	
	private Long mileage;
	
	@Column(name="CC_USER")
	private String ccUsed;
	
	private Object receipt;
	
	@Column(name="LAST_UPDATED_TIME")
	private Date lastUpdatedTime;
	
	public Long getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(Long transactionID) {
		this.transactionID = transactionID;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public Double getGallons() {
		return gallons;
	}
	public void setGallons(Double gallons) {
		this.gallons = gallons;
	}
	public Double getCostPerGallon() {
		return costPerGallon;
	}
	public void setCostPerGallon(Double costPerGallon) {
		this.costPerGallon = costPerGallon;
	}
	public Double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}
	public Long getMileage() {
		return mileage;
	}
	public void setMileage(Long mileage) {
		this.mileage = mileage;
	}
	public String getCcUsed() {
		return ccUsed;
	}
	public void setCcUsed(String ccUsed) {
		this.ccUsed = ccUsed;
	}
	public Object getReceipt() {
		return receipt;
	}
	public void setReceipt(Object receipt) {
		this.receipt = receipt;
	}
	public Date getLastUpdatedTime() {
		return lastUpdatedTime;
	}
	public void setLastUpdatedTime(Date lastUpdatedTime) {
		this.lastUpdatedTime = lastUpdatedTime;
	}
}
