package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import base.DBManager;
import beans.UserTitleBeans;

public class TitleDAO {
	/**
	 * タイトルを削除
	 *
	 * @param user
	 *            対応したデータを保持しているJavaBeans
	 * @throws SQLException
	 *             呼び出し元にcatchさせるためにスロー
	 */
	public static void deleteTitle(int title_id) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();
			st = con.prepareStatement("Delete from t_title where id = ?");
			st.setInt(1, title_id);
			st.executeUpdate();
			System.out.println("delete post has been completed");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	/**
	 * 全タイトルを取得する
	 *
	 * @throws SQLException
	 *             呼び出し元にcatchさせるためスロー
	 */
	public static List<UserTitleBeans> getUserPostTitleAll() throws SQLException{
		List<UserTitleBeans> titleList = new ArrayList<UserTitleBeans>();
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();
			st = con.prepareStatement("SELECT * FROM t_title");
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				System.out.println(title);
				UserTitleBeans utb = new UserTitleBeans(id,title);

				titleList.add(utb);

			}

			st.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}

		System.out.println("searching title comp");
		return titleList;
	}

	/**
	 * タイトルIDからタイトルを取得する
	 *
	 * @throws SQLException
	 *             呼び出し元にcatchさせるためスロー
	 */
	public static List<UserTitleBeans> getUserPostTitle2(int title_id) throws SQLException {
		List<UserTitleBeans> titleList = new ArrayList<UserTitleBeans>();
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();
			st = con.prepareStatement("SELECT * FROM t_title WHERE id = ?");
			st.setInt(1, title_id);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				UserTitleBeans utb = new UserTitleBeans(id,title);

				titleList.add(utb);

			}

			st.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}

		System.out.println("searching title comp");
		return titleList;
	}

	/**
	 * ランダムにタイトルを取得する
	 *
	 * @throws SQLException
	 *             呼び出し元にcatchさせるためスロー
	 */
	public static int getUserPostTitleRandom() throws SQLException {
		int a = 0;
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();
			st = con.prepareStatement("SELECT id FROM t_title ORDER BY RAND() LIMIT 1");
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				a = rs.getInt("id");
			}
			System.out.println(a);

			st.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}

		System.out.println("searching title comp");
		return a;

	}

	/**
	 * タイトルを取得する
	 *
	 * @throws SQLException
	 *             呼び出し元にcatchさせるためスロー
	 */
	public static List<UserTitleBeans> getUserPostTitle() throws SQLException {
		List<UserTitleBeans> titleList = new ArrayList<UserTitleBeans>();
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();
			st = con.prepareStatement("SELECT * FROM t_title ORDER BY id DESC LIMIT 3");
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				UserTitleBeans utb = new UserTitleBeans(id,title);

				titleList.add(utb);

			}

			st.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}

		System.out.println("searching title comp");
		return titleList;
	}
}
