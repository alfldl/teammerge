package service.cook;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.cook.Cook;
import dao.cook.CookDao;
import dao.cook.CookImg;
import dao.cook.CookImgDao;
import dao.ingredient.Ingredient;
import dao.ingredient.IngredientDao;
import service.CommandProcess;

public class CookUpdateAction implements CommandProcess {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			//파라미터로 넘어온 글번호를 가저옴
			int c_no = Integer.parseInt(request.getParameter("c_no"));
			String pageNum = request.getParameter("pageNum");
			
			CookDao cd = CookDao.getInstance();
			CookImgDao cid = CookImgDao.getInstance();
			cd.c_hits(c_no);
			Cook cook = cd.select(c_no);
			List<CookImg> list = cid.select(c_no);
			int listSize = list.size(); 
			
			
			request.setAttribute("c_no", c_no);
			request.setAttribute("list", list);
			request.setAttribute("listSize", listSize);
			request.setAttribute("cook", cook);
			request.setAttribute("pageNum", pageNum);
			
			IngredientDao idao = IngredientDao.getInstance();

			List<Ingredient> listNoodle = idao.listN();
			request.setAttribute("listNoodle", listNoodle);

			List<Ingredient> listMeat = idao.listM();
			request.setAttribute("listMeat", listMeat);

			List<Ingredient> listSeafood = idao.listS();
			request.setAttribute("listSeafood", listSeafood);

			List<Ingredient> listVegitable = idao.listV();
			request.setAttribute("listVegitable", listVegitable);
			
		} catch(Exception e) {
			e.printStackTrace(); 
		}	
		
		return "cook/cookUpdate.jsp";
	}
}
