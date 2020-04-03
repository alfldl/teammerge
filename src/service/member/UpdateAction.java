package service.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.member.Member;
import dao.member.MemberDao;
import service.CommandProcess;

public class UpdateAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String m_id = (String) session.getAttribute("m_id");
		MemberDao md = MemberDao.getInstance();
		Member member = md.info(m_id);
		
		request.setAttribute("info", member);
		
		return "member/updateForm.jsp";
	}

}
