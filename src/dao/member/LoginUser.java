package dao.member;

public class LoginUser {
	private int m_no;
	private String m_id;
	private String m_pw;
	private String m_name;
	private String m_nickname;
	private int m_phone;
	//Dao만 추가 전달
	private String m_pw_new;
	private int result;
	private int c_no;
	private int s_no;
	
	public int getC_no() {
		return c_no;
	}
	public void setC_no(int c_no) {
		this.c_no = c_no;
	}
	public int getS_no() {
		return s_no;
	}
	public void setS_no(int s_no) {
		this.s_no = s_no;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public int getM_no() {
		return m_no;
	}
	public void setM_no(int m_no) {
		this.m_no = m_no;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getM_pw() {
		return m_pw;
	}
	public void setM_pw(String m_pw) {
		this.m_pw = m_pw;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getM_nickname() {
		return m_nickname;
	}
	public void setM_nickname(String m_nickname) {
		this.m_nickname = m_nickname;
	}
	public int getM_phone() {
		return m_phone;
	}
	public void setM_phone(int m_phone) {
		this.m_phone = m_phone;
	}
	public String getM_pw_new() {
		return m_pw_new;
	}
	public void setM_pw_new(String m_pw_new) {
		this.m_pw_new = m_pw_new;
	}
	
	
}
