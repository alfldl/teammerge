package service.cook;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.cook.Cook;
import dao.cook.CookDao;
import service.CommandProcess;

public class cookUpdateProAction implements CommandProcess {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CookDao cd = CookDao.getInstance();
		try {
			Cook cook = new Cook();
			cook.setC_no(Integer.parseInt(request.getParameter("c_no")));
			cook.setC_name(request.getParameter("c_name"));
			cook.setC_category(request.getParameter("cate"));
			cook.setC_po(request.getParameter("c_po"));
			String pageNum = request.getParameter("pageNum");
			
			int result = cd.cookUpdate(cook);
			request.setAttribute("result", result);
			request.setAttribute("cook", cook);
			request.setAttribute("pageNum", pageNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "cook/cookUpdatePro.jsp";
	}
}
