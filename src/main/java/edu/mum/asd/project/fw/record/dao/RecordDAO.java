/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.asd.project.fw.record.dao;

import edu.mum.asd.project.application.web.ConnectionPool;
import edu.mum.asd.project.fw.record.Record;
import edu.mum.asd.project.fw.record.model.RecordFilter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 985965
 */
public class RecordDAO {

    public static Integer createRecord(Integer carTypeId, Integer cId) {
        try {
            if (cId != null) {
                return ConnectionPool.createData("INSERT INTO record (customer_id, checkin_date, car_type_id) VALUES ('" + cId + "', NOW(), " + carTypeId + ");");
            } else {
                return ConnectionPool.createData("INSERT INTO record (checkin_date, car_type_id) VALUES (NOW(), " + carTypeId + ");");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    private static String checkAnd(String sql) {
        if (!sql.isEmpty()) {
            return " AND ";
        }
        return "";
    }

    public static List<Record> getRecords(RecordFilter filter) {
        List<Record> objs = new ArrayList<Record>();

        String sql = "select * from record ";
        String sqlSub = "";
        if (filter.getCustomerId() != null) {
            sqlSub += checkAnd(sqlSub) + " customer_id=" + filter.getCustomerId() + " ";
        }

        if (filter.getParkingId() != null) {
            sqlSub += checkAnd(sqlSub) + " parking_id=" + filter.getParkingId() + " ";
        }

        if (filter.getCheckInStart() != null) {
            sqlSub += checkAnd(sqlSub) + " check_in >= '" + filter.getCheckInStart() + "' ";
        }
        if (filter.getCheckInEnd() != null) {
            sqlSub += checkAnd(sqlSub) + " check_in <= '" + filter.getCheckInEnd() + "' ";
        }
        if (filter.getCheckOutStart() != null) {
            sqlSub += checkAnd(sqlSub) + " check_out >='" + filter.getCheckOutStart() + "' ";
        }
        if (filter.getCheckOutEnd() != null) {
            sqlSub += checkAnd(sqlSub) + " check_out <='" + filter.getCheckOutEnd() + "' ";
        }
        if (filter.getSpotTypeId() != null) {
            sqlSub += checkAnd(sqlSub) + " spot_type_id=" + filter.getSpotTypeId() + " ";
        }

        if (filter.getWashRequested() != null) {
            sqlSub += checkAnd(sqlSub) + " wash_requested=" + filter.getWashRequested() + " ";
        }

        if (filter.getWashed() != null) {
            sqlSub += checkAnd(sqlSub) + " washed=" + filter.getWashed() + " ";
        }

        if (!sqlSub.isEmpty()) {
            sql += " where " + sqlSub;
        }

        ResultSet rs = ConnectionPool.getData(sql);
        try {
            while (rs.next()) {
                objs.add(setObject2Record(rs));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return objs;
    }

    public static void setCheckOutDate(Integer rId) {
        try {
            ConnectionPool.updateData("UPDATE record SET checkout_date = NOW(), duration = TIMESTAMPDIFF(SECOND, checkin_date, checkout_date) WHERE record_id=" + rId + ";");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void setPrice(Integer rId, float price) {
        try {
            ConnectionPool.updateData("UPDATE record SET pricec = " + price + " WHERE record_id=" + rId + ";");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void setWashCar(Integer rId) {
        try {
            ConnectionPool.updateData("UPDATE record SET wash_requested = 1 WHERE record_id=" + rId + ";");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void setWashedCar(Integer rId) {
        try {
            ConnectionPool.updateData("UPDATE record SET washed = 1 WHERE record_id=" + rId + ";");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static List<Record> getRecordsByParking(Integer pId) {
        List<Record> objs = new ArrayList<Record>();
        ResultSet rs = ConnectionPool.getData("select * from record where parking_id=" + pId);
        try {
            while (rs.next()) {
                objs.add(setObject2Record(rs));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return objs;
    }

    public static Record getRecordById(Integer id) {
        ResultSet rs = ConnectionPool.getData("select * from record where record_id=" + id);
        try {
            if (rs.next()) {
                return setObject2Record(rs);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static Record setObject2Record(ResultSet rs) {
        Record obj = new Record();
        try {
            obj.setRecordId(rs.getInt("record_id"));
            obj.setCustomerId(rs.getInt("customer_id"));
            obj.setCheckIn(rs.getDate("check_in"));
            obj.setCheckOut(rs.getDate("check_out"));
            obj.setPrice(rs.getFloat("price"));
            obj.setWashRequested(rs.getBoolean("wash_requested"));
            obj.setWashed(rs.getBoolean("washed"));
        } catch (Exception e) {
            System.out.println(e);
        }
        return obj;
    }
    
    public static void setParkWash(int pId) {
    	try {
            ConnectionPool.updateData("update record\r\n" + 
            		"left join record_spot on record_spot.record_id = record.record_id\r\n" + 
            		"left join spot on spot.spot_id = record_spot.spot_id\r\n" + 
            		"set record.washed = 1\r\n" + 
            		"where record.wash_requested = 1 and spot.parking_id = " + pId + ";");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
