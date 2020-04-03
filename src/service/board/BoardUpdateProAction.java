package service.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.board.Board;
import dao.board.BoardDao;
import service.CommandProcess;

public class BoardUpdateProAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("BoardWriteProAction start..");
		
		try {
			request.setCharacterEncoding("utf-8");
			String pageNum = request.getParameter("pageNum");
			System.out.println(pageNum);
			request.getParameter("bNo");
			Board board = new Board();
			board.setbNo(Integer.parseInt(request.getParameter("bNo")));
			board.setTitle(request.getParameter("title"));
			board.setContent(request.getParameter("content"));
			
			BoardDao boardDao = BoardDao.getInstance();
			int result = boardDao.update(board);
			if ( result > 0) {
				return "redirect:boardList.do?pageNum=" + pageNum;
			}
			return "redirect:boardUpdate.do?pageNum=" + pageNum + "&error=true";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
