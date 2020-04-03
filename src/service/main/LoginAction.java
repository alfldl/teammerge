package service.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.member.MemberDao;
import service.CommandProcess;

public class LoginAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String m_id = request.getParameter("m_id");
		String m_pw = request.getParameter("m_pw");
		MemberDao md = MemberDao.getInstance();
		try {

			int result = md.check(m_id, m_pw);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "home.do";
	}

}
