package edu.mum.asd.project.application.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionPool {

    private final static int MAX_CONNECTIONS = 8;
    private static ConnectionPool instance = null;  // lazy loading
    private static Connection[] connections = new Connection[MAX_CONNECTIONS];
    private static String dbUrl = "jdbc:mysql://10.10.11.170:3306/spotsystem?autoReconnect=true";
    private static int counter;

    private ConnectionPool() {
    }

    public static ConnectionPool getInstance() {
        if (instance == null) {
            synchronized (ConnectionPool.class) {
                if (instance == null) {
                    instance = new ConnectionPool();
                    initializeConnections();
                    counter = 0;
                }
            }
        }

        return instance;
    }

    private static void initializeConnections() {
        for (int i = 0; i < MAX_CONNECTIONS; i++) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connections[i] = DriverManager.getConnection(dbUrl, "user", "user");
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public static Connection getConnection() {
        getInstance();
        counter++;
        if (counter == Integer.MAX_VALUE) {
            counter = 0;
        }

        return connections[counter % MAX_CONNECTIONS];
    }

    public static Integer createData(String query) {
        try {
            Statement st = ConnectionPool.getConnection().createStatement();
            System.out.println("createData: " + query);
            st.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = st.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static ResultSet getData(String query) {
        try {
            Statement st = ConnectionPool.getConnection().createStatement();
            System.out.println("getData: " + query);
            ResultSet rs = st.executeQuery(query);
//            if (rs.next()) {
            return rs;
//            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;

    }

    public static Integer updateData(String query) {
        try {
            Statement st = ConnectionPool.getConnection().createStatement();
            System.out.println("updateData: " + query);
            return st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;

    }

}
