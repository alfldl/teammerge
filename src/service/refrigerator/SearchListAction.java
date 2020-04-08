package service.refrigerator;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.cook.Cook;
import dao.cook.CookDao;
import dao.recipe.Recipe;
import dao.recipe.RecipeDao;
import service.CommandProcess;

public class SearchListAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {
			System.out.println("SearchListAction3 Start1..." );
			request.setCharacterEncoding("utf-8");
			
			CookDao cd = CookDao.getInstance(); 
			//IngredientDao idao = IngredientDao.getInstance();
			RecipeDao rd = RecipeDao.getInstance();
			System.out.println("SearchListAction3 Start2..." );
			
			// String[] i_item = request.getParameterValues("i_item");
			String[] i_item = null;
			// searchlist3.jsp에서 호출
			String i_itemStr = request.getParameter("i_itemStr");
			System.out.println("SearchListAction3 i_itemStr->"+i_itemStr );
			
			if ( i_itemStr != null) {
			     i_item = i_itemStr.split(",");
			     System.out.println("SearchListAction3 i_item[0]->"+i_item[0] );
			}
			
			System.out.println("SearchListAction3 Start3. i_item.length->" +i_item.length);
			//int count = i_item.length;
			
			List<String> list = Arrays.asList(i_item);
			System.out.println("SearchListAction3 Start4..." );
			//System.out.println("searchAction list->" + list);
			
			
			request.setAttribute("checkedItem", list);
			
			List<Recipe> rList = rd.select(i_item);
			System.out.println("searchAction3  rList.size() -> " + rList.size());
			request.setAttribute("rList", rList);
			
			try {
				
				int totCnt = rd.getTotalCnt(rList);
				System.out.println("searchAction3 totCnt -> " +totCnt);
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
				System.out.println("searchAction3 sList.size() -> " +sList.size());
				int pageCnt = (int) Math.ceil((double) totCnt / pageSize);
				int startPage = (int) (currentPage - 1) / blockSize * blockSize + 1;
				int endPage = startPage + blockSize - 1;
				if (endPage > pageCnt)
					endPage = pageCnt;

//				String i_itemStr = "";
//				for(int i=0 ; i < rList.size() ; i++) {
//					if (i == rList.size() -1  ) {
//						i_itemStr += rList.get(i).getC_no();
//					} else {
//						i_itemStr += rList.get(i).getC_no() + ',';
//					}
//				}
//				System.out.println("searchAction i_itemStr -> " + i_itemStr);
			
				
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
			
			return "refrigerator/searchList.jsp";
	}

}
