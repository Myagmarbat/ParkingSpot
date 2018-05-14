package edu.mum.asd.project.application.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import edu.mum.asd.project.application.model.Staff;
import edu.mum.asd.project.application.web.ConnectionPool;

public class LoginDao {
	static Connection currentCon = null;
	static ResultSet rs = null;

	public static Staff login(Staff bean) {

		// preparing some objects for connection
		Statement stmt = null;

		String username = bean.getStaffName();
		String password = bean.getStaffPass();

		String searchQuery = "select * from staff where staff_name='" + username + "' AND staff_pass='" + password + "'";

		// "System.out.println" prints in the console; Normally used to trace the
		// process
		System.out.println("Your user name is " + username);
		System.out.println("Your password is " + password);
		System.out.println("Query: " + searchQuery);

		try {
			// connect to DB
			currentCon = ConnectionPool.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(searchQuery);
			boolean more = rs.next();

			// if user does not exist set the isValid variable to false
			if (!more) {
				System.out.println("Sorry, you are not a registered user! Please sign up first");
				bean.setValid(false);
			}

			// if user exists set the isValid variable to true
			else if (more) {
				String staffName = rs.getString("staff_name");
				System.out.println("Welcome " + staffName);
				bean.setStaffName(staffName);
				bean.setValid(true);
			}
		}

		catch (Exception ex) {
			System.out.println("Log In failed: An Exception has occurred! " + ex);
		}

		// some exception handling
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
				stmt = null;
			}

			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}

				currentCon = null;
			}
		}

		return bean;

	}
}