package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import base.DBManager;

public class LikeDAO {
	/**
	 * ユーザーのいいねの削除
	 */
	public static void DeleteUserLike(int id) {
		Connection conn = null;
		try {
            // データベースへ接続
            conn = DBManager.getConnection();

            String sql = "DELETE FROM t_like WHERE user_id=?";

		  // SELECTを実行し、結果表を取得
          PreparedStatement pStmt = conn.prepareStatement(sql);
          pStmt.setInt(1, id);
          int rs = pStmt.executeUpdate();

          if(rs == 1) {
        	  System.out.println("delete like");
          }else{
        	  System.out.println("delete like error");
          }


		 } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            // データベース切断
	            if (conn != null) {
	                try {
	                    conn.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
		}


	/**
	 * いいねを削除
	 *
	 * @param user
	 *            対応したデータを保持しているJavaBeans
	 * @throws SQLException
	 *             呼び出し元にcatchさせるためにスロー
	 */
	public static void deleteLike(int user_id, int post_id) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();
			st = con.prepareStatement("Delete from t_like where user_id = ? AND post_id = ?");
			st.setInt(1, user_id);
			st.setInt(2, post_id);
			st.executeUpdate();
			System.out.println("delete likes has been completed");
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
	 * いいねを新規登録
	 *
	 * @param user
	 *            対応したデータを保持しているJavaBeans
	 * @throws SQLException
	 *             呼び出し元にcatchさせるためにスロー
	 */
	public static void insertLike(int user_id, int post_id) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();
			st = con.prepareStatement("INSERT INTO t_like (user_id,post_id) VALUES (?,?)");
			st.setInt(1, user_id);
			st.setInt(2, post_id);
			st.executeUpdate();
			System.out.println("inserting likes has been completed");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

}
