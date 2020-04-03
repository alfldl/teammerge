package service.refrigerator;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.cook.CookDao;
import dao.recipe.Recipe;
import dao.recipe.RecipeDao;
import service.CommandProcess;

public class SearchPageAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<String> list = (List<String>) request.getAttribute("rList");
		System.out.println("list -> "+list);
		List<String> checkedItem = (List<String>) request.getAttribute("checkedItem");
		System.out.println("checkedItem -> "+checkedItem);
		return "refrigerator/search.jsp";
	}

}

