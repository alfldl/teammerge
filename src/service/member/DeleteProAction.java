package service.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.member.MemberDao;
import service.CommandProcess;

public class DeleteProAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			String m_id = (String) session.getAttribute("m_id");
			request.setAttribute("m_id", m_id);
			
			String m_pw = request.getParameter("m_pw");
			
			MemberDao md = MemberDao.getInstance();
			int result = md.delete(m_id, m_pw);
			if(result == 1) {
				session.invalidate();
				return "main/home.jsp";
			} 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "member/delete.jsp";
	}

}
