package service.main;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.cook.CookDao;
import dao.main.Main;
import dao.main.MainDao;
import dao.store.Store;
import dao.store.StoreDao;
import service.CommandProcess;

public class HomeAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			MainDao md = MainDao.getInstance();
			CookDao cd = CookDao.getInstance();
			List<Main> list = md.select();
			List<Main> mbest = md.mbest();
			List<Main> sbest = md.sbest();
			int cookCount = cd.getTotalCnt();  // cook에 대한 전체 갯수
			double dValue = Math.random();
			int randomValue[] = new int[5];// 배열 생성
			/* 중복되지 않는 Random 수 생성2 */
			for (int i = 0; i < randomValue.length; i++) {
				randomValue[i] = (int) (Math.random() * cookCount) + 1;
				// 랜덤 값 반환
				for (int j = 0; j < i; j++) {
					if (randomValue[i] == randomValue[j]) {
						i--;
						break;
					}
				}
			}
			int randomValue1 = 0;
			int randomValue2 = 0;
			int randomValue3 = 0;
			int randomValue4 = 0;
			int randomValue5 = 0;
			for (int i = 0; i < randomValue.length; i++) {
				switch (i) {
				case 0: // 0 인 경우
					randomValue1 = randomValue[i];
					break;
				case 1: // 1 인 경우
					randomValue2 = randomValue[i];
					break;
				case 2:// 2 인 경우
					randomValue3 = randomValue[i];
					break;
				case 3: // 3 인 경우
					randomValue4 = randomValue[i];
					break;
				case 4:// 4 인 경우
					randomValue5 = randomValue[i];
					break;
				} // switch end

			} // for end
			request.setAttribute("list", list);
			request.setAttribute("mbest", mbest);
			request.setAttribute("sbest", sbest);
			request.setAttribute("randomValue1", randomValue1);
			request.setAttribute("randomValue2", randomValue2);
			request.setAttribute("randomValue3", randomValue3);
			request.setAttribute("randomValue4", randomValue4);
			request.setAttribute("randomValue5", randomValue5);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "main/home.jsp";
	}
}
