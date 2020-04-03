package service.main;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.store.Store;
import dao.store.StoreDao;
import service.CommandProcess;

public class St_Action implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		StoreDao sd = StoreDao.getInstance();
		 
		
		//1. 넣은 이미지 정보 받아오기.
		/*List<Store> slist1 = null;
		try {
			slist1 = sd.getImg();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		return "test3.jsp";
	}

}
