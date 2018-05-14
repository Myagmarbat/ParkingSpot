package edu.mum.asd.project.application.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import edu.mum.asd.project.application.web.ConnectionPool;
import edu.mum.asd.project.fw.report.model.Report;

public class SpotUtils {
	private static Connection con = null;
	
	public static long calculateDuration(long duration) {
		return duration / 86400;
	}
	
	
	
}
