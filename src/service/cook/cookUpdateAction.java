package service.cook;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.cook.Cook;
import service.CommandProcess;

public class cookUpdateAction implements CommandProcess {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cook cook = new Cook();
		cook.setC_no(Integer.parseInt(request.getParameter("c_no")));
		cook.setM_no(Integer.parseInt(request.getParameter("m_no")));
		cook.setC_name(request.getParameter("c_name"));
		cook.setC_category(request.getParameter("c_category"));
		cook.setC_img(request.getParameter("c_img"));
		cook.setC_hits(request.getParameter("c_hits"));
		cook.setC_po(request.getParameter("c_po"));
		String pageNum = request.getParameter("pageNum");
		
		request.setAttribute("cook", cook);
		request.setAttribute("pageNum", pageNum);
		
		return "cook/cookUpdate.jsp";
	}
}
