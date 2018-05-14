/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.asd.project.fw.spot.dao;

import edu.mum.asd.project.application.util.SpotUtils;
import edu.mum.asd.project.application.web.ConnectionPool;
import edu.mum.asd.project.fw.report.model.Report;
import edu.mum.asd.project.fw.spot.Parking;
import edu.mum.asd.project.fw.spot.Spot;
import edu.mum.asd.project.fw.spot.SpotType;
import edu.mum.asd.project.fw.spot.model.SpotRecord;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author 985965
 */
public class SpotDAO {

    public static Integer createSpot(Spot obj) {
        try {
            return ConnectionPool.createData("INSERT INTO spot (row, col, parking_id, spot_type_id) VALUES ('"
                    + obj.getRow() + "', '" + obj.getCol() + "', '" + obj.getParking().getId() + "', '"
                    + obj.getSpotType().getId() + "');");
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static List<Spot> getSpots() {
        List<Spot> objs = new ArrayList<Spot>();
        ResultSet rs = ConnectionPool.getData("select * from spot");
        try {
            while (rs.next()) {
                objs.add(setObject2Spot(rs));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return objs;
    }

    public static List<Spot> getSpots(Integer pId) {
        List<Spot> objs = new ArrayList<Spot>();
        ResultSet rs = ConnectionPool.getData("select * from spot where parking_id=" + pId);
        try {
            while (rs.next()) {
                objs.add(setObject2Spot(rs));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return objs;
    }

    public static Spot getSpot(Integer id) {
        ResultSet rs = ConnectionPool.getData("select * from spot where spot_id=" + id);
        try {
            if (rs.next()) {
                return setObject2Spot(rs);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static Spot setObject2Spot(ResultSet rs) {
        Spot obj = new Spot();
        Parking p;
        SpotType st;
        try {
            obj.setId(rs.getInt("spot_id"));
            obj.setRow(rs.getInt("row"));
            obj.setCol(rs.getInt("col"));
            obj.setAvailable(rs.getBoolean("available"));
            p = new Parking();
            p.setId(rs.getInt("parking_id"));
            obj.setParking(p);
            st = new SpotType();
            st.setId(rs.getInt("spot_type_id"));
            obj.setSpotType(st);
        } catch (Exception e) {
            System.out.println(e);
        }
        return obj;
    }

    public static List<SpotRecord> getSpotRecord(Integer pId) {
        List<SpotRecord> objs = new ArrayList<SpotRecord>();
        ResultSet rs = ConnectionPool.getData(
                "SELECT s.spot_id, s.row, s.col, s.available, s.spot_type_id, r.record_id, r.customer_id, r.wash_requested, r.washed, r.price, r.checkin_date, r.checkout_date FROM spotsystem.spot s left join record_spot rs on s.spot_id = rs.spot_id left join record r on rs.record_id = r.record_id where (r.checkout_date is null or r.checkout_date >= now()) and parking_id="
                + pId);
        SpotRecord obj;
        try {
            while (rs.next()) {
                obj = new SpotRecord();
                obj.setId(rs.getInt("spot_id"));
                obj.setRow(rs.getInt("row"));
                obj.setCol(rs.getInt("col"));
                obj.setAvailable(rs.getBoolean("available"));

                obj.setCheckin(rs.getTime("checkin_date"));
                obj.setCustomerId(rs.getInt("customer_id"));
                obj.setWashed(rs.getBoolean("washed"));
                obj.setWashRequested(rs.getBoolean("wash_requested"));
                obj.setPrice(rs.getDouble("price"));
                obj.setRecordId(rs.getInt("record_id"));
                objs.add(obj);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return objs;
    }

    public static List<Report> getSpotsData(Integer parkingId) {
        if (parkingId == null) {
            return null;
        }

        String query = "select spot.*, \n"
                + "(select r.customer_id from record r \n"
                + "left join record_spot rs on rs.record_id=r.record_id\n"
                + "left join spot s on s.spot_id=rs.spot_id\n"
                + "where r.checkout_date is null and s.spot_id=spot.spot_id) as customer_id, \n"
                + "\n"
                + "(select r.record_id from record r \n"
                + "left join record_spot rs on rs.record_id=r.record_id\n"
                + "left join spot s on s.spot_id=rs.spot_id\n"
                + "where r.checkout_date is null and s.spot_id=spot.spot_id) as record_id, \n"
                + "\n"
                + "(select r.checkin_date from record r \n"
                + "left join record_spot rs on rs.record_id=r.record_id\n"
                + "left join spot s on s.spot_id=rs.spot_id\n"
                + "where r.checkout_date is null and s.spot_id=spot.spot_id) as checkin_date , \n"
                + "\n"
                + "(select r.checkout_date from record r \n"
                + "left join record_spot rs on rs.record_id=r.record_id\n"
                + "left join spot s on s.spot_id=rs.spot_id\n"
                + "where r.checkout_date is null and s.spot_id=spot.spot_id) as checkout_date  ,\n"
                + "\n"
                + "(select r.washed from record r \n"
                + "left join record_spot rs on rs.record_id=r.record_id\n"
                + "left join spot s on s.spot_id=rs.spot_id\n"
                + "where r.checkout_date is null and s.spot_id=spot.spot_id) as washed  ,\n"
                + "\n"
                + "(select r.wash_requested from record r \n"
                + "left join record_spot rs on rs.record_id=r.record_id\n"
                + "left join spot s on s.spot_id=rs.spot_id\n"
                + "where r.checkout_date is null and s.spot_id=spot.spot_id) as wash_requested  ,\n"
                + "\n"
                + "(select r.price from record r \n"
                + "left join record_spot rs on rs.record_id=r.record_id\n"
                + "left join spot s on s.spot_id=rs.spot_id\n"
                + "where r.checkout_date is null and s.spot_id=spot.spot_id) as price,  \n"
                + "(select r.car_type_id from record r \n"
                + "left join record_spot rs on rs.record_id=r.record_id\n"
                + "left join spot s on s.spot_id=rs.spot_id\n"
                + "where r.checkout_date is null and s.spot_id=spot.spot_id) as car_type_id\n"
                + "from spot where parking_id=" + parkingId;

        System.out.println(query);
        Connection con = ConnectionPool.getInstance().getConnection();
        List<Report> list = new ArrayList<Report>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Report report = new Report();
                report.setCustomerId(rs.getInt("customer_id"));
                report.setCheckinDate(rs.getDate("checkin_date"));
                report.setCheckoutDate(rs.getDate("checkout_date"));
                report.setWashed(rs.getInt("washed"));
                report.setWashRequested(rs.getInt("wash_requested"));
                report.setPrice(rs.getDouble("price"));
                report.setParkingId(rs.getInt("parking_id"));
                report.setSpotTypeId(rs.getInt("spot_type_id"));
                report.setRecordId(rs.getInt("record_id"));
                report.setSpotId(rs.getInt("spot_id"));
                report.setRow(rs.getInt("row"));
                report.setCol(rs.getInt("col"));
                report.setAvailable(rs.getInt("available"));
                report.setCarTypeId(rs.getInt("car_type_id"));
                list.add(report);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }

    public static Double calculatePrice(Integer recordId) {
        try {
            Connection con = ConnectionPool.getInstance().getConnection();
            if (recordId == null) {
                return new Double(0);
            }

            String query = "select record.*, ct.name car_name, ct.price car_price, ct.wash_price\r\n"
                    + "				from record\r\n"
                    + "				left join car_type ct on record.car_type_id = ct.car_type_id\r\n"
                    + "				where record_id = " + recordId;
            System.out.println("calc = " + query);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            Report report = null;
            while (rs.next()) {
                report = new Report();
                report.setCustomerId(rs.getInt("customer_id"));
                report.setCheckinDate(rs.getDate("checkin_date"));
                report.setCheckoutDate(rs.getDate("checkout_date"));
                report.setWashed(rs.getInt("washed"));
                report.setWashRequested(rs.getInt("wash_requested"));
                report.setCarPrice(rs.getDouble("car_price"));
                report.setWashPrice(rs.getDouble("wash_price"));
                report.setDuration(rs.getLong("duration"));
            }

            return report.getCarPrice() * SpotUtils.calculateDuration(report.getDuration())
                    + (report.getWashed() == 1 ? report.getWashPrice() : 0.0);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return new Double(0);
        }

    }
}
