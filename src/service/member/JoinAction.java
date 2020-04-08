package service.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CommandProcess;

public class JoinAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
			 response.setCharacterEncoding("utf-8");
			 request.setCharacterEncoding("utf-8");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return "member/joinForm.jsp";
	}

}
