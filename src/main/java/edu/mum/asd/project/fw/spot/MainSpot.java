/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.asd.project.fw.spot;

import edu.mum.asd.project.fw.spot.dp.ParkingSpotsFacade;
import edu.mum.asd.project.fw.spot.model.ParkingSpotInsert;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 985965
 */
public class MainSpot {
    public static void main(String[] args) {
        ParkingSpotsFacade f = new ParkingSpotsFacade();
        List<ParkingSpotInsert> l = new ArrayList<>();
        l.add(new ParkingSpotInsert(10,1));
        l.add(new ParkingSpotInsert(5,2));
        l.add(new ParkingSpotInsert(15,1));
        l.add(new ParkingSpotInsert(23,1));
        l.add(new ParkingSpotInsert(12,2));
        f.Process("test3", l);
    }
    
}
