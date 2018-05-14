package edu.mum.asd.project.fw.report.model;

import java.util.Date;

import edu.mum.asd.project.application.util.SpotUtils;

public class Report {
	private Integer customerId;
	private String customerName;
	private Date checkinDate;
	private Date checkoutDate;
	private Integer washed;
	private Double price;
	private Integer parkingId;
	private String parkingName;
	private Integer spotTypeId;
	private String spotTypeName;
	private Integer recordId;
	private Integer spotId;
	private Integer washRequested;
	private Integer available;
	private Integer row;
	private Integer col;
	private Integer carTypeId;
	private String carName;
	private Double carPrice;
	private Double washPrice;
	private Long duration = 0L;
	
	public Report() {}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Date getCheckinDate() {
		return checkinDate;
	}

	public void setCheckinDate(Date checkinDate) {
		this.checkinDate = checkinDate;
	}

	public Date getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	public Integer getWashed() {
		return washed;
	}

	public void setWashed(Integer washed) {
		this.washed = washed;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getParkingId() {
		return parkingId;
	}

	public void setParkingId(Integer parkingId) {
		this.parkingId = parkingId;
	}

	public String getParkingName() {
		return parkingName;
	}

	public void setParkingName(String parkingName) {
		this.parkingName = parkingName;
	}

	public Integer getSpotTypeId() {
		return spotTypeId;
	}

	public void setSpotTypeId(Integer spotTypeId) {
		this.spotTypeId = spotTypeId;
	}

	public String getSpotTypeName() {
		return spotTypeName;
	}

	public void setSpotTypeName(String spotTypeName) {
		this.spotTypeName = spotTypeName;
	}

	public Integer getRecordId() {
		return recordId;
	}

	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}

	public Integer getSpotId() {
		return spotId;
	}

	public void setSpotId(Integer spotId) {
		this.spotId = spotId;
	}

	public Integer getWashRequested() {
		return washRequested;
	}

	public void setWashRequested(Integer washRequested) {
		this.washRequested = washRequested;
	}

	public Integer getAvailable() {
		return available;
	}

	public void setAvailable(Integer available) {
		this.available = available;
	}

	public Integer getRow() {
		return row;
	}

	public void setRow(Integer row) {
		this.row = row;
	}

	public Integer getCol() {
		return col;
	}

	public void setCol(Integer col) {
		this.col = col;
	}

	public Integer getCarTypeId() {
		return carTypeId;
	}

	public void setCarTypeId(Integer carTypeId) {
		this.carTypeId = carTypeId;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public Double getCarPrice() {
		return carPrice;
	}

	public void setCarPrice(Double carPrice) {
		this.carPrice = carPrice;
	}

	public Double getWashPrice() {
		return washPrice;
	}

	public void setWashPrice(Double washPrice) {
		this.washPrice = washPrice;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	public Long getDuration() {
		return duration;
	}

	
	
	
	
}
