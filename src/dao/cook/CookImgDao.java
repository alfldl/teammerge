package dao.cook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.mysql.fabric.xmlrpc.base.Array;

public class CookImgDao {
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	
	private static CookImgDao instance;

	private CookImgDao() {
	}

	public static CookImgDao getInstance() {
		if (instance == null) {
			instance = new CookImgDao();
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
			System.out.println(e.getMessage());
		}
		return conn;
	}
	
	public int insert2 (Cook cno, List<String> fileList, List<String> poList) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		String sql = "insert into cook_img values (?,?,?,?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			for(int i = 0; i < poList.size(); i++) {
				pstmt.setInt(1, cno.getC_no());
				pstmt.setString(2, poList.get(i));
				pstmt.setString(3, fileList.get(i));
				pstmt.setInt(4, i+1);
				result = pstmt.executeUpdate();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		return result;
	}

	public List<CookImg> select(int c_no) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from cook_img where c_no=? order by po_step";
		Cook cook = null;
		List<CookImg> list = new ArrayList<CookImg>();
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, c_no);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				CookImg ci = new CookImg();
				ci.setC_no(c_no);
				ci.setC_po(rs.getString(2));
				ci.setC_po_img(rs.getString(3));
				ci.setPo_step(rs.getInt(4));
				list.add(ci);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		return list;
	}

	public int deleteCid(int c_no) throws Exception {
		int result = 0;
		String sql = "delete cook_img where c_no=?";
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, c_no);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}
		return result;
	}

	public int insert2_5(int c_no, List<String> fileList, List<String> poList) throws Exception {
		int result = 0;
		String sql = "insert into cook_img values (?,?,?,?)";
		try {
			con = getConnection();
			for (int i = 0; i < poList.size(); i++) {
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, c_no);
				pstmt.setString(2, poList.get(i));
				pstmt.setString(3, fileList.get(i));
				pstmt.setInt(4, i + 1);
				result = pstmt.executeUpdate();
				System.out.println("나는 2.5의 cno = " + c_no);
				System.out.println("나는 2.5의 po = " + poList.get(i));
				System.out.println("나는 2.5의  = " + c_no);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (con != null) con.close();
		}
		return result;
	}

	public String getItem(String listitem) throws SQLException {
		String i_no = null;
		String sql = "select i_no from ingredient where i_item=?";
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, listitem);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				i_no = Integer.toString(rs.getInt(1));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (con != null) con.close();
		}
		return i_no;
	}

	public List<String> getImg(int c_no) throws Exception {
		List<String> imgs = new ArrayList<>();
		String sql = "select c_po_img from cook_img where c_no=? "
				+ "order by po_step";
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, c_no);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				imgs.add(rs.getString(1));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (con != null) con.close();
		}
		return imgs;
	}
}
