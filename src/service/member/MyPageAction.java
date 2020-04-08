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
import dao.member.Member;
import dao.member.MemberDao;
import service.CommandProcess;

public class MyPageAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			LoginUser user = (LoginUser) session.getAttribute("user");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "member/myPage.jsp";
	}

}
