package dao.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ReplyDao {
	
	private ReplyDao() {}
	
	private static ReplyDao instance;
	
	public static ReplyDao getInstance() {
		if (instance == null) {
			instance = new ReplyDao();
		}
		return  instance;
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

	public List<Reply> select(int bNo) throws SQLException {
		Connection conn = getConnection();
		Statement stmt = null;
		String sql = "SELECT " 
				+ "r.*, m.m_name " 
				+ "FROM reply r " 
				+ "LEFT JOIN member m " 
				+ "ON r.m_no = m.m_no " 
				+ "WHERE b_no ="+ bNo; 
		ResultSet rs = null;
		List<Reply> list = new ArrayList<>();
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Reply reply = new Reply();
				
				reply.setbNo(rs.getInt("b_no"));
				reply.setmNo(rs.getInt("m_no"));
				reply.setBrNo(rs.getInt("br_no"));
				reply.setContent(rs.getString("br_content"));
				reply.setDate(rs.getDate("br_date"));
				reply.setWriter(rs.getString("m_name"));
				
				list.add(reply);	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) stmt.close();
			if (conn !=null) conn.close();
			if (rs !=null) rs.close();
		}
		return list;
	}

	public int insert(Reply reply) throws SQLException {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO reply values(?, ?, br_no.nextval, ?, sysdate)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reply.getbNo());
			pstmt.setInt(2, reply.getmNo());
			pstmt.setString(3, reply.getContent());
			int result = pstmt.executeUpdate();
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) pstmt.close();
			if (conn !=null) conn.close();
		}
		return 0;
	}

	public int delete(int brNo) throws SQLException {
		Connection conn = getConnection();
		Statement stmt = null;
		String sql = "DELETE FROM reply WHERE br_no=" + brNo; 
		int result = 0;
		try {
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			if (conn != null) conn.close();
			if (stmt != null) stmt.close();
		}
		return result;
	}

	public int countReply(int bNo) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "SELECT COUNT(*) FROM reply WHERE b_no=?";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bNo);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
		}
		return result;
	}

	public int deleteAllReply(int bNo) throws SQLException {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM reply WHERE b_no=?";
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







