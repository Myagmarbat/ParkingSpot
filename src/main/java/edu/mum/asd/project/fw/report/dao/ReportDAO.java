/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.asd.project.fw.report.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.mum.asd.project.application.util.SpotUtils;
import edu.mum.asd.project.application.web.ConnectionPool;
import edu.mum.asd.project.fw.report.model.Report;

/**
 *
 * @author 985965
 */
public class ReportDAO {
	public List<Report> getReports(String searchWord, Integer parkId) {
		System.out.println("=" + searchWord + "=");
		String query = "select *\r\n" + 
				"from (\r\n" + 
				"	select record.customer_id, \r\n" + 
				"		concat(concat(c.last_name, ' '), c.first_name) customer_name,\r\n" + 
				"		record.checkin_date, \r\n" + 
				"		record.checkout_date, \r\n" + 
				"		record.washed,\r\n" + 
				"		record.wash_requested,\r\n" + 
				"		record.price, \r\n" + 
				"		spot.parking_id, \r\n" + 
				"		parking.name parking_name,\r\n" + 
				"		spot_type.spot_type_id,\r\n" + 
				"		spot_type.name spot_type_name, \r\n" + 
				"		record.record_id, \r\n" + 
				"		spot.spot_id, \r\n" + 
				"		spot.row,\r\n" + 
				"		spot.col,\r\n" + 
				"		spot.available \r\n" + 
				"	from record\r\n" + 
				"	left join customer c on record.customer_id = c.customer_id\r\n" + 
				"	join record_spot rs on record.record_id = rs.record_id\r\n" + 
				"	join spot on spot.spot_id = rs.spot_id\r\n" + 
				"	left join parking on parking.parking_id = spot.parking_id\r\n" + 
				"	left join spot_type on spot_type.spot_type_id = spot.spot_type_id\r\n" + 
				"	\r\n" + 
				") a\r\n" + 
				"where 1 = 1 \r\n";
				if(!(searchWord == null || searchWord.trim().equals(""))) {
					query += "	and (lower(a.parking_name) like '%" + searchWord.toLowerCase() + "%'\r\n";
					query += " or lower(a.customer_name) like '%" + searchWord.toLowerCase() + "%')\r\n";
				}
				if(parkId != null){
					query += " and a.parking_id = " + parkId + "\r\n";
				}
				
				System.out.println(query);
		Connection con = ConnectionPool.getInstance().getConnection();
		List<Report> list = new ArrayList<Report>();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				Report report = new Report();
				report.setCustomerId(rs.getInt("customer_id"));
				report.setCustomerName(rs.getString("customer_name"));
				report.setCheckinDate(rs.getDate("checkin_date"));
				report.setCheckoutDate(rs.getDate("checkout_date"));
				report.setWashed(rs.getInt("washed"));
				report.setPrice(rs.getDouble("price"));
				report.setParkingId(rs.getInt("parking_id"));
				report.setParkingName(rs.getString("parking_name"));
				report.setSpotTypeId(rs.getInt("spot_type_id"));
				report.setSpotTypeName(rs.getString("spot_type_name"));
				report.setRecordId(rs.getInt("record_id"));
				report.setSpotId(rs.getInt("spot_id"));
				report.setRow(rs.getInt("row"));
				report.setCol(rs.getInt("col"));
				report.setAvailable(rs.getInt("available"));
				report.setWashRequested(rs.getInt("wash_requested"));
				list.add(report);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
