package service.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.board.Board;
import dao.board.BoardDao;
import dao.board.LikeDao;
import dao.board.Reply;
import dao.board.ReplyDao;
import dao.member.LoginUser;
import service.CommandProcess;

public class BoardContentAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			int bNo = Integer.parseInt(request.getParameter("bNo"));
			String pageNum = request.getParameter("pageNum");
			BoardDao boardDao = BoardDao.getInstance();
			boardDao.hits(bNo);
			Board board = boardDao.select(bNo);
			
			HttpSession session = request.getSession();
			LoginUser user = (LoginUser) session.getAttribute("user");
			
			if (user != null) {
				int mNo= user.getM_no();
				System.out.println("mNo----->" + mNo);
				request.setAttribute("mNo", mNo);
				
				LikeDao likeDao = LikeDao.getInstance();
				int isLike = likeDao.count(bNo, mNo);
				
				request.setAttribute("isLike", isLike);
			}
			
			ReplyDao replyDao = ReplyDao.getInstance();
			List<Reply> replyList = replyDao.select(bNo);
			
			request.setAttribute("replyList", replyList);
			request.setAttribute("bNo", bNo);
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("board", board);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "board/boardContent.jsp";
	}
}
