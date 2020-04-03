package dao.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class LikeDao {

	private LikeDao() {}
	
	private static LikeDao instance;
	
	public static LikeDao getInstance() {
		if (instance == null) {
			instance = new LikeDao();
			
		}
		return instance;
	}
	
	private Connection getConnection() {
		
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/OracleDB");
			conn = ds.getConnection(); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public int count(int bNo, int mNo) throws SQLException {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT count(*) FROM likes WHERE b_no=? and m_no=?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bNo);
			pstmt.setInt(2, mNo);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return rs.getInt(1);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) conn.close();
			if (pstmt != null) pstmt.close();
			if (rs != null) rs.close();
		}
		return 0;
	}

	public void insertLike(int mNo, int bNo) throws SQLException{
		Connection conn = null;
		Statement stmt = null;
		String sql = "INSERT INTO likes values(" + bNo +", " + mNo +")";
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) conn.close();
			if (stmt != null) stmt.close();
		}
				
	}

	public void deleteLike(int mNo, int bNo) throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		String sql = "DELETE FROM likes WHERE b_no=" + bNo + " and m_no=" + mNo;
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) conn.close();
			if (stmt != null) stmt.close();
		}
	}

	public int deleteAllLike(int bNo) throws SQLException{
		
		Connection conn = null;
		Statement stmt = null;
		String sql ="DELETE FROM likes WHERE b_no=" + bNo;
		int result = 0;
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) conn.close();
			if (stmt != null) stmt.close();
		}
		return result;
	}

	public int countLike(int bNo) throws SQLException {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "SELECT COUNT(*) FROM likes WHERE b_no=?";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bNo);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) conn.close();
			if (pstmt != null) pstmt.close();
		}
		
		return result;
	}
	
}







