package service.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.member.MemberDao;
import service.CommandProcess;

public class ConfirmIdAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String m_id = request.getParameter("m_id");
		MemberDao md = MemberDao.getInstance();
		int result = md.confirmId(m_id);
		
		request.setAttribute("result", result);
		
		if(result == 0) {
			System.out.println("사용 가능한 아이디 입니다.");
			request.setAttribute("m_id", m_id);
		} else {
			System.out.println("이미 존재하는 아이디 입니다.");
			request.setAttribute("m_id", m_id);
		}
		
		return "member/confirmId.jsp";
	}

}
