package service.store;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.store.Store;
import dao.store.StoreDao;
import service.CommandProcess;

public class StoreContentAction2 implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {
		String s_url = null;
		try {
			String s_no = request.getParameter("s_no");
			s_url = request.getParameter("s_url");
			s_url = "redirect:"+s_url;
			String pageNum = request.getParameter("pageNum");
			System.out.println("StoreContentAction2 s_url -> "+s_url);
			
			StoreDao sd = StoreDao.getInstance();
			sd.s_readcount(s_no);
			Store store = sd.select(s_no);
			request.setAttribute("s_no", s_no);
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("store", store);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return s_url;
	}
}
