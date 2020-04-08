package service.cook;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.fabric.xmlrpc.base.Member;

import dao.cook.Cook;
import dao.cook.CookDao;
import dao.cook.CookImg;
import dao.cook.CookImgDao;
import dao.ingredient.Ingredient;
import dao.member.MemberDao;
import service.CommandProcess;

public class CookContentAction implements CommandProcess {
	
	@Override
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			//파라미터로 넘어온 글번호를 가저옴
			int c_no = Integer.parseInt(request.getParameter("c_no"));
			String pageNum = request.getParameter("pageNum");
			CookDao cd = CookDao.getInstance();
			CookImgDao cid = CookImgDao.getInstance();
			cd.c_hits(c_no);
			Cook cook = cd.select(c_no);
			List<CookImg> list = cid.select(c_no);
			List<Ingredient> itemList = cd.getItems(c_no);
			Member member = new Member();
			
			MemberDao md = MemberDao.getInstance();
			String m_nickname = md.getMname(cook);
			
			
			request.setAttribute("c_no", c_no);
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("cook", cook);
			request.setAttribute("list", list);
			request.setAttribute("itemList", itemList);
			request.setAttribute("m_nickname", m_nickname);
		} catch(Exception e) {
			e.printStackTrace(); 
		}
		return "cook/cookContent.jsp";
	}
}