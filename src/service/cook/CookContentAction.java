package service.cook;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.cook.Cook;
import dao.cook.CookDao;
import service.CommandProcess;

public class CookContentAction implements CommandProcess {
	
	@Override
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			//파라미터로 넘어온 글번호를 가저옴
			int c_no = Integer.parseInt(request.getParameter("c_no"));
			String pageNum = request.getParameter("pageNum");
			
			CookDao cd = CookDao.getInstance();
			cd.c_hits(c_no);
			Cook cook = cd.getCon(c_no);

			request.setAttribute("c_no", c_no);
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("cook", cook);
		} catch(Exception e) {
			System.out.println(e.getMessage()); 
		}
		return "cook/cookContent.jsp";
	}
}