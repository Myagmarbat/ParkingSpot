/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.asd.project.fw.record.model;

/**
 *
 * @author 985965
 */
public class RecordFilter {
    private Integer customerId;
    private Integer parkingId;
    private String checkInStart;
    private String checkInEnd;
    private String checkOutStart;
    private String checkOutEnd;
    private Integer spotTypeId;
    private Integer washRequested;
    private Integer washed;

    /**
     * @return the customerId
     */
    public Integer getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId the customerId to set
     */
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    /**
     * @return the parkingId
     */
    public Integer getParkingId() {
        return parkingId;
    }

    /**
     * @param parkingId the parkingId to set
     */
    public void setParkingId(Integer parkingId) {
        this.parkingId = parkingId;
    }

    /**
     * @return the spotTypeId
     */
    public Integer getSpotTypeId() {
        return spotTypeId;
    }

    /**
     * @param spotTypeId the spotTypeId to set
     */
    public void setSpotTypeId(Integer spotTypeId) {
        this.spotTypeId = spotTypeId;
    }

    /**
     * @return the checkInStart
     */
    public String getCheckInStart() {
        return checkInStart;
    }

    /**
     * @param checkInStart the checkInStart to set
     */
    public void setCheckInStart(String checkInStart) {
        this.checkInStart = checkInStart;
    }

    /**
     * @return the checkInEnd
     */
    public String getCheckInEnd() {
        return checkInEnd;
    }

    /**
     * @param checkInEnd the checkInEnd to set
     */
    public void setCheckInEnd(String checkInEnd) {
        this.checkInEnd = checkInEnd;
    }

    /**
     * @return the checkOutStart
     */
    public String getCheckOutStart() {
        return checkOutStart;
    }

    /**
     * @param checkOutStart the checkOutStart to set
     */
    public void setCheckOutStart(String checkOutStart) {
        this.checkOutStart = checkOutStart;
    }

    /**
     * @return the checkOutEnd
     */
    public String getCheckOutEnd() {
        return checkOutEnd;
    }

    /**
     * @param checkOutEnd the checkOutEnd to set
     */
    public void setCheckOutEnd(String checkOutEnd) {
        this.checkOutEnd = checkOutEnd;
    }

	public Integer getWashRequested() {
		return washRequested;
	}

	public void setWashRequested(Integer washRequested) {
		this.washRequested = washRequested;
	}

	public Integer getWashed() {
		return washed;
	}

	public void setWashed(Integer washed) {
		this.washed = washed;
	}

   

}
