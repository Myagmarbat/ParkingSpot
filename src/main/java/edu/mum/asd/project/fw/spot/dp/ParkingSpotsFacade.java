/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.asd.project.fw.spot.dp;

import edu.mum.asd.project.fw.report.model.Report;
import edu.mum.asd.project.fw.spot.Parking;
import edu.mum.asd.project.fw.spot.Spot;
import edu.mum.asd.project.fw.spot.dao.ParkingDAO;
import edu.mum.asd.project.fw.spot.dao.SpotDAO;
import edu.mum.asd.project.fw.spot.model.ParkingInfo;
import edu.mum.asd.project.fw.spot.model.ParkingSpotInsert;
import edu.mum.asd.project.fw.spot.model.SpotRecord;

import java.util.List;

/**
 *
 * @author 985965
 */
public class ParkingSpotsFacade {

    public void Process(String name, List<ParkingSpotInsert> objs) {
        Integer pId = ParkingDAO.createParking(name);
        if (pId != null) {
            Parking p = new Parking();
            p.setId(pId);
            InsertSpots.create(p, objs);
        }
    }

    public List<Parking> getParking() {
        return ParkingDAO.getParkings();
    }

    public List<Spot> getSpotsParking(Integer pId) {
        return SpotDAO.getSpots(pId);
    }

    public List<ParkingInfo> countParkings() {
        return ParkingDAO.countParkings();
    }

    public List<SpotRecord> getSpotRecord(Integer pId) {
        return SpotDAO.getSpotRecord(pId);
    }

    public List<Report> getSpotsData(Integer pId) {
        return SpotDAO.getSpotsData(pId);
    }

    public Double calculatePrice(Integer rId) {
        return SpotDAO.calculatePrice(rId);
    }
}
