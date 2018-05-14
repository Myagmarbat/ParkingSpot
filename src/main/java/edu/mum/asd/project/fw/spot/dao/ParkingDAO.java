/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.asd.project.fw.spot.dao;

import edu.mum.asd.project.application.web.ConnectionPool;
import edu.mum.asd.project.fw.spot.Parking;
import edu.mum.asd.project.fw.spot.model.ParkingInfo;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 985965
 */
public class ParkingDAO {

    public static Integer createParking(String name) {
        try {
            return ConnectionPool.createData("INSERT INTO parking (name) VALUES ('" + name + "');");
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    public static List<ParkingInfo> countParkings() {
    	List<ParkingInfo> objs = new ArrayList<ParkingInfo>();
    	ParkingInfo obj;
        
        ResultSet rs = ConnectionPool.getData("SELECT\r\n" + 
        		"    spot.parking_id, parking.name\r\n" + 
        		"   ,COUNT(*) as capacity\r\n" + 
        		"   ,SUM( CASE WHEN spot_type_id = 1 THEN 1 ELSE 0 END) as regular\r\n" + 
        		"   ,SUM( CASE WHEN spot_type_id = 2 THEN 1 ELSE 0 END) as truck\r\n" + 
        		"   \r\n" + 
        		"FROM spot\r\n" + 
        		"join parking on spot.parking_id = parking.parking_id\r\n" + 
        		"GROUP BY parking_id;" );
        
        try {
            while (rs.next()) {
                obj = new ParkingInfo();
                obj.setParkId(rs.getInt("parking_id"));
                obj.setParkName(rs.getString("name"));
                obj.setCapacity(rs.getInt("capacity"));
                obj.setRegular(rs.getInt("regular"));
                obj.setTruck(rs.getInt("truck"));
                objs.add(obj);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return objs;
    	
    }
    public static List<Parking> getParkings() {
        List<Parking> objs = new ArrayList<Parking>();
        Parking obj = new Parking();
        ResultSet rs = ConnectionPool.getData("select * from parking");
        try {
            while (rs.next()) {
                obj = new Parking();
                obj.setId(rs.getInt("parking_id"));
                obj.setName(rs.getString("name"));
                
                objs.add(obj);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return objs;
    }

    public static Parking getParking(Integer id) {
        Parking obj = new Parking();
        ResultSet rs = ConnectionPool.getData("select * from parking where parking_id=" + id);
        try {
            if (rs.next()) {
                obj.setId(rs.getInt("parking_id"));
                obj.setName(rs.getString("name"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return obj;
    }
}
