package dao.store;

public class Store {
	private int s_no;
	private String s_title;
	private String s_img;
	private String s_url;
	private int s_readcount;

	public int getS_no() {
		return s_no;
	}

	public void setS_no(int s_no) {
		this.s_no = s_no;
	}

	public String getS_title() {
		return s_title;
	}

	public void setS_title(String s_title) {
		this.s_title = s_title;
	}

	public String getS_img() {
		return s_img;
	}

	public void setS_img(String s_img) {
		this.s_img = s_img;
	}

	public String getS_url() {
		return s_url;
	}

	public void setS_url(String s_url) {
		this.s_url = s_url;
	}

	public int getS_readcount() {
		return s_readcount;
	}

	public void setS_readcount(int s_readcount) {
		this.s_readcount = s_readcount;
	}
}
