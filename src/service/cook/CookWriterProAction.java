package service.cook;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.cook.Cook;
import dao.cook.CookDao;


public class CookWriterProAction implements service.CommandProcess{
		
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			request.setCharacterEncoding("UTF-8");
			String pageNum = request.getParameter("pageNum");			
			Cook cook = new Cook();
			cook.setM_no(2);
			cook.setC_name(request.getParameter("c_name"));
			cook.setC_category(request.getParameter("cate"));
			cook.setC_img("img");
			cook.setC_hits("0");
			cook.setC_po(request.getParameter("c_po"));
			
			System.out.println(request.getParameter("c_name"));
			System.out.println(request.getParameter("cate"));
			System.out.println(request.getParameter("c_po"));

			
			CookDao dbPro = CookDao.getInstance();
			int result = dbPro.insert(cook);
			request.setAttribute("c_no", cook.getC_no());
			request.setAttribute("result",result);
			request.setAttribute("pageNum", pageNum);
			
		}catch(Exception e) {System.out.println(e.getMessage()); }
		return "cook/cookWriterPro.jsp";
	}
}
