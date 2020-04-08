package service.cook;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.cook.Cook;
import dao.cook.CookDao;
import dao.cook.CookImg;
import dao.cook.CookImgDao;
import service.CommandProcess;

public class CookUpdateProAction implements CommandProcess {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CookDao cd = CookDao.getInstance();
		CookImgDao cid = CookImgDao.getInstance();
		try {
			request.setCharacterEncoding("UTF-8");

			ServletContext context = request.getSession().getServletContext();
			int maxSize = 5 * 1024 * 1024;
			String fileSave = "/fileSave";
			// String realPath = getServletContext.getRealPath(fileSave);
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

				if (filename != null) {
					file_name = "\\fileSave\\" + filename;
					fileList.add(file_name);
				}
			}
			int c_no = Integer.parseInt(multi.getParameter("c_no"));
			Cook cook = new Cook();
			cook.setC_no(c_no);
			cook.setC_name(multi.getParameter("c_name"));
			cook.setC_category(multi.getParameter("cate"));
			String pageNum = multi.getParameter("pageNum");

			List<String> poList = new ArrayList<String>();
			String[] pos = multi.getParameterValues("c_po");
			for (String po : pos) {
				System.out.println(po);
				poList.add(po);
			}

			int result1 = 0;
			int result2 = 0;
			int result3 = 0;
			int result4 = 0;

			// CookDao update
			if (fileList.isEmpty()) {
				result1 = cd.cookUpdate1(cook);
				request.setAttribute("result1", result1);
			} else {
				Collections.reverse(fileList);
				result2 = cd.cookUpdate2(cook, fileList);
				request.setAttribute("result2", result2);
			}

			// CookImgDao 삭제 -> 다시 인서트
			int deleteCid = cid.deleteCid(c_no);
			result3 = cid.insert2_5(c_no, fileList, poList);

			// 아이템 밸류들 가져옴
			String[] i_item = multi.getParameterValues("i_item");
			List<String> list1 = new ArrayList<>(Arrays.asList(i_item));

			// 아이템으로 번호 따옴
			List<String> list2 = new ArrayList<String>();
			for (int i = 0; i < list1.size(); i++) {
				String listitem = list1.get(i);
				list2.add(cid.getItem(listitem));
			}

			// 재료 삭제 -> 다시 인서트
			int deleteItem = cd.deleteItem(c_no);
			if (deleteItem > 0) {
				result4 = cd.insert3_5(list2, c_no);
			}

			request.setAttribute("result1", result1);
			request.setAttribute("result2", result2);
			request.setAttribute("result3", result3);
			request.setAttribute("result4", result4);
			request.setAttribute("cook", cook);
			request.setAttribute("pageNum", pageNum);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "cook/cookUpdatePro.jsp";
	}
}
