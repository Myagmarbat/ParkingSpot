/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.asd.project.fw.record;

import edu.mum.asd.project.fw.notify.Observer;
import edu.mum.asd.project.fw.spot.Spot;
import java.util.Date;
import java.util.List;

/**
 *
 * @author 985965
 */
public class Record extends Observer {
    private Integer recordId;
    private Integer customerId;
    private boolean washRequested;
    private boolean washed;
    private Date checkIn;
    private Date checkOut;
    private float price;
    private List<Spot> spotIds;

    /**
     * @return the recordId
     */
    public Integer getRecordId() {
        return recordId;
    }

    /**
     * @param recordId the recordId to set
     */
    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

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
     * @return the checkIn
     */
    public Date getCheckIn() {
        return checkIn;
    }

    /**
     * @param checkIn the checkIn to set
     */
    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    /**
     * @return the checkOut
     */
    public Date getCheckOut() {
        return checkOut;
    }

    /**
     * @param checkOut the checkOut to set
     */
    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    /**
     * @return the price
     */
    public float getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * @return the spotIds
     */
    public List<Spot> getSpotIds() {
        return spotIds;
    }

    /**
     * @param spotIds the spotIds to set
     */
    public void setSpotIds(List<Spot> spotIds) {
        this.spotIds = spotIds;
    }

	public boolean isWashRequested() {
		return washRequested;
	}

	public void setWashRequested(boolean washRequested) {
		this.washRequested = washRequested;
	}

	public boolean isWashed() {
		return washed;
	}

	public void setWashed(boolean washed) {
		this.washed = washed;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}   

    
}
