package service.cook;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CommandProcess;

public class CookWriterAction implements CommandProcess {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServerException, IOException {
		try {
			String pageNum = request.getParameter("pageNum");
			if (pageNum == null) pageNum = "1";
			request.setAttribute("pageNum", pageNum);
			
		}catch(Exception e) {System.out.println(e.getMessage());}
		return "cook/cookWriter.jsp";
	
	}
}