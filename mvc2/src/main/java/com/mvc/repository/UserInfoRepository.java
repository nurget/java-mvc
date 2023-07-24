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

public class UserInfoRepository {

	public List<Map<String,String>> selectuserInfoList() {
		List<Map<String,String>> userInfoList = new ArrayList<>();
		
		try {
			Connection con =  DBCon.getCon();

			String sql = "SELECT * FROM USER_INFO WHERE 1=1";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet  rs = ps.executeQuery();
			while(rs.next()) {
				Map<String,String> userInfo = new HashMap<>();
				userInfo.put("uiNum", rs.getString("UI_NUM"));
				userInfo.put("uiName", rs.getString("UI_NAME"));
				userInfo.put("uiId", rs.getString("UI_ID"));
				userInfo.put("uiPwd", rs.getString("UI_PWD"));
				userInfoList.add(userInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userInfoList;
		
	}

	public Map<String,String> selectUserInfo(String uiNum) {
		
		try {
			Connection con = DBCon.getCon();

			String sql = "SELECT * FROM USER_INFO WHERE 1=1 AND UI_NUM=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,uiNum);
			ResultSet  rs = ps.executeQuery();
			while(rs.next()) {
				Map<String,String> userInfo = new HashMap<>();
				userInfo.put("uiNum", rs.getString("UI_NUM"));
				userInfo.put("uiName", rs.getString("UI_NAME"));
				userInfo.put("uiId", rs.getString("UI_ID"));
				userInfo.put("uiPwd", rs.getString("UI_PWD"));
				return userInfo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int insertUserInfo(Map<String,String> userInfo) {
		String sql = "INSERT INTO USER_INFO(UI_ID, UI_PWD, UI_NAME)";
		sql += " VALUES(?,?,?)";
		Connection con = DBCon.getCon();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userInfo.get("uiId"));
			ps.setString(2, userInfo.get("uiPwd"));
			ps.setString(3, userInfo.get("uiName"));
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int updateUserInfo(Map<String,String> userInfo) {
		String sql = "UPDATE USER_INFO";
		sql += " SET UI_ID=?,";
		sql += " UI_PWD=?,";
		sql += " UI_NAME=?";
		sql += " WHERE UI_NUM=?";
		Connection con = DBCon.getCon();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userInfo.get("uiId"));
			ps.setString(2, userInfo.get("uiPwd"));
			ps.setString(3, userInfo.get("uiName"));
			ps.setString(4, userInfo.get("uiNum"));
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int deleteUserInfo(String uiNum) {
		String sql = "DELETE FROM USER_INFO WHERE UI_NUM=?";
		Connection con = DBCon.getCon();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, uiNum);
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}








