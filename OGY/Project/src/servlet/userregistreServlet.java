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
 * Servlet implementation class userregistreServlet
 */
public class userregistreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public userregistreServlet() {
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
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		try {

			String inputUserName = request.getParameter("user_name");
			String inputLoginId = request.getParameter("login_id");
			String inputPassword = request.getParameter("password");
			UserDataBeans udb = new UserDataBeans();
			udb.setName(inputUserName);
			udb.setLoginId(inputLoginId);
			udb.setPassword(inputPassword);

			// 登録が確定されたかどうか確認するための変数
			String confirmed = request.getParameter("confirm_button");

			switch (confirmed) {
			case "修　正":
				session.setAttribute("udb", udb);
				response.sendRedirect("userregistServlet");
				break;

			case "登　録":
				UserDAO.insertUser(udb);
				request.setAttribute("udb", udb);
				request.getRequestDispatcher(Helper.REGIST_RESULT_PAGE).forward(request, response);
				break;
			}

		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}
}
