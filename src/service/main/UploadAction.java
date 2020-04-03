package service.main;

import java.io.File;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.cook.Cook;
import dao.cook.CookDao;
import service.CommandProcess;

public class UploadAction implements CommandProcess {

	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//1.이미지 넣기 준비
		
		response.setCharacterEncoding("UTF-8");
		System.out.println("UploadAction Start... ");
		
		ServletContext context = request.getSession().getServletContext();
		int maxSize = 5 * 1024 * 1024;
		String fileSave = "/fileSave";
		String realPath = context.getRealPath(fileSave);
		
		String filename = null;
		
		System.out.println("realpath->"+realPath);
		
		MultipartRequest multi = new MultipartRequest(request, realPath, maxSize, "utf-8", new DefaultFileRenamePolicy());
		Enumeration en = multi.getFileNames();
		while(en.hasMoreElements()){
			
			//input 태그의 속성이 file란 태그의 name 속성값: 파라미터이름
			String filename1 = (String)en.nextElement();
			
			//서버에 저장된 파일이름
			filename = multi.getFilesystemName(filename1);
			
			//전송전 원래 파일이름
			String original = multi.getOriginalFileName(filename);
			
			//전송된 파일의 내용 타입
			String type = multi.getContentType(filename1);
			
			//전송된 파일 속성이 file린 태그의 name 속성값을 이용해서 파일객체생성
			File file = multi.getFile(filename1);
			System.out.println("real Path : " + realPath + "<br>");
			System.out.println("파라메터 이름: " + filename1  + "<br>");
			System.out.println("실제 파일이름: "+ original + "<br>");
			System.out.println("저장된 파일이름  : " + filename +  "<br>");
			System.out.println("파일타입 : " + type  + "<br>");	
		}
		String c_name = multi.getParameter("c_name");
		String c_category = multi.getParameter("c_category");
		String c_img =  fileSave + "/" +filename;
		
		String c_po = multi.getParameter("c_po");
		
		CookDao cd = CookDao.getInstance();
		
		System.out.println("c_name : " + c_name);
		System.out.println("c_category : " + c_category);
		System.out.println("c_img : " + c_img);
		System.out.println("c_po : " + c_po);
		Cook cook = new Cook();
		cook.setC_name(c_name);
		cook.setC_category(c_category);
		cook.setC_img(c_img);
		cook.setC_po(c_po);
	
		
		
		
		
		//받아온 파라메타값들을 저장
	
		int ck = cd.cookInsert(cook);
		
			System.out.println("ck : " + ck);
	
			
			
		
		
		
		return "test2.do";
}

}
