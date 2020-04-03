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

/*public class CookDeleteAction implements CommandProcess {
	@Override
	
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int c_no = Integer.parseInt(request.getParameter("c_no")); // 게시물번호를 파라미터값으로 가져옴
		String pageNum = request.getParameter("pageNum");
		CookDao cd = CookDao.getInstance(); // DB에 연결을 위한 인스턴스 생성
		// int result = cd.delete(c_no);
		boolean result = false; // 게시물 삭제 결과를 받을변수
		boolean usercheck = false;

		if (usercheck == false) {
			response.setContentType("text/html);charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('불일치');");
			out.println("history.back();");
			out.close();

			return null;
		}
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("cook2.do");
		
		return forward;
	}
}
*/

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
		return "cook/cookContent.jsp";
		}
	
	
	}
	