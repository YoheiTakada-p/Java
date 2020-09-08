package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.UserTitleBeans;
import dao.TitleDAO;

/**
 * Servlet implementation class post2Servlet
 */
public class post2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public post2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String title_id = request.getParameter("title_id");
		int id = new Integer(title_id).intValue();
		System.out.println(id);

		//title_idからタイトルを検索
		List<UserTitleBeans> titleList = null;
		try {
			titleList = TitleDAO.getUserPostTitle2(id);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		//リクエストスコープにセット
		request.setAttribute("titleList",titleList);

		//投稿画面にリダイレクト
		request.getRequestDispatcher(Helper.POST_PAGE).forward(request, response);
	}

}
