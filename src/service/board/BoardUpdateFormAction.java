package service.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.board.Board;
import dao.board.BoardDao;
import dao.member.LoginUser;
import service.CommandProcess;

public class BoardUpdateFormAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("BoardUpdateFormAction!!");
		int bNo = Integer.parseInt(request.getParameter("bNo"));
		String pageNum = request.getParameter("pageNum");
		
		try {
			BoardDao boardDao = BoardDao.getInstance();
			Board board = boardDao.select(bNo);
			
			HttpSession session = request.getSession();
			LoginUser user = (LoginUser) session.getAttribute("user");
			int mNo = user.getM_no();
			System.out.println("mNo-------->" + mNo);
			
			request.setAttribute("bNo", bNo);
			request.setAttribute("mNo", mNo);
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("board", board);
			
		} catch (Exception e) {
			e.printStackTrace();
		} return "board/boardUpdateForm.jsp";
	}
}