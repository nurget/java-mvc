package com.mvc.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mvc.common.DBCon;

public class ClassInfoRepository {

	public List<Map<String, String>> selectClassInfoList() {

		String driverName = "org.mariadb.jdbc.Driver";
		String url = "jdbc:mariadb://localhost:3306/kd";
		String user = "root";
		String pwd = "kd1824java";
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		List<Map<String, String>> classInfoList = new ArrayList<>();
		try (Connection con = DriverManager.getConnection(url, user, pwd)) {
			String sql = "SELECT * FROM CLASS_INFO WHERE 1=1";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Map<String, String> classInfo = new HashMap<>();
				classInfo.put("ciNum", rs.getString("CI_NUM"));
				classInfo.put("ciName", rs.getString("CI_NAME"));
				classInfo.put("ciDesc", rs.getString("CI_DESC"));
				classInfoList.add(classInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return classInfoList;
		
	}

	public Map<String, String> classInfoList(String ciNum) {
		String sql = "SELECT * FROM CLASS_INFO WHERE 1=1 AND CI_NUM=?";
		try (Connection con = DBCon.getCon()) {
			try (PreparedStatement ps = con.prepareStatement(sql)) {
				ps.setString(1, ciNum);
				try (ResultSet rs = ps.executeQuery()) {
					if (rs.next()) {
						Map<String, String> classInfo = new HashMap<>();
						classInfo.put("ciNum", rs.getString("CI_NUM"));
						classInfo.put("ciName", rs.getString("CI_NAME"));
						classInfo.put("ciDEsc", rs.getString("CI_DESC"));
						return classInfo;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		ClassInfoRepository ciRepo = new ClassInfoRepository();
		List<Map<String, String>> classInfoList = ciRepo.selectClassInfoList();
		for(Map<String, String> classInfo : classInfoList) {
			System.out.println(classInfo);
		}
	}
}
