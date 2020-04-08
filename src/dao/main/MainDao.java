package dao.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dao.main.*;
import dao.cook.Cook;

public class MainDao {
	private static MainDao instance;
	private MainDao() {}
	public static MainDao getInstance() {
		if (instance == null) {	instance = new MainDao();		}
		return instance;
	}
	
	private Connection getConnection() {
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource)
				ctx.lookup("java:comp/env/jdbc/OracleDB");
			conn = ds.getConnection();
		}catch(Exception e) { System.out.println(e.getMessage());	}
		return conn;
	}
	
	public List<Main> select() throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		String sql ="select * from cook";
		Main main = null;
		List<Main> list = new ArrayList<>();
		try {
			conn= getConnection();
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				main = new Main();
				main.setC_name(rs.getString("c_name"));
				main.setC_img(rs.getString("c_img"));
				list.add(main);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		return list;
	}
	
	public List<Main> mbest() throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		String sql ="select * from(select * from cook order by c_hits desc) where rownum <=4";
		Main main = null;
		List<Main> list = new ArrayList<>();
		try {
			conn= getConnection();
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				main = new Main();
				main.setC_name(rs.getString("c_name"));
				main.setC_img(rs.getString("c_img"));
				list.add(main);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		return list;
	}
	
	public List<Main> sbest() throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		String sql ="select * from(select * from store order by s_readcount desc) where rownum <=5";
		Main main = null;
		List<Main> list = new ArrayList<>();
		try {
			conn= getConnection();
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				main = new Main();
				main.setS_url(rs.getString("s_url"));
				main.setS_title(rs.getString("s_title"));
				main.setS_img(rs.getString("s_img"));
				list.add(main);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		return list;
	}
}
