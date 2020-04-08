package service.cook;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.cook.CookDao;
import dao.ingredient.Ingredient;
import dao.ingredient.IngredientDao;
import dao.recipe.Recipe;
import dao.recipe.RecipeDao;
import service.CommandProcess;

public class CookWriterAction implements CommandProcess {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServerException, IOException {
		try {
			String pageNum = request.getParameter("pageNum");
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
			
			List<Ingredient> listCondiment = idao.listC();
			request.setAttribute("listCondiment", listCondiment);
			
		}catch(Exception e) {System.out.println(e.getMessage());}
		return "cook/cookWriter.jsp";
	
	}
}