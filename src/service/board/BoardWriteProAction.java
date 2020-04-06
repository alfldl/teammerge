package service.board;

import java.io.IOException;
import java.io.PrintWriter;

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
		String type = request.getParameter("type");
		
		HttpSession session = request.getSession();
		LoginUser user = (LoginUser)session.getAttribute("user");
		if (user == null) {
			return "redirect:home.do?error=true";
		}
		int mNo = user.getM_no();
		
		Board board = new Board();
		board.setmNo(mNo);
		board.setTitle(request.getParameter("title"));
		board.setContent(request.getParameter("content"));
		board.setType(type);
		
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
