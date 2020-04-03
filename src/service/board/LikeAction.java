package service.board;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.board.Board;
import dao.board.BoardDao;
import dao.board.LikeDao;
import dao.member.LoginUser;
import service.CommandProcess;

public class LikeAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("LikeAction start..");
		
		int bNo = Integer.parseInt(request.getParameter("bNo"));
		String  pageNum = request.getParameter("pageNum"); 
		HttpSession session = request.getSession();
		LoginUser user = (LoginUser) session.getAttribute("user");
		int mNo= user.getM_no();
		System.out.println("mNo----->" + mNo);
		
		try {
			LikeDao likeDao = LikeDao.getInstance();
			BoardDao boardDao = BoardDao.getInstance();
			
			int count = likeDao.count(bNo, mNo);
			
			if(count == 0) {
				boardDao.increaseLikes(bNo);
				likeDao.insertLike(mNo, bNo);
			} else {
				boardDao.decreaseLikes(bNo);
				likeDao.deleteLike(mNo, bNo);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return "redirect:boardContent.do?pageNum=" + pageNum + "&bNo=" + bNo;
	}

}
