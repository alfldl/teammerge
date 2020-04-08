package service.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.cook.Cook;
import dao.cook.CookDao;
import dao.member.LoginUser;
import dao.recipe.Recipe;
import dao.recipe.RecipeDao;
import service.CommandProcess;

public class MyListAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {
		try {
			HttpSession session = request.getSession();
			LoginUser user = (LoginUser) session.getAttribute("user");
			int m_no = user.getM_no();
			System.out.println("MyListAction m_no -> "+m_no);
		
			CookDao cd = CookDao.getInstance();
			int totCnt = cd.WriteListCnt(m_no);
			System.out.println("MyListAction totCnt -> "+totCnt);
			String pageNum = request.getParameter("pageNum");
			if (pageNum == null || pageNum.equals("")) {
				pageNum = "1";
			}
			int currentPage = Integer.parseInt(pageNum);
			int pageSize = 12, blockSize = 5;
			int startRow = (currentPage - 1) * pageSize + 1;
			System.out.println("MyListAction startRow  -> "+startRow );
			int endRow = startRow + pageSize - 1;
			int startNum = totCnt - startRow + 1;
			List<Cook> wList = cd.search(startRow, endRow, m_no);
			int pageCnt = (int) Math.ceil((double) totCnt / pageSize);
			int startPage = (int) (currentPage - 1) / blockSize * blockSize + 1;
			int endPage = startPage + blockSize - 1;
			if (endPage > pageCnt)
				endPage = pageCnt;

			request.setAttribute("wList", wList);
			request.setAttribute("totCnt", totCnt);
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("startNum", startNum);
			request.setAttribute("blockSize", blockSize);
			request.setAttribute("pageCnt", pageCnt);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} 
		return "member/myList.jsp";
	}
}
