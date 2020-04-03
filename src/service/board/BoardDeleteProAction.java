package service.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.board.BoardDao;
import dao.board.LikeDao;
import dao.board.ReplyDao;
import service.CommandProcess;

public class BoardDeleteProAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int bNo = Integer.parseInt(request.getParameter("bNo"));
		int mNo = Integer.parseInt(request.getParameter("mNo"));
		String pageNum = request.getParameter("pageNum");
		int result = 0;
		try {
			
			BoardDao boardDao = BoardDao.getInstance();
			LikeDao likeDao = LikeDao.getInstance();
			ReplyDao replyDao = ReplyDao.getInstance();
			
			int hasLike = likeDao.countLike(bNo);
			int hasReply = replyDao.countReply(bNo);
			
			if (hasLike > 0) {
				result = likeDao.deleteAllLike(bNo);
			}
			
			if (hasReply > 0) {
				result = replyDao.deleteAllReply(bNo); 
			}
			
			result = boardDao.delete(bNo);
			
			request.setAttribute("result", result);
			request.setAttribute("pageNum", pageNum);
			
			if (result > 0) {
				return "redirect:boardList.do?pageNum=" + pageNum + "&delete=true";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:boardContent.do?pageNum=" + pageNum + "&bNo=" + bNo + "&delete=false";
	}
}
