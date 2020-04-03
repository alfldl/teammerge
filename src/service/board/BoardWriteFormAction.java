package service.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.member.LoginUser;
import service.CommandProcess;

public class BoardWriteFormAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("BoardWriteAction start..");
		
		try {
			int bNo = 0; 
			String pageNum = request.getParameter("pageNum");
			if (pageNum == null) pageNum = "1";
			
			HttpSession session = request.getSession();
			LoginUser user = (LoginUser) session.getAttribute("user");
			int mNo = user.getM_no();
			
			System.out.println("mNo----->" + mNo);
			
			request.setAttribute("mNo", mNo);
			request.setAttribute("bNo", bNo);
			request.setAttribute("pageNum", pageNum);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "board/boardWriteForm.jsp";
	}
}
