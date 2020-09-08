package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UserDataBeans;
import beans.UserLikeBeans;
import dao.LikeDAO;
import dao.PostDAO;
import dao.UserDAO;

/**
 * Servlet implementation class admindeleteuserServlet
 */
public class admindeleteuserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public admindeleteuserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user_id = request.getParameter("id");
		int a = new Integer(user_id).intValue();
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
		//リクエストスコープにセット
		request.setAttribute("udb", udb);
		request.setAttribute("ulb", ulb);
		//ユーザー情報削除画面にリダイレクト
		request.getRequestDispatcher(Helper.ADMINUSERDELETE_PAGE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		int id = (int) session.getAttribute("adminId");
		System.out.println("adminId:" + id);

		UserDAO userdao = new UserDAO();
		userdao.DeleteInfo(id);
		//ユーザに紐づく投稿といいねも削除　未実装
		//投稿削除
		try {
			PostDAO.deletePost(id);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		//いいね削除
		LikeDAO.DeleteUserLike(id);
		//セッションを切る
		session.removeAttribute("adminId");

		//管理画面にリダイレクト
		response.sendRedirect("adminuserServlet");
	}

}
