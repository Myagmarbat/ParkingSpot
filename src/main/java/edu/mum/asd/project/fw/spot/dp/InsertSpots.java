/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.asd.project.fw.spot.dp;

import edu.mum.asd.project.fw.spot.Parking;
import edu.mum.asd.project.fw.spot.Spot;
import edu.mum.asd.project.fw.spot.SpotType;
import edu.mum.asd.project.fw.spot.dao.SpotDAO;
import edu.mum.asd.project.fw.spot.model.ParkingSpotInsert;
import java.util.List;

/**
 *
 * @author 985965
 */
public class InsertSpots {

    public static void create(Parking p, List<ParkingSpotInsert> objs) {
        Spot s = new Spot();
        Integer row = 1;
        Integer col = 1;
        SpotType st = new SpotType();
        for (ParkingSpotInsert obj : objs) {
            col = 1;
            for (int i = 0; i < obj.getCount(); i++) {
                s.setRow(row);
                s.setCol(col);
                s.setParking(p);
                st.setId(obj.getType());
                s.setSpotType(st);
                SpotDAO.createSpot(s);
                col++;
            }
            row++;
        }
    }
}
