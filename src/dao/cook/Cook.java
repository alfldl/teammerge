package dao.cook;

import java.util.Date;

public class Cook {
	private int c_no;
	private int m_no;
	private String c_name;
	private String c_category;
	private String c_img;
	private String c_hits;
	private String c_po;
	private Date c_date;
	private String m_nickname;

	
	public String getM_nickname() {
		return m_nickname;
	}
	public void setM_nickname(String m_nickname) {
		this.m_nickname = m_nickname;
	}
	public int getC_no() {
		return c_no;
	}
	public void setC_no(int c_no) {
		this.c_no = c_no;
	}
	public int getM_no() {
		return m_no;
	}
	public void setM_no(int m_no) {
		this.m_no = m_no;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getC_category() {
		return c_category;
	}
	public void setC_category(String c_category) {
		this.c_category = c_category;
	}
	public String getC_img() {
		return c_img;
	}
	public void setC_img(String c_img) {
		this.c_img = c_img;
	}
	public String getC_hits() {
		return c_hits;
	}
	public void setC_hits(String c_hits) {
		this.c_hits = c_hits;
	}
	public String getC_po() {
		return c_po;
	}
	public void setC_po(String c_po) {
		this.c_po = c_po;
	}
	public Date getC_date() {
		return c_date;
	}
	public void setC_date(Date c_date) {
		this.c_date = c_date;
	}
	
	
}
