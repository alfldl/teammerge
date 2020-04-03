package service.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.net.httpserver.HttpServer;

import dao.board.Reply;
import dao.board.ReplyDao;
import dao.member.LoginUser;
import service.CommandProcess;

public class ReplyWriteAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("ReplyAction Start..");
		request.setCharacterEncoding("utf-8");
		String pageNum = request.getParameter("pageNum");
		int bNo = Integer.parseInt(request.getParameter("bNo"));
		String content = request.getParameter("content");
		HttpSession session = request.getSession();
		LoginUser user = (LoginUser) session.getAttribute("user");
		int mNo = user.getM_no();
		System.out.println("mNo------>" + mNo);
		
		try {
			ReplyDao replyDao = ReplyDao.getInstance();
			Reply reply = new Reply();
			reply.setbNo(bNo);
			reply.setmNo(mNo);
			reply.setContent(content);
			replyDao.insert(reply);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:boardContent.do?pageNum="+ pageNum + "&bNo=" + bNo;
	}

}
