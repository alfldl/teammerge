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

import dao.ingredient.Ingredient;
import dao.recipe.Recipe;

public class CookDao {
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	private static CookDao instance;
	private CookDao() {
	}

	public static CookDao getInstance() {
		if (instance == null) {
			instance = new CookDao();
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

	public List<Cook> getCook(int startRow, int endRow) throws Exception {
		List<Cook> list = new ArrayList<>();
		String sql = "select * from (select row_number() over (order by c_no desc) rn, cook.*, member.m_nickname "
				+ "from cook join member " + "on cook.m_no = member.m_no " + "order by rn) "
				+ "where rn between ? and ? ";
		Cook cook = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				cook = new Cook();
				cook.setC_no(rs.getInt(2));
				cook.setM_no(rs.getInt(3));
				cook.setC_name(rs.getString(4));
				cook.setC_category(rs.getString(5));
				cook.setC_img(rs.getString(6));
				cook.setC_hits(rs.getString(7));
				cook.setC_date(rs.getDate(8));
				cook.setM_nickname(rs.getString(9));
				list.add(cook);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rs.close();
			pstmt.close();
			con.close();
		}
		return list;
	}

	public List<Cook> getCook2(int startRow, int endRow, String c_category) throws Exception {
		List<Cook> list = new ArrayList<>();
		String sql = "select * from (select row_number() over (order by c_no desc) rn, cook.*, member.m_nickname "
				+ "from cook join member " + "on cook.m_no = member.m_no " + "where c_category = ? " + "order by rn) "
				+ "where rn between ? and ? ";
		Cook cook = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, c_category);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			System.out.println(c_category);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				cook = new Cook();
				cook.setC_no(rs.getInt(2));
				cook.setM_no(rs.getInt(3));
				cook.setC_name(rs.getString(4));
				cook.setC_category(rs.getString(5));
				cook.setC_img(rs.getString(6));
				cook.setC_hits(rs.getString(7));
				cook.setC_date(rs.getDate(8));
				cook.setM_nickname(rs.getString(9));
				list.add(cook);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rs.close();
			pstmt.close();
			con.close();
		}
		return list;

	}

	public Cook select(int c_no) throws SQLException {
		String sql = "select * from cook where c_no=?";
		Cook cook = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, c_no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				cook = new Cook();
				cook.setC_no(rs.getInt("c_no"));
				cook.setM_no(rs.getInt("m_no"));
				cook.setC_name(rs.getString("c_name"));
				cook.setC_category(rs.getString("c_category"));
				cook.setC_img(rs.getString("c_img"));
				cook.setC_hits(rs.getString("c_hits"));
				cook.setC_date(rs.getDate("c_date"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (con != null)
				con.close();
		}
		return cook;
	}

	public int insert(Cook cook, List<String> fileList) throws SQLException {
		int result = 0;
		String file = fileList.get(fileList.size()-1);
		String sql = "insert into cook values(c_no.nextval,?,?,?,?,0,sysdate)";
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, cook.getM_no());
			pstmt.setString(2, cook.getC_name());
			pstmt.setString(3, cook.getC_category());
			pstmt.setString(4, file);
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

	public void c_hits(int c_no) throws SQLException {
		String sql = "update cook set c_hits=c_hits+1 where c_no=?";
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, c_no);
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}
	}

	public int getTotalCnt() throws Exception {
		int tot = 0;
		String sql = "select count(*) from cook";
		try {
			con = getConnection();
			stmt = con.createStatement();
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
			if (con != null)
				con.close();
		}
		return tot;
	}

	public int getTotalCnt2(String c_category) throws Exception {
		int tot = 0;
		String sql = "select count(*) from cook where c_category=?";
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, c_category);
			rs = pstmt.executeQuery();
			if (rs.next())
				tot = rs.getInt(1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (con != null)
				con.close();
		}
		return tot;
	}
	
	public int cookInsert(Cook cook) throws Exception {
		int result = 0;
		String sql = "insert into cook values(c_no.nextval,?,?,?,0,?,sysdate)";
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cook.getC_name());
			pstmt.setString(2, cook.getC_category());
			pstmt.setString(3, cook.getC_img());
			pstmt.setString(4, cook.getC_po());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			pstmt.close();
			con.close();
		}
		return result;
	}
	
	public List<Cook> getImg() throws Exception {
		Cook cook = null;
		String sql = "select * from cook order by c_hits";
		List<Cook> list = new ArrayList<>();
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				cook = new Cook(); // 반복문으로 객체 반복생성 (대충 기억하기)
				cook.setC_no(rs.getInt(1));
				cook.setM_no(rs.getInt(2));
				cook.setC_name(rs.getString(3));
				cook.setC_category(rs.getString(4));
				cook.setC_img(rs.getString(5));
				cook.setC_hits(rs.getString(6));
				cook.setC_po(rs.getString(7));
				cook.setC_date(rs.getDate(8));
				list.add(cook);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			rs.close();
			pstmt.close();
			con.close();
		}
		return list;
	}
	
	public Cook getCon(int c_no) throws Exception {
		String sql = "select cook.*, member.m_nickname "
				+ "from cook join member " + "on cook.m_no = member.m_no "
				+ "where c_no=? ";
		Cook cook = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, c_no);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				cook = new Cook();
				cook.setC_no(rs.getInt(1));
				cook.setM_no(rs.getInt(2));
				cook.setC_name(rs.getString(3));
				cook.setC_category(rs.getString(4));
				cook.setC_img(rs.getString(5));
				cook.setC_hits(rs.getString(6));
				cook.setC_date(rs.getDate(7));
				cook.setM_nickname(rs.getString(8));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (con != null) con.close();
		}
		return cook;
	}
	
	public int delete(int c_no) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result = 0; 
		String sql="delete from cook where c_no=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, c_no);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		return result;
	}
	
	public int cookUpdate(Cook cook) throws Exception {
		int result = 0;
		String sql = "update cook set c_name=?, c_category=?, c_po=? where c_no=?";
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cook.getC_name());
			pstmt.setString(2, cook.getC_category());
			pstmt.setInt(4, cook.getC_no());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (con != null) con.close();
		}
		return result;
	}
	
	public Cook getCno(String c_name) throws Exception {
		String sql = "select c_no from cook where c_name=?";
		Cook cook = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, c_name);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				cook = new Cook();
				cook.setC_no(rs.getInt("c_no"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (con != null) con.close();
		}
		return cook;
	}
	
	public int insertIngre(Cook c_no, List<Ingredient> iNo) throws SQLException {
		int result = 0;
		String sql = "insert into recipe(c_no, i_no) values(?, ?)";
		try {
			con = getConnection();
			for(int i=0; i<iNo.size(); i++) {
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, c_no.getC_no());
				pstmt.setInt(2, iNo.get(i).getI_no());
				result = pstmt.executeUpdate();
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if (rs !=null) rs.close();
			if (stmt != null) stmt.close();
			if (con !=null) con.close();
		}
		return result;
	}

	public List<Ingredient> getItems(int c_no) throws Exception {
		String sql = "select ingredient.* from ingredient join recipe on "
				+ "recipe.i_no = ingredient.i_no where c_no=?";
		List<Ingredient> list = new ArrayList<>();
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, c_no);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Ingredient ing = new Ingredient();
				ing.setI_no(rs.getInt(1));
				ing.setI_catego(rs.getString(2));
				ing.setI_item(rs.getString(3));
				ing.setI_img(rs.getString(4));
				list.add(ing);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (con != null) con.close();
		}
		return list;
	}

	public int cookUpdate1(Cook cook) throws SQLException {
		int result = 0;
		String sql = "update cook set c_name=?, c_category=? where c_no=?";
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cook.getC_name());
			pstmt.setString(2, cook.getC_category());
			pstmt.setInt(3, cook.getC_no());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (con != null) con.close();
		}
		return result;
	}

	public int cookUpdate2(Cook cook, List<String> fileList) throws Exception {
		int result = 0;
		String sql = "update cook set c_name=?, c_category=?, c_img=? where c_no=?";
		String file = fileList.get(fileList.size() - 1);
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cook.getC_name());
			pstmt.setString(2, cook.getC_category());
			pstmt.setString(3, file);
			pstmt.setInt(4, cook.getC_no());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (con != null) con.close();
		}
		return result;
	}

	public int deleteItem(int c_no) throws Exception {
		int result = 0;
		String sql = "delete recipe where c_no=?";
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, c_no);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (con != null) con.close();
		}
		return result;
	}

	public int insert3_5(List<String> list2, int c_no) throws Exception {
		int result = 0;
		String sql = "insert into recipe values (?,?)";
		try {
			con = getConnection();
			for (int i = 0; i < list2.size(); i++) {
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, c_no);
				pstmt.setInt(2, Integer.parseInt(list2.get(i)));
				result = pstmt.executeUpdate();
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
	
	//member/MyListAction.java
		public int WriteListCnt(int m_no) throws SQLException {
			int tot = 0;
			String sql = "select count(*) from cook where m_no = ?";
			try {
				con = getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, m_no);
				rs = pstmt.executeQuery();
				if(rs.next())	tot = rs.getInt(1);
			} catch(Exception e) {
				System.out.println(e.getMessage());
			} finally {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			}
			return tot;
		}

		//member/MyListAction.java
		public List<Cook> search(int startRow, int endRow, int m_no) {
			List<Cook> list = new ArrayList<>();
			String sql = "select * from" + 
					" (select rownum rn, cook.* from" + 
					" (select * from cook) cook)" + 
					" where rn between ? and ? and m_no = ?";
			try {
				con = getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);
				pstmt.setInt(3, m_no);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					Cook cook = new Cook();
					cook.setC_no(rs.getInt(2));
					cook.setM_no(rs.getInt(3));
					cook.setC_name(rs.getString(4));
					cook.setC_category(rs.getString(5));
					cook.setC_img(rs.getString(6));
					cook.setC_hits(rs.getString(7));
					cook.setC_date(rs.getDate(8));
					list.add(cook);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return list;
		}
}

