package service.refrigerator;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.cook.Cook;
import dao.cook.CookDao;
import dao.recipe.Recipe;
import dao.recipe.RecipeDao;
import service.CommandProcess;

public class SearchAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("searchAction Start1..." );
		request.setCharacterEncoding("utf-8");
		
		CookDao cd = CookDao.getInstance(); 
		//IngredientDao idao = IngredientDao.getInstance();
		RecipeDao rd = RecipeDao.getInstance();
		System.out.println("searchAction Start2..." );
		
		String[] i_item = request.getParameterValues("i_item");
		System.out.println("searchAction Start3. i_item.length->" +i_item.length);
		//int count = i_item.length;
		List<String> list = Arrays.asList(i_item);
		System.out.println("searchAction Start4..." );
		System.out.println("searchAction list->" + list);
		
		
		request.setAttribute("checkedItem", list);
		//request.setAttribute("count", count);
		
		List<Recipe> rList = rd.select(i_item);
		System.out.println("searchAction rList -> " + rList);
		request.setAttribute("rList", rList);
		
		try {
			
			int totCnt = rd.getTotalCnt(rList);
			String pageNum = request.getParameter("pageNum");
			if (pageNum == null || pageNum.equals("")) {
				pageNum = "1";
			}
			System.out.println(pageNum);
			int currentPage = Integer.parseInt(pageNum);
			int pageSize = 12, blockSize = 5;
			int startRow = (currentPage - 1) * pageSize + 1;
			int endRow = startRow + pageSize - 1;
			int startNum = totCnt - startRow + 1;
			List<Cook> sList = rd.search(rList, startRow, endRow);
			int pageCnt = (int) Math.ceil((double) totCnt / pageSize);
			int startPage = (int) (currentPage - 1) / blockSize * blockSize + 1;
			int endPage = startPage + blockSize - 1;
			if (endPage > pageCnt)
				endPage = pageCnt;

			String i_itemStr = "";
			for(int i=0 ; i < i_item.length ; i++) {
				if (i == i_item.length -1  ) i_itemStr =  i_itemStr + i_item[i];
				else                         i_itemStr =  i_itemStr + i_item[i] + ',';
			}
			System.out.println("searchAction i_itemStr -> " + i_itemStr);
		
			
			request.setAttribute("i_itemStr", i_itemStr);
			request.setAttribute("sList", sList);
			request.setAttribute("totCnt", totCnt);
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("startNum", startNum);
			request.setAttribute("blockSize", blockSize);
			request.setAttribute("pageCnt", pageCnt);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			
			System.out.println("searchAction ->"  + sList);
		}catch(Exception e) {
			e.printStackTrace();
		} 
		
		return "refrigerator/search.jsp";
	}

}
