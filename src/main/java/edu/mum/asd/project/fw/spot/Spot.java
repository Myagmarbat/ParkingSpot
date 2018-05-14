/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.asd.project.fw.spot;

/**
 *
 * @author 985965
 */
public class Spot {

    private Integer id;
    private Integer row;
    private Integer col;
    private boolean available;
    private Parking parking;
    private SpotType spotType;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the row
     */
    public Integer getRow() {
        return row;
    }

    /**
     * @param row the row to set
     */
    public void setRow(Integer row) {
        this.row = row;
    }

    /**
     * @return the col
     */
    public Integer getCol() {
        return col;
    }

    /**
     * @param col the col to set
     */
    public void setCol(Integer col) {
        this.col = col;
    }

    /**
     * @return the available
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     * @param available the available to set
     */
    public void setAvailable(boolean available) {
        this.available = available;
    }

    /**
     * @return the parking
     */
    public Parking getParking() {
        return parking;
    }

    /**
     * @param parking the parking to set
     */
    public void setParking(Parking parking) {
        this.parking = parking;
    }

    /**
     * @return the spotId
     */
    public SpotType getSpotType() {
        return spotType;
    }

    /**
     * @param spotId the spotId to set
     */
    public void setSpotType(SpotType spot) {
        this.spotType = spot;
    }
}
