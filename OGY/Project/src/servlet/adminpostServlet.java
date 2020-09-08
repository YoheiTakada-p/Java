package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UserPostBeans;
import dao.PostDAO;

/**
 * Servlet implementation class adminpostServlet
 */
public class adminpostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminpostServlet() {
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
		//投稿情報を取得
		List<UserPostBeans> userList = PostDAO.findAll(a);
		//リクエストスコープにセット
		request.setAttribute("userList", userList);
		//管理者画面にリダイレクト
		request.getRequestDispatcher(Helper.ADMINPOST_PAGE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		int a = (int) session.getAttribute("userId");
		System.out.println(a);
		//parameter受け取り
		String serch = request.getParameter("serch");
		int serch_id = new Integer(serch).intValue();
		System.out.println(serch_id);
		//投稿検索機能
		if(serch_id == 1) {
			List<UserPostBeans> userList = PostDAO.findAllLatest(a);
			request.setAttribute("userList", userList);
		}
		if(serch_id == 2) {
			List<UserPostBeans> userList = PostDAO.findAllDENDO(a);
			request.setAttribute("userList", userList);
		}
		if(serch_id == 3) {
			List<UserPostBeans> userList = PostDAO.findAllFavorite(a);
			request.setAttribute("userList", userList);
		}
		//管理者画面にリダイレクト
		request.getRequestDispatcher(Helper.ADMINPOST_PAGE).forward(request, response);
	}

}
