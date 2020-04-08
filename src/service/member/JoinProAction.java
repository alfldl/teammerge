package service.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.member.Member;
import dao.member.MemberDao;
import service.CommandProcess;

public class JoinProAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();

			String m_id = request.getParameter("m_id");
			String m_pw = request.getParameter("m_pw");
			String m_name = request.getParameter("m_name");
			String m_nickName = request.getParameter("m_nickName");
			int m_phone = Integer.parseInt(request.getParameter("m_phone"));
			
			MemberDao md = MemberDao.getInstance();
			Member member = new Member();

			member.setM_id(m_id);
			member.setM_pw(m_pw);
			member.setM_name(m_name);
			member.setM_nickname(m_nickName);
			member.setM_phone(m_phone);
			
			int result = md.insert(member);
			
			if(result > 0) {
				out.println("<script>alert('success-! sign up');location.href='member/loginForm.jsp';</script>");
				//return "member/loginForm.jsp";
			} else {
				return "member/joinForm.jsp";
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

}
