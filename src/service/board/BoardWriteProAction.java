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

public class BoardWriteProAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String pageNum = request.getParameter("pageNum");
		
		HttpSession session = request.getSession();
		LoginUser user = (LoginUser)session.getAttribute("user");
		int mNo = user.getM_no();
		
		Board board = new Board();
		board.setbNo(Integer.parseInt(request.getParameter("bNo")));
		board.setmNo(mNo);
		board.setTitle(request.getParameter("title"));
		board.setContent(request.getParameter("content"));
		
		try {
			BoardDao boardDao = BoardDao.getInstance();
			int result = boardDao.insert(board);
			if (result > 0) {
				return "redirect:boardList.do";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:boardWriteForm.do?pageNum=" + pageNum + "&error=true";
	}
}
