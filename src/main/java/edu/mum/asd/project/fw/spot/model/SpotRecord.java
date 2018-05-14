package edu.mum.asd.project.fw.spot.model;

import java.util.Date;

import edu.mum.asd.project.fw.spot.Spot;

public class SpotRecord extends Spot {
	Integer recordId;
	Integer customerId;
	Date checkin;
	Date checkout;
	Double price;
	Boolean washed;
	Boolean washRequested;
	
	public Integer getRecordId() {
		return recordId;
	}
	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public Date getCheckin() {
		return checkin;
	}
	public void setCheckin(Date checkin) {
		this.checkin = checkin;
	}
	public Date getCheckout() {
		return checkout;
	}
	public void setCheckout(Date checkout) {
		this.checkout = checkout;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Boolean getWashed() {
		return washed;
	}
	public void setWashed(Boolean washed) {
		this.washed = washed;
	}
	public Boolean getWashRequested() {
		return washRequested;
	}
	public void setWashRequested(Boolean washRequested) {
		this.washRequested = washRequested;
	}
	
	
	
		
	
	
}
