package com.mvc.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBCon {
	private static final String URL = "jdbc:mariadb://localhost:3306/kd";
	private static final String DRIVER_NAME = "org.mariadb.jdbc.Driver";
	private static final String USER = "root";
	private static final String PASSWORD = "kd1824java";
	
	static {
		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	public static Connection getCon() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	public static void main(String[] args) {
		
//		Connection con = getCon();
//		Statement stmt = null;
//		ResultSet rs = null;
//		try {
//			stmt = con.createStatement();
//			String sql = "SELECT * FROM USER_INFO";
//			rs = stmt.executeQuery(sql);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally{
//			if(rs !=null) {
//				try {
//					rs.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			if(stmt != null) {
//				try {
//					stmt.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			try {
//				con.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
		try(Connection con = DBCon.getCon();){
			try(Statement stmt = con.createStatement();){
				String sql = "SELECT * FROM USER_INFO";
				try(ResultSet rs = stmt.executeQuery(sql)){
					
				}
			}
		}catch(Exception e) {
			
		}
	}
}




