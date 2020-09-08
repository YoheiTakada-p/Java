package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.UserDataBeans;
import dao.UserDAO;

/**
 * Servlet implementation class adminuserServlet
 */
public class adminuserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminuserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//投稿情報を取得
		List<UserDataBeans> userList = UserDAO.findAll();
		//リクエストスコープにセット
		System.out.println(userList.get(0).getLoginId());
		request.setAttribute("userList", userList);
		//管理者画面にリダイレクト
		request.getRequestDispatcher(Helper.ADMINUSER_PAGE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO  未実装：検索処理全般

        // リクエストパラメータの文字コードを指定
        request.setCharacterEncoding("UTF-8");

		// リクエストパラメータの入力項目を取得
		String loginId1 = request.getParameter("loginId");
		String name1 = request.getParameter("name");
		System.out.println(name1);

		//name1が空欄の場合nullを代入する
		if(name1.equals("")) {
			 name1= null;
		 }
		name1 = "%" + name1 + "%";

		// ユーザ一覧情報を取得
		List<UserDataBeans> userList = UserDAO.finduser(loginId1,name1);

		// リクエストスコープにユーザ一覧情報をセット
		request.setAttribute("userList", userList);

		//管理者画面にリダイレクト
		request.getRequestDispatcher(Helper.ADMINUSER_PAGE).forward(request, response);
	}

}
