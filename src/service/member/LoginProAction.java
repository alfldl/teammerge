package service.member;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.member.LoginUser;
import dao.member.Member;
import dao.member.MemberDao;
import service.CommandProcess;

public class LoginProAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		
		try {	
			request.setCharacterEncoding("utf-8");
			HttpSession session = request.getSession();
			String m_id = request.getParameter("m_id");
			String m_pw = request.getParameter("m_pw");
			MemberDao md = MemberDao.getInstance();
			//int result = md.select(m_id, m_pw);
			LoginUser user = md.Login(m_id, m_pw);
			if (user.getResult() == 1) {
				session.setAttribute("m_id", m_id);
				session.setAttribute("user", user);
				return "index.jsp";
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return "member/loginForm.jsp";
	}

}
