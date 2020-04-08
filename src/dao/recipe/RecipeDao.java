package dao.recipe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dao.cook.Cook;

public class RecipeDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	ResultSet rs = null;
	private static RecipeDao instance;

	private RecipeDao() {
	}

	public static RecipeDao getInstance() {
		if (instance == null) {
			instance = new RecipeDao();
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

	public List<Recipe> select(String[] i_item) {
		List<Recipe> rList = new ArrayList<Recipe>();
		String item = "";
		for (int i = 0; i < i_item.length; i++) {
			item += "'" + i_item[i] + "'";
			if (i < i_item.length - 1) {
				item += ",";
			}
		}
		String sql = "select distinct c_no from" + " (select c.c_no, c.c_name, c.c_category, "
				+ " c.c_img, c.c_hits, c.c_date," + " i.i_no, i.i_catego, i.i_item, i.i_img" + " from cook c"
				+ " left join recipe r on r.c_no = c.c_no" + " left join ingredient i on i.i_no = r.i_no"
				+ " where i.i_item in (" + item + "))";
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Recipe recipe = new Recipe();
				recipe.setC_no(rs.getInt(1));

				rList.add(recipe);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return rList;
	}

	public List<Cook> search(List<Recipe> rList, int startRow, int endRow) throws Exception {
		List<Cook> sList = new ArrayList<Cook>();

		String item = "";
		for (int i = 0; i < rList.size(); i++) {
			item += "'" + rList.get(i).getC_no() + "'";
			if (i < rList.size() - 1) {
				item += ",";
			}
		}
		String sql = "select * from (select row_number() " + " over (order by c_no desc) rn, cook.*, member.m_nickname "
				+ " from cook join member " + " on cook.m_no = member.m_no" + " where cook.c_no in (" + item + ") "
				+ " order by rn) " + " where rn between ? and ?";
		System.out.println("");
		Cook cook = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
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
				//cook.setC_po(rs.getString(8));
				cook.setC_date(rs.getDate(8));
				cook.setM_nickname(rs.getString(9));
				sList.add(cook);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rs.close();
			stmt.close();
			conn.close();
		}
		return sList;
	}
	
	public int getTotalCnt(List<Recipe> rList) throws Exception{
		String item = "";
		for (int i = 0; i < rList.size(); i++) {
			item += "'" + rList.get(i).getC_no() + "'";
			if (i < rList.size() - 1) {
				item += ",";
			}
		}
		int tot = 0;
		String sql = "select count(*) from cook where c_no in (" + item + ")";
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

}
