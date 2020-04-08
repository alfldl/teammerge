package service.cook;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.cook.Cook;
import dao.cook.CookDao;
import dao.cook.CookImgDao;
import dao.ingredient.Ingredient;
import dao.ingredient.IngredientDao;
import dao.member.LoginUser;
import dao.recipe.Recipe;
import dao.recipe.RecipeDao;

public class CookWriterProAction implements service.CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			request.setCharacterEncoding("UTF-8");
			String pageNum = request.getParameter("pageNum");

			ServletContext context = request.getSession().getServletContext();
			int maxSize = 5 * 1024 * 1024;
			String fileSave = "/fileSave";
			String realPath = context.getRealPath(fileSave);
			String filename = null;

			MultipartRequest multi = new MultipartRequest(request, realPath, maxSize, "utf-8",
					new DefaultFileRenamePolicy());
			Enumeration en = multi.getFileNames();

			List<String> fileList = new ArrayList<>();
			String file_name = null;
			while (en.hasMoreElements()) {
				// input 태그의 속성이 file린 태그의 name 속성값: 파라미터름
				String filename1 = (String) en.nextElement();
				// 서버에 저장된 파일이름
				filename = multi.getFilesystemName(filename1);
				// 전송된 파일 속성이 file린 태그의 name 속성값을 이용해서 파일객체생성
				File file = multi.getFile(filename1);
				file_name = "\\fileSave\\" + filename;
				fileList.add(file_name);
			}
			Collections.reverse(fileList);
			List<String> poList = new ArrayList<String>();
			String[] pos = multi.getParameterValues("c_po");
			for (String po : pos) {
				poList.add(po);
			}

			CookDao cd = CookDao.getInstance();
			CookImgDao cid = CookImgDao.getInstance();

			Cook cook = new Cook();
			HttpSession session = request.getSession();
			LoginUser user = (LoginUser) session.getAttribute("user");
			int m_no = user.getM_no();
			cook.setM_no(m_no);
			cook.setC_name(multi.getParameter("c_name"));
			cook.setC_category(multi.getParameter("cate"));
			String c_name = multi.getParameter("c_name");
			int result = cd.insert(cook, fileList);
			Cook cno = cd.getCno(c_name);
			int result2 = cid.insert2(cno, fileList, poList);
			
			//우리꺼
			RecipeDao rd = RecipeDao.getInstance();
			IngredientDao id = IngredientDao.getInstance();
			String[] i_item = multi.getParameterValues("i_item");
			List<String> list = Arrays.asList(i_item);
			List<Ingredient> iNo = id.select(list);	
			int resultRecipe = cd.insertIngre(cno, iNo);
			
			request.setAttribute("fileList", fileList);
			request.setAttribute("result", result);
			request.setAttribute("poList", poList);
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("result2", result2);
			request.setAttribute("resultRecipe", resultRecipe);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "cook/cookWriterPro.jsp";
	}
}
