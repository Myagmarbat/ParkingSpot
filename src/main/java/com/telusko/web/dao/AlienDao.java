package com.telusko.web.dao;

import java.sql.*;

import edu.mum.asd.project.application.web.ConnectionPool;
import com.telusko.web.model.Alien;

public class AlienDao {

    public Alien getAlien(int aid) {
        Alien a = new Alien();
        ResultSet rs = ConnectionPool.getData("select * from alien where aid=" + aid);
        try {
            if (rs != null && rs.next()) {
                a.setAid(rs.getInt("aid"));
                a.setAname(rs.getString("aname"));
                a.setTech(rs.getString("tech"));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return a;
    }

    public Alien getAlien1(int aid) {
        Alien a = new Alien();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = ConnectionPool.getConnection();
//			Connection con = DriverManager.getConnection("jdbc:mysql://10.10.11.170:3306/spotsystem", "user", "user");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from alien where aid=" + aid);
            if (rs.next()) {
                a.setAid(rs.getInt("aid"));
                a.setAname(rs.getString("aname"));
                a.setTech(rs.getString("tech"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return a;
    }

}
