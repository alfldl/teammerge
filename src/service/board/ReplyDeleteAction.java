package service.board;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.board.ReplyDao;
import dao.member.LoginUser;
import service.CommandProcess;

public class ReplyDeleteAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int bNo = Integer.parseInt(request.getParameter("bNo"));
		int brNo = Integer.parseInt(request.getParameter("brNo"));
		String pageNum = request.getParameter("pageNum");
		HttpSession session = request.getSession();
		LoginUser user = (LoginUser)session.getAttribute("user");
		int mNo = user.getM_no();
		
		System.out.println("mNo------->" + mNo);
		
		ReplyDao replyDao = ReplyDao.getInstance();
		int result = 0;
		
		try {
			result = replyDao.delete(brNo);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		request.setAttribute("result", result);
		request.setAttribute("bNo", bNo);
		request.setAttribute("brNo", brNo);
		request.setAttribute("mNo", mNo);
		request.setAttribute("pageNum", pageNum);
		
		return "redirect:boardContent.do?pageNum="+ pageNum +"&bNo=" + bNo;
		 
	}
}
