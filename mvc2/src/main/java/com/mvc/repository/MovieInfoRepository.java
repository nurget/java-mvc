package com.mvc.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mvc.common.DBCon;

public class MovieInfoRepository {

	public List<Map<String, String>> selectMovieInfoList() {
		List<Map<String, String>> movieInfoList = new ArrayList<>();
		try {
			Connection con = DBCon.getCon();

			String sql = "SELECT * FROM MOVIE_INFO WHERE 1=1";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Map<String, String> movieInfo = new HashMap<>();
				movieInfo.put("miNum", rs.getString("MI_NUM"));
				movieInfo.put("miTitle", rs.getString("MI_TITLE"));
				movieInfo.put("miDesc", rs.getString("MI_DESC"));
				movieInfo.put("miGenre", rs.getString("MI_GENRE"));
				movieInfo.put("miCredat", rs.getString("MI_CREDAT"));
				movieInfo.put("miCnt", rs.getString("MI_CNT"));
				movieInfoList.add(movieInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return movieInfoList;

	}

	public Map<String, String> selectMovieInfo(String miNum) {

		try {
			Connection con = DBCon.getCon();

			String sql = "SELECT * FROM MOVIE_INFO WHERE 1=1 AND MI_NUM=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, miNum);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Map<String, String> movieInfo = new HashMap<>();
				movieInfo.put("miNum", rs.getString("MI_NUM"));
				movieInfo.put("miTitle", rs.getString("MI_TITLE"));
				movieInfo.put("miDesc", rs.getString("MI_DESC"));
				movieInfo.put("miGenre", rs.getString("MI_GENRE"));
				movieInfo.put("miCredat", rs.getString("MI_CREDAT"));
				movieInfo.put("miCnt", rs.getString("MI_CNT"));
				
				return movieInfo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int insertMovieInfo(Map<String,String> movieInfo) {
		String sql = "INSERT INTO MOVIE_INFO(MI_TITLE, MI_DESC, MI_GENRE, MI_CREDAT, MI_CNT)";
		sql += " VALUES(?,?,?,?,?)";
		Connection con = DBCon.getCon();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, movieInfo.get("miTitle"));
			ps.setString(2, movieInfo.get("miDesc"));
			ps.setString(3, movieInfo.get("miGenre"));
			ps.setString(4, movieInfo.get("miCredat"));
			ps.setString(5, movieInfo.get("miCnt"));
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int updateMovieInfo(Map<String,String> movieInfo) {
		String sql = "UPDATE MOVIE_INFO";
		sql += " SET MI_TITLE=?,";
		sql += " MI_DESC=?,";
		sql += " MI_GENRE=?,";
		sql += " MI_CREDAT=?,";
		sql += " MI_CNT=?";
		Connection con = DBCon.getCon();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, movieInfo.get("miTitle"));
			ps.setString(2, movieInfo.get("miDesc"));
			ps.setString(3, movieInfo.get("miGenre"));
			ps.setString(4, movieInfo.get("miCredat"));
			ps.setString(5, movieInfo.get("miCnt"));
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int deleteMovieInfo(String miNum) {
		String sql = "DELETE FROM MOVIE_INFO WHERE MI_NUM=?";
		Connection con = DBCon.getCon();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, miNum);
			return ps.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
