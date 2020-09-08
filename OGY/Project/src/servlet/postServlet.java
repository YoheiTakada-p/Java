package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UserTitleBeans;
import dao.PostDAO;
import dao.TitleDAO;

/**
 * Servlet implementation class postServlet
 */
public class postServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public postServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//投稿情報を取得
		List<UserTitleBeans> titleList = null;
		try {
			titleList = TitleDAO.getUserPostTitle();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		//リクエストスコープにセット
		request.setAttribute("titleList",titleList);
		//投稿画面にリダイレクト
		request.getRequestDispatcher(Helper.POST_PAGE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/* 文字化け対策 */
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		int id = (int) session.getAttribute("userId");
		try {
			String inputTitle_id1 = request.getParameter("title");
			String inputPost = request.getParameter("post");
			String inputUser_title = request.getParameter("user_title");
			int inputTitle_id = Integer.parseInt(inputTitle_id1);

			System.out.println(id);
			System.out.println(inputTitle_id);
			System.out.println(inputPost);

			//ランダムを選択した場合
			if(inputTitle_id == 0) {
				inputTitle_id = TitleDAO.getUserPostTitleRandom();
				System.out.println("かっこ内：" + inputTitle_id);
				PostDAO.insertPost(inputPost, id, inputTitle_id);
			}else{
				PostDAO.insertPost(inputPost, id, inputTitle_id);
			}
			//タイトルの投稿
				System.out.println(inputUser_title);
			if(inputUser_title != "") {
				PostDAO.insertTitle(inputUser_title);
			}

			response.sendRedirect("mainServlet");

		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}
}
