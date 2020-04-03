package service.refrigerator;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ingredient.Ingredient;
import dao.ingredient.IngredientDao;
import service.CommandProcess;

public class RefrigeratorAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception{

		IngredientDao idao = IngredientDao.getInstance();

		List<Ingredient> listNoodle = idao.listN();
		request.setAttribute("listNoodle", listNoodle);

		List<Ingredient> listMeat = idao.listM();
		request.setAttribute("listMeat", listMeat);

		List<Ingredient> listSeafood = idao.listS();
		request.setAttribute("listSeafood", listSeafood);

		List<Ingredient> listVegitable = idao.listV();
		request.setAttribute("listVegitable", listVegitable);

		return "refrigerator/refrigerator.jsp";
	}

}
