package service.cook;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.cook.Cook;
import dao.cook.CookDao;
import service.CommandProcess;


public class CookDeleteAction implements CommandProcess {
	@Override
	
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
			
			try {
			
			int c_no = Integer.parseInt(request.getParameter("c_no"));
			String pageNum = request.getParameter("pageNum");

			CookDao cd = CookDao.getInstance();
			int result = cd.delete(c_no);
			
			request.setAttribute("c_no", c_no);
			request.setAttribute("pagaNum", pageNum);
			request.setAttribute("cook", result);;
						
		}catch(Exception e){
			System.out.println(e.getMessage());			
		}
		return "cook.do";
		}
	
	
	}
	