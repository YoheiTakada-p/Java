package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UserDataBeans;
import beans.UserLikeBeans;
import beans.UserPostBeans;
import dao.PostDAO;
import dao.UserDAO;

/**
 * Servlet implementation class userprofServlet
 */
public class userprofServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public userprofServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		int a = (int) session.getAttribute("userId");
		System.out.println(a);

		//ユーザー情報検索
		UserDataBeans udb = new UserDataBeans();
		try {
			udb = UserDAO.getUserDataBeansByUserId2(a);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		//いいねの数を検索
		UserLikeBeans ulb = new UserLikeBeans();
		try {
			ulb = UserDAO.getUserLikeBeansBylike(a);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		//投稿情報を取得
		List<UserPostBeans> userList = PostDAO.findUserPost(a);
		//リクエストスコープにセット
		request.setAttribute("udb", udb);
		request.setAttribute("ulb", ulb);
		request.setAttribute("userList", userList);
		//セッションスコープにidをセット
		session.setAttribute("profId", udb.getId());
		//ユーザー情報画面にリダイレクト
		request.getRequestDispatcher(Helper.USERPROF_PAGE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
