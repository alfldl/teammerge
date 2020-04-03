package dao.board;

import java.sql.*;
import java.util.*;
import java.util.Date;

import javax.naming.*;
import javax.sql.DataSource;


public class BoardDao {
	
	private BoardDao() {}
	
	private static BoardDao instance;
	
	public static BoardDao getInstance() {
		if (instance == null) {
			instance = new BoardDao();
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

	public int getTotalCnt() throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		int totalCnt =0;
		String sql = "select count(*) from board";
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) totalCnt= rs.getInt(1);
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) rs.close();
			if (stmt != null) stmt.close();
			if (conn !=null) conn.close();
		}
		return totalCnt;
	}

	public List<Board> list(int startRow, int endRow) throws SQLException {
		
		List<Board> list = new ArrayList<Board>();
		Connection conn = null;	
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		
		 String sql =
				 
				 "SELECT * FROM ( "
					 + "SELECT rownum rnum, a.* "
					 + "FROM "
					 + "( "
					 +	 "SELECT "
					 + 		"b.b_no, b.m_no, b.b_title, b.like_cnt, b.b_date, b.b_hits, m.m_name "
					 + 	 "FROM board b "
					 + 	 "LEFT JOIN member m "
					 +   "ON b.m_no = m.m_no "
					 +   "ORDER BY b_no DESC) a "
				 + ") "+
				 "WHERE rnum BETWEEN ? AND ?";
		 
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Board board = new Board();
				board.setbNo(rs.getInt("b_no"));
				board.setmNo(rs.getInt("m_no"));
				board.setWriter(rs.getString("m_name"));
				board.setTitle(rs.getString("b_title"));
				board.setbDate(rs.getDate("b_date"));
				board.setHits(rs.getInt("b_hits"));
				board.setLikeCnt(rs.getInt("like_cnt"));
				
				list.add(board);
			}	
		} catch(Exception e) {	
			e.printStackTrace(); 
		} finally {
			if (rs !=null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn !=null) conn.close();
		}
		return list;
	}

	public Board select(int bNo) throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT " 
				+ "b.b_no, b.m_no, b.b_title, b_content, b.like_cnt, b.b_date, b.b_hits, m.m_name " 
				+ "FROM board b " 
				+ "LEFT JOIN member m " 
				+ "ON b.m_no = m.m_no " 
				+ "WHERE b_no ="+bNo 
				+ " ORDER BY b_no DESC"; 
		Board board = new Board();
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				board.setbNo(rs.getInt("b_no"));
				board.setmNo(rs.getInt("m_no"));
				board.setWriter(rs.getString("m_name"));
				board.setTitle(rs.getString("b_title"));
				board.setContent(rs.getString("b_content"));
				board.setLikeCnt(rs.getInt("like_cnt"));
				board.setbDate(rs.getDate("b_date"));
				board.setHits(rs.getInt("b_hits"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs !=null) rs.close();
			if (stmt != null) stmt.close();
			if (conn !=null) conn.close();
		}
		return board;
	}

	public void hits(int bNo) throws SQLException {
		Connection conn =null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE board SET b_hits=b_hits+1 WHERE b_no=?";	
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bNo);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) pstmt.close();
			if (conn !=null) conn.close();
		}
	}

	public int insert(Board board) throws SQLException {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO board VALUES( " 
				+ "b_no.nextval, ?, ?, ?, "
				+ "0, 0, sysdate, 0)";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board.getmNo());
			pstmt.setString(2, board.getTitle());
			pstmt.setString(3, board.getContent()); 
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		return result;
	}

	public int update(Board board) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "UPDATE board SET b_title=?, b_content=? "
					+ "WHERE b_no=?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setInt(3, board.getbNo());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) pstmt.close();
			if (conn !=null) conn.close();
		}
		return result;
	}

	public int delete(int bNo) throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		String sql ="DELETE FROM board WHERE b_no=" + bNo;
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

	public void increaseLikes(int bNo) throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		String sql ="Update board SET like_cnt = like_cnt+1 WHERE b_no="+bNo;
		
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

	public void decreaseLikes(int bNo) throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		String sql = "Update board SET like_cnt = like_cnt-1 WHERE b_no="+bNo;
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) conn.close();
			if (stmt != null) stmt.close();
		}
	}	
}

