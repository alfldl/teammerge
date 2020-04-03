package dao.ingredient;

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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.*;
import javax.naming.*;

public class IngredientDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	ResultSet rs = null;
	private static IngredientDao instance;
	private IngredientDao() {}
	public static IngredientDao getInstance() {
		if(instance == null) {
			instance = new IngredientDao();
		}
		return instance;
	}
	
	private Connection getConnection() {
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource)
				ctx.lookup("java:comp/env/jdbc/OracleDB");
			conn = ds.getConnection();
		} catch(Exception e) { System.out.println(e.getMessage());	}
		return conn;
	}
	
	public List<Ingredient> list() {
		Statement stmt = null;
		List<Ingredient> list = new ArrayList<>();
		String sql = "select i_no, i_img, i_item from ingredient";
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Ingredient ingre = new Ingredient();
				ingre.setI_no(rs.getInt(1));
				ingre.setI_img(rs.getString(2));
				ingre.setI_item(rs.getString(3));

				list.add(ingre);
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
	public List<Ingredient> listN() {
		List<Ingredient> list = new ArrayList<>();
		String sql = "select i_no, i_img, i_item from ingredient where i_catego = '면류'";
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Ingredient ingre = new Ingredient();
				ingre.setI_no(rs.getInt(1));
				ingre.setI_img(rs.getString(2));
				ingre.setI_item(rs.getString(3));

				list.add(ingre);
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
	public List<Ingredient> listM() {
		List<Ingredient> list = new ArrayList<>();
		String sql = "select i_no, i_img, i_item from ingredient where i_catego = '육류'";
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Ingredient ingre = new Ingredient();
				ingre.setI_no(rs.getInt(1));
				ingre.setI_img(rs.getString(2));
				ingre.setI_item(rs.getString(3));

				list.add(ingre);
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
	public List<Ingredient> listS() {
		List<Ingredient> list = new ArrayList<>();
		String sql = "select i_no, i_img, i_item from ingredient where i_catego = '해산물'";
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Ingredient ingre = new Ingredient();
				ingre.setI_no(rs.getInt(1));
				ingre.setI_img(rs.getString(2));
				ingre.setI_item(rs.getString(3));

				list.add(ingre);
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
	public List<Ingredient> listV() {
		List<Ingredient> list = new ArrayList<>();
		String sql = "select i_no, i_img, i_item from ingredient where i_catego = '채소류'";
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Ingredient ingre = new Ingredient();
				ingre.setI_no(rs.getInt(1));
				ingre.setI_img(rs.getString(2));
				ingre.setI_item(rs.getString(3));

				list.add(ingre);
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
	public List<Ingredient> listC() {
		List<Ingredient> list = new ArrayList<>();
		String sql = "select i_no, i_img, i_item from ingredient where i_catego = '조미료'";
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Ingredient ingre = new Ingredient();
				ingre.setI_no(rs.getInt(1));
				ingre.setI_img(rs.getString(2));
				ingre.setI_item(rs.getString(3));

				list.add(ingre);
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}

}




















