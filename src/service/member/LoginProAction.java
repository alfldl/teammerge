package service.member;

import java.io.IOException;
import java.io.PrintWriter;
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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		try {
			HttpSession session = request.getSession();
			String m_id = request.getParameter("m_id");
			String m_pw = request.getParameter("m_pw");
			
			MemberDao md = MemberDao.getInstance();
			LoginUser user = md.login(m_id, m_pw);
			if(user.getResult() == 1) {
				request.setAttribute("result", 1);
				session.setAttribute("user", user);
			}else {
				request.setAttribute("result", 0);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "member/loginPro.jsp";
	}

}
