<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <form action="cookWriterPro.do?pageNum=${pageNum }" method="post">
            <div>
                <p class="c_name">요리명
                <input type="text" name="c_name" required="required">
            </div>
   			<div>
   				<p>작성자: ${m_nickName }
   			</div>
           <div>
               <p>요리카테고리
               <select name="cate">
                   <option name="cate" value="한식">한식</option>
                   <option name="cate" value="일식">일식</option>
                   <option name="cate" value="중식">중식</option>
                   <option name="cate" value="퓨전">퓨전</option>
               </select>
           </div>
   
           <div>
               <p class="c_img">요리 이미지
               <button type="file" name="img">
                   사진 올리기
               </button>
           </div>
           
   
           <div>
               <p class="c_po">요리과정
               <textarea placeholder="요리과정을 넣어주세요" name="c_po" style="height: 160px; whight:430px;" resize:none;></textarea>
           </div>
   
           <div>
              <p class="c_date">
               등록일
           </div>

           <input type="submit" value="확인">
           <input type="reset" value="다시작성">   
   </form>

</body>
</html>