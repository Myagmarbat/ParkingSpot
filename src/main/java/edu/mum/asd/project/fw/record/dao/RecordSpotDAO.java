/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.asd.project.fw.record.dao;

import edu.mum.asd.project.application.web.ConnectionPool;
import edu.mum.asd.project.fw.record.RecordSpot;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 985965
 */
public class RecordSpotDAO {

    public static void createRecordSpot(Integer rId, Integer sId) {
        try {
            ConnectionPool.createData("INSERT INTO record_spot (record_id, spot_id) VALUES ('" + rId + "', " + sId + ");");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static String checkAnd(String sql) {
        if (!sql.isEmpty()) {
            return " AND ";
        }
        return "";
    }

    public static List<RecordSpot> getRecordSpotsByRecord(Integer rId) {
        List<RecordSpot> objs = new ArrayList<RecordSpot>();

        String sql = "select * from record_spot where record_id=" + rId;
        ResultSet rs = ConnectionPool.getData(sql);
        try {
            while (rs.next()) {
                objs.add(setObject2RecordSpot(rs));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return objs;
    }

    public static List<RecordSpot> getRecordSpotsBySpot(Integer sId) {
        List<RecordSpot> objs = new ArrayList<RecordSpot>();

        String sql = "select * from record_spot where spot_id=" + sId;
        ResultSet rs = ConnectionPool.getData(sql);
        try {
            while (rs.next()) {
                objs.add(setObject2RecordSpot(rs));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return objs;
    }

    public static RecordSpot setObject2RecordSpot(ResultSet rs) {
        RecordSpot obj = new RecordSpot();
        try {
            obj.setRecordId(rs.getInt("record_id"));
            obj.setSpotId(rs.getInt("spot_id"));
        } catch (Exception e) {
            System.out.println(e);
        }
        return obj;
    }
}
