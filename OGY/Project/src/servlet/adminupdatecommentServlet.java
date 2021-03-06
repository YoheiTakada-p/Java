package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UserDataBeans;
import dao.UserDAO;

/**
 * Servlet implementation class adminupdatecommentServlet
 */
public class adminupdatecommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminupdatecommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();

		//入力内容に誤りがある、確認画面で戻るボタン押し下げでアクセスしてきたときはセッションから入力情報を取得
		UserDataBeans udb = session.getAttribute("udb") != null?(UserDataBeans) Helper.cutSessionAttribute(session, "udb"):new UserDataBeans();
		String validationMessage = (String) Helper.cutSessionAttribute(session, "validationMessage");

		request.setAttribute("udb", udb);
		request.setAttribute("validationMessage",validationMessage);
		request.getRequestDispatcher(Helper.ADMINUPDATECOMMENT_PAGE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/* 文字化け対策 */
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		int id = (int) session.getAttribute("adminId");
		try {
			String inputComment = request.getParameter("comment");

			UserDataBeans udb = new UserDataBeans();
			udb.setComment(inputComment);
			udb.setId(id);

			String validationMessage = "";

			// バリデーションエラーメッセージがないならユーザ情報画面へ
			if (validationMessage.length() == 0) {
				//ユーザ情報を更新してプロフィール画面に飛ばす
				UserDAO.updateUserComment(udb);
				response.sendRedirect("adminprofServlet");
			} else {
				session.setAttribute("udb", udb);
				session.setAttribute("validationMessage", validationMessage);
				response.sendRedirect("adminupdatecommentServlet");
			}

		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}

}
