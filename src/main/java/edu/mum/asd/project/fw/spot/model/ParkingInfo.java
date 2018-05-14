package edu.mum.asd.project.fw.spot.model;

public class ParkingInfo {
	Integer parkId;
	String parkName;
	Integer truck;
	Integer regular;
	Integer capacity;
	public int getParkId() {
		return parkId;
	}
	public void setParkId(int parkId) {
		this.parkId = parkId;
	}
	public String getParkName() {
		return parkName;
	}
	public void setParkName(String parkName) {
		this.parkName = parkName;
	}
	
	public Integer getCapacity() {
		return capacity;
	}
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	public void setRegular(int cnt) {
		this.regular = cnt;
	}
	public void setTruck(int cnt) {
		this.truck = cnt;
	}
	public Integer getRegular() {
		return regular;
	}
	public Integer getTruck() {
		return truck;
	}
	
	
}
