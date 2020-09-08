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
 * Servlet implementation class adminupdatenameServlet
 */
public class adminupdatenameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminupdatenameServlet() {
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
		request.getRequestDispatcher(Helper.ADMINUPDATENAME_PAGE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/**
		* 入力内容を確認 バリデーションエラーがある場合更新画面に遷移
		*/
		/* 文字化け対策 */
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		int id = (int) session.getAttribute("adminId");
		try {
			String inputName = request.getParameter("name");

			UserDataBeans udb = new UserDataBeans();
			udb.setName(inputName);
			udb.setId(id);

			String validationMessage = "";

			// nameの重複をチェック
			if (UserDAO.isOverlapName(udb.getName(), 0)) {
				validationMessage += "ほかのユーザーが使用中の名前です";
			}

			// バリデーションエラーメッセージがないなら管理者ユーザ情報画面へ
			if (validationMessage.length() == 0) {
				//ユーザ情報を更新してプロフィール画面に飛ばす
				UserDAO.updateUserName(udb);
				response.sendRedirect("adminprofServlet");
			} else {
				session.setAttribute("udb", udb);
				session.setAttribute("validationMessage", validationMessage);
				response.sendRedirect("adminupdatenameServlet");
			}

		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}
}
