package dao.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDao {
	private static MemberDao instance;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	private MemberDao() {
	}

	public static MemberDao getInstance() {
		if (instance == null) {
			instance = new MemberDao();
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

	public int check(String m_id, String m_pw) {
		int result = 2;
		String sql = "select m_pw from member where m_id = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m_id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String dbPw = rs.getString(1);
				if (dbPw.equals(m_pw))
					result = 1;
				else
					result = 0;
			} else
				result = -1;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	public int insert(Member member) throws SQLException {
		int result = 0;
		String sql = "insert into member(m_no, m_id, m_pw, m_name, m_nickname, m_phone) values(m_no.nextval, ?, ?, ?, ?, ?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getM_id());
			pstmt.setString(2, member.getM_pw());
			pstmt.setString(3, member.getM_name());
			pstmt.setString(4, member.getM_nickname());
			pstmt.setInt(5, member.getM_phone());

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	public int select(String m_id, String m_pw) {
		int result = 0;
		String sql = "select * from member where m_id=?";
		String dbPw = "";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m_id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dbPw = rs.getString("m_pw");
				if (dbPw.equals(m_pw)) {
					result = 1;
				} else {
					result = 0;
				}
				LoginUser user = new LoginUser();
				
				user.setM_no(rs.getInt("m_no"));
				user.setM_id(rs.getString("m_id"));
				user.setM_pw(rs.getString("m_pw"));
				user.setM_name(rs.getString("m_name"));
				user.setM_nickname(rs.getString("m_nickname"));
				user.setM_phone(rs.getInt("m_phone"));
				
				System.out.println("Dao user -> "+user.getM_id());
			} else {
				result = -1;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	public Member info(String m_id) {
		
		Member member = new Member();
		String sql = "select * from member where m_id=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m_id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				member.setM_id(rs.getString("m_id"));
				member.setM_nickname(rs.getString("m_nickname"));
				member.setM_name(rs.getNString("m_name"));
				member.setM_phone(rs.getInt("m_phone"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return member;
	}

	public int update(Member member) {
		int result = 0;
		String sql = "update member set m_pw=?, m_name=?, m_phone=?, m_nickname=? where m_id = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getM_pw());
			pstmt.setString(2, member.getM_name());
			pstmt.setInt(3, member.getM_phone());
			pstmt.setString(4, member.getM_nickname());
			pstmt.setString(5, member.getM_id());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return result;
	}

	public int confirmId(String m_id) {
		int result = 2;
		String sql ="select m_id from member where m_id=?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m_id);
			
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = 1;
			} else {
				result = 0;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	public int delete(String m_id, String m_pw) {
		int result = 0;
		result = select(m_id, m_pw);
		if(result != 1) {
			return result;
		}
		String sql = "delete from member where m_id=?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m_id);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return result;
	}

	public LoginUser Login(String m_id, String m_pw) {
		LoginUser user = null;
		int result = 0;
		String sql = "select * from member where m_id=?";
		String dbPw = "";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m_id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dbPw = rs.getString("m_pw");
				if (dbPw.equals(m_pw)) {
					result = 1;
				} else {
					result = 0;
				}
				user = new LoginUser();
				
				user.setM_no(rs.getInt("m_no"));
				user.setM_id(rs.getString("m_id"));
				user.setM_pw(rs.getString("m_pw"));
				user.setM_name(rs.getString("m_name"));
				user.setM_nickname(rs.getString("m_nickname"));
				user.setM_phone(rs.getInt("m_phone"));
				user.setResult(result);
				
				System.out.println("Dao user -> "+user.getM_id());
			} else {
				result = -1;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return user;
	}

	public List<LoginUser> book(int m_no) {
		List<LoginUser> list = new ArrayList<>();
		String sql = "select bookmark.bm, bookmark.c_no, bookmark.s_no, bookmark.m_no" + 
				" from bookmark join member on bookmark.m_no = member.m_no" + 
				" where member.m_no = ? and bookmark.bm = 1";
		try {
			System.out.println("dao try in");
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, m_no);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println("dao while in");
				LoginUser user = new LoginUser();
				user.setC_no(rs.getInt("c_no"));
				user.setS_no(rs.getInt("s_no"));
				System.out.println("dao user c_no -> "+rs.getInt("c_no"));
				list.add(user);
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}

	public List<LoginUser> write(int m_no) {
		List<LoginUser> list = new ArrayList<>();
		String sql = "select cook.c_no" + 
				" from cook join member on cook.m_no = member.m_no" + 
				" where member.m_no = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, m_no);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				LoginUser user = new LoginUser();
				user.setC_no(rs.getInt("c_no"));
				list.add(user);
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}

}














