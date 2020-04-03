package dao.store;

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

import org.apache.jasper.tagplugins.jstl.core.Out;

public class StoreDao {
	Connection conn = null;
	ResultSet rs = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	private static StoreDao instance;

	private StoreDao() {
	}

	public static StoreDao getInstance() {
		if (instance == null) {
			instance = new StoreDao();
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

	public List<Store> select(int startRow, int endRow) {
		List<Store> list = new ArrayList<Store>();
		String sql = "select * from (select row_number() over (order by s_no desc) rn, store.* "
									+ "from store order by rn) "
					+ "where rn between ? and ?";
		Store store = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				store = new Store();
				store.setS_no(rs.getInt("s_no"));
				store.setS_title(rs.getString("s_title"));
				store.setS_img(rs.getString("s_img"));
				store.setS_url(rs.getString("s_url"));
				store.setS_readcount(rs.getInt("s_readcount"));
				list.add(store);

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}

	public int getTotalCnt() throws Exception {
		int tot = 0;
		String sql = "select count(*) from store";
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next())
				tot = rs.getInt(1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		}
		return tot;
	}
	public void s_readcount(String s_no) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update store set s_readcount=s_readcount+1 where s_no=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, s_no);
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
	}

	public Store select(String s_no) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from store where s_no=?";
		Store store = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, s_no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				store = new Store();
				store.setS_no(rs.getInt("s_no"));
				store.setS_title(rs.getString("s_title"));
				store.setS_img(rs.getString("s_img"));
				store.setS_url(rs.getString("s_url"));
				store.setS_readcount(rs.getInt("s_readcount"));
				
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
		return store;
	}

	public int storeInsert(Store store) throws Exception {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "insert into store values(?,?,?)";
		
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, store.getS_title());
			pstmt.setString(2, store.getS_img());
			pstmt.setString(3, store.getS_url());
			result = pstmt.executeUpdate();
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			pstmt.close();
			con.close();
		}
		
		return result;
	}

	public List<Store> getImg() throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		Store store = null;
		String sql = "select * from store";
		List<Store> slist = new ArrayList<>();
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				store = new Store(); // 반복문으로 객체 반복생성 (대충 기억하기)
				store.setS_title(rs.getString(1));
				store.setS_img(rs.getString(2));
				store.setS_url(rs.getString(3));
			
				
				slist.add(store);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			rs.close();
			pstmt.close();
			con.close();
		}
	

		
		return slist;
	}
}
