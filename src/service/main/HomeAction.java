package service.main;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.main.Main;
import dao.main.MainDao;
import dao.store.Store;
import dao.store.StoreDao;
import service.CommandProcess;

public class HomeAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			/*String c_name = request.getParameter(c_name);
			String c_img = request.getParameter("c_img");*/
			MainDao md = MainDao.getInstance();
			List<Main> list = md.select();
			List<Main> mbest = md.mbest();
			List<Main> sbest = md.sbest();
			System.out.println("sbest list"+sbest);
			double dValue = Math.random();
		    int randomValue1 = (int)(dValue * list.size());
		    dValue = Math.random();
		    int randomValue2 = (int)(dValue * list.size());
		    dValue = Math.random();
		    int randomValue3 = (int)(dValue * list.size());
		    dValue = Math.random();
		    int randomValue4 = (int)(dValue * list.size());
		    dValue = Math.random();
		    int randomValue5 = (int)(dValue * list.size());
		   
		   
			System.out.println("HomeAction  list.size()->"+list.size());
			System.out.println("HomeAction  randomValue->"+randomValue1);
		    
			request.setAttribute("list", list);
			request.setAttribute("mbest", mbest);
			request.setAttribute("sbest", sbest);
			request.setAttribute("randomValue1", randomValue1);
			request.setAttribute("randomValue2", randomValue2);
			request.setAttribute("randomValue3", randomValue3);
			request.setAttribute("randomValue4", randomValue4);
			request.setAttribute("randomValue5", randomValue5);

			/*request.setAttribute("c_name", c_name);
			request.setAttribute("c_img", c_img);*/
			
		/*	StoreDao sd = StoreDao.getInstance();*/
			 
			 	
			
			 
		}catch(Exception e) {	
			System.out.println(e.getMessage());	
		}
		
		return "main/home.jsp";
	}

}
