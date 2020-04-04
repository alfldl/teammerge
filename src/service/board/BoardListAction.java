package service.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.board.Board;
import dao.board.BoardDao;
import dao.member.LoginUser;
import service.CommandProcess;


public class BoardListAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		BoardDao boardDao = BoardDao.getInstance();
		String pageNum = request.getParameter("pageNum");
		String keyword = request.getParameter("keyword");
		
		if (keyword == null) keyword = "";
		
		try {
			int totalCnt  = boardDao.getTotalCnt(keyword);
			
			if (pageNum==null || pageNum.equals("")) {	
				pageNum = "1";	
			} 
			
			int currentPage = Integer.parseInt(pageNum); 
			int pageSize  = 10, blockSize = 5; 
			int startRow = (currentPage - 1) * pageSize + 1;  
			int endRow   = startRow + pageSize - 1;          
			int startNum = totalCnt - startRow + 1; 
			int pageCnt = (int)Math.ceil((double)totalCnt/pageSize);  
			int startPage = ((int) (currentPage-1)/blockSize)*blockSize + 1; 
			int endPage = startPage + blockSize -1;	   
			if (endPage > pageCnt) endPage = pageCnt;
			
			List<Board> list = boardDao.list(keyword, startRow, endRow);	
			
			HttpSession session = request.getSession();
			LoginUser user = (LoginUser)session.getAttribute("user");
			
			
			
			request.setAttribute("user", user);
			request.setAttribute("totalCnt", totalCnt);
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("startNum", startNum);
			request.setAttribute("list", list);
			request.setAttribute("blockSize", blockSize);
			request.setAttribute("pageCnt", pageCnt);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			request.setAttribute("keyword", keyword);
	 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "board/boardList.jsp";
	}
}
