package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import base.DBManager;
import beans.UserPostBeans;
import servlet.Helper;

public class PostDAO {

	/**
	 * ユーザー投稿の削除
	 */
	public static void DeletePost(int id) {
		Connection conn = null;
		try {
            // データベースへ接続
            conn = DBManager.getConnection();

            String sql = "DELETE FROM t_post WHERE user_id=?";

		  // SELECTを実行し、結果表を取得
          PreparedStatement pStmt = conn.prepareStatement(sql);
          pStmt.setInt(1, id);
          int rs = pStmt.executeUpdate();

          if(rs == 1) {
        	  System.out.println("delete post");
          }else{
        	  System.out.println("delete post error");
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
     * 自分がいいねした投稿のみ取得する
     * @return
     */
    public static List<UserPostBeans> findAllFavorite(int id) {
        Connection conn = null;
        List<UserPostBeans> userList = new ArrayList<UserPostBeans>();

        try {
            // データベースへ接続
            conn = DBManager.getConnection();
            PreparedStatement st = null;
            // SELECT文を準備
            st = conn.prepareStatement("SELECT t_post.id,t_post.user_id,title_id,title,sentence,name,t_post.create_date,C.post_id,COUNT(t_like.id) AS like_cnt FROM t_post LEFT JOIN t_user ON t_post.user_id = t_user.id LEFT JOIN t_title ON t_post.title_id = t_title.id LEFT JOIN t_like ON t_post.id = t_like.post_id LEFT JOIN (SELECT post_id FROM t_like WHERE t_like.user_id = ?) AS C ON t_post.id = C.post_id WHERE t_post.id = C.post_id GROUP BY t_post.id ORDER BY create_date DESC");
            st.setInt(1,id);
            // SELECTを実行し、結果表を取得
            ResultSet rs = st.executeQuery();

            // 結果表に格納されたレコードの内容を
            // Userインスタンスに設定し、ArrayListインスタンスに追加
            while (rs.next()) {
            	int id1 = rs.getInt("id");
            	int user_id = rs.getInt("user_id");
            	int title_id = rs.getInt("title_id");
                String title = rs.getString("title");
                String sentence = rs.getString("sentence");
                String name = rs.getString("name");
            	int post_id = rs.getInt("post_id");
                int like_cnt = rs.getInt("like_cnt");
                Timestamp ts = rs.getTimestamp("create_date");
                String create_date = Helper.date(ts);
                UserPostBeans user = new UserPostBeans(id1, user_id, title_id, title, sentence, name, create_date, post_id, like_cnt);

                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return userList;
    }

	/**
     * いいねの多い順で投稿を取得する
     * @return
     */
    public static List<UserPostBeans> findAllDENDO(int id) {
        Connection conn = null;
        List<UserPostBeans> userList = new ArrayList<UserPostBeans>();

        try {
            // データベースへ接続
            conn = DBManager.getConnection();
            PreparedStatement st = null;
            // SELECT文を準備
            st = conn.prepareStatement("SELECT t_post.id,t_post.user_id,title_id,title,sentence,name,t_post.create_date,C.post_id,COUNT(t_like.id) AS like_cnt FROM t_post LEFT JOIN t_user ON t_post.user_id = t_user.id LEFT JOIN t_title ON t_post.title_id = t_title.id LEFT JOIN t_like ON t_post.id = t_like.post_id LEFT JOIN (SELECT post_id FROM t_like WHERE t_like.user_id = ?) AS C ON t_post.id = C.post_id GROUP BY t_post.id ORDER BY like_cnt DESC, post_id DESC");
            st.setInt(1,id);
            // SELECTを実行し、結果表を取得
            ResultSet rs = st.executeQuery();

            // 結果表に格納されたレコードの内容を
            // Userインスタンスに設定し、ArrayListインスタンスに追加
            while (rs.next()) {
            	int id1 = rs.getInt("id");
            	int user_id = rs.getInt("user_id");
            	int title_id = rs.getInt("title_id");
                String title = rs.getString("title");
                String sentence = rs.getString("sentence");
                String name = rs.getString("name");
            	int post_id = rs.getInt("post_id");
                int like_cnt = rs.getInt("like_cnt");
                Timestamp ts = rs.getTimestamp("create_date");
                String create_date = Helper.date(ts);
                UserPostBeans user = new UserPostBeans(id1, user_id, title_id, title, sentence, name, create_date, post_id, like_cnt);

                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return userList;
    }

	/**
     * 新しい順で投稿を取得する
     * @return
     */
    public static List<UserPostBeans> findAllLatest(int id) {
        Connection conn = null;
        List<UserPostBeans> userList = new ArrayList<UserPostBeans>();

        try {
            // データベースへ接続
            conn = DBManager.getConnection();
            PreparedStatement st = null;
            // SELECT文を準備
            st = conn.prepareStatement("SELECT t_post.id,t_post.user_id,title_id,title,sentence,name,t_post.create_date,C.post_id,COUNT(t_like.id) AS like_cnt FROM t_post LEFT JOIN t_user ON t_post.user_id = t_user.id LEFT JOIN t_title ON t_post.title_id = t_title.id LEFT JOIN t_like ON t_post.id = t_like.post_id LEFT JOIN (SELECT post_id FROM t_like WHERE t_like.user_id = ?) AS C ON t_post.id = C.post_id GROUP BY t_post.id ORDER BY create_date DESC");
            st.setInt(1,id);
            // SELECTを実行し、結果表を取得
            ResultSet rs = st.executeQuery();

            // 結果表に格納されたレコードの内容を
            // Userインスタンスに設定し、ArrayListインスタンスに追加
            while (rs.next()) {
            	int id1 = rs.getInt("id");
            	int user_id = rs.getInt("user_id");
            	int title_id = rs.getInt("title_id");
                String title = rs.getString("title");
                String sentence = rs.getString("sentence");
                String name = rs.getString("name");
            	int post_id = rs.getInt("post_id");
                int like_cnt = rs.getInt("like_cnt");
                Timestamp ts = rs.getTimestamp("create_date");
                String create_date = Helper.date(ts);
                UserPostBeans user = new UserPostBeans(id1, user_id, title_id, title, sentence, name, create_date, post_id, like_cnt);

                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return userList;
    }

	/**
	 * 投稿を削除
	 *
	 * @param user
	 *            対応したデータを保持しているJavaBeans
	 * @throws SQLException
	 *             呼び出し元にcatchさせるためにスロー
	 */
	public static void deletePost(int post_id) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();
			st = con.prepareStatement("Delete from t_post where id = ?");
			st.setInt(1, post_id);
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
	 * タイトルの投稿。
	 *
	 * @param user
	 *            対応したデータを保持しているJavaBeans
	 * @throws SQLException
	 *             呼び出し元にcatchさせるためにスロー
	 */
	public static void insertTitle(String title) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();
			st = con.prepareStatement("insert into t_title (title) values(?);");
			st.setString(1, title);
			st.executeUpdate();
			System.out.println("inserting title has been completed");
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
	 * 投稿。現在時刻は挿入直前に生成
	 *
	 * @param user
	 *            対応したデータを保持しているJavaBeans
	 * @throws SQLException
	 *             呼び出し元にcatchさせるためにスロー
	 */
	public static void insertPost(String post, int user_id, int title_id) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();
			st = con.prepareStatement("INSERT INTO t_post (sentence,user_id,title_id,create_date) VALUES (?,?,?,?)");
			st.setString(1, post);
			st.setInt(2, user_id);
			st.setInt(3, title_id);
			st.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
			st.executeUpdate();
			System.out.println("inserting post has been completed");
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
     * 他人の投稿のみ取得する
     * @return
     */
    public static List<UserPostBeans> findOtherPost(int id,int id2) {
        Connection conn = null;
        List<UserPostBeans> userList = new ArrayList<UserPostBeans>();

        try {
            // データベースへ接続
            conn = DBManager.getConnection();
            PreparedStatement st = null;
            // SELECT文を準備
            st = conn.prepareStatement("SELECT t_post.id,t_post.user_id,title_id,title,sentence,name,t_post.create_date,C.post_id,COUNT(t_like.id) AS like_cnt FROM t_post LEFT JOIN t_user ON t_post.user_id = t_user.id LEFT JOIN t_title ON t_post.title_id = t_title.id LEFT JOIN t_like ON t_post.id = t_like.post_id LEFT JOIN (SELECT post_id FROM t_like WHERE t_like.user_id = ?) AS C ON t_post.id = C.post_id WHERE t_post.user_id = ? GROUP BY t_post.id ORDER BY create_date DESC");
            st.setInt(1,id2);
            st.setInt(2,id);
            // SELECTを実行し、結果表を取得
            ResultSet rs = st.executeQuery();

            // 結果表に格納されたレコードの内容を
            // Userインスタンスに設定し、ArrayListインスタンスに追加
            while (rs.next()) {
            	int id1 = rs.getInt("id");
            	int user_id = rs.getInt("user_id");
            	int title_id = rs.getInt("title_id");
                String title = rs.getString("title");
                String sentence = rs.getString("sentence");
                String name = rs.getString("name");
            	int post_id = rs.getInt("post_id");
                int like_cnt = rs.getInt("like_cnt");
                Timestamp ts = rs.getTimestamp("create_date");
                String create_date = Helper.date(ts);
                UserPostBeans user = new UserPostBeans(id1, user_id, title_id, title, sentence, name, create_date, post_id, like_cnt);

                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return userList;
    }

	 /**
     * 自分の投稿のみ取得する
     * @return
     */
    public static List<UserPostBeans> findUserPost(int id) {
        Connection conn = null;
        List<UserPostBeans> userList = new ArrayList<UserPostBeans>();

        try {
            // データベースへ接続
            conn = DBManager.getConnection();
            PreparedStatement st = null;
            // SELECT文を準備
            st = conn.prepareStatement("SELECT t_post.id,t_post.user_id,title_id,title,sentence,name,t_post.create_date,C.post_id,COUNT(t_like.id) AS like_cnt FROM t_post LEFT JOIN t_user ON t_post.user_id = t_user.id LEFT JOIN t_title ON t_post.title_id = t_title.id LEFT JOIN t_like ON t_post.id = t_like.post_id LEFT JOIN (SELECT post_id FROM t_like WHERE t_like.user_id = ?) AS C ON t_post.id = C.post_id WHERE t_post.user_id = ? GROUP BY t_post.id ORDER BY create_date DESC");
            st.setInt(1,id);
            st.setInt(2,id);
            // SELECTを実行し、結果表を取得
            ResultSet rs = st.executeQuery();

            // 結果表に格納されたレコードの内容を
            // Userインスタンスに設定し、ArrayListインスタンスに追加
            while (rs.next()) {
            	int id1 = rs.getInt("id");
            	int user_id = rs.getInt("user_id");
            	int title_id = rs.getInt("title_id");
                String title = rs.getString("title");
                String sentence = rs.getString("sentence");
                String name = rs.getString("name");
            	int post_id = rs.getInt("post_id");
                int like_cnt = rs.getInt("like_cnt");
                Timestamp ts = rs.getTimestamp("create_date");
                String create_date = Helper.date(ts);
                UserPostBeans user = new UserPostBeans(id1, user_id, title_id, title, sentence, name, create_date, post_id, like_cnt);

                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return userList;
    }

	 /**
     * 全ての投稿を取得する
     * @return
     */
    public static List<UserPostBeans> findAll(int id) {
        Connection conn = null;
        List<UserPostBeans> userList = new ArrayList<UserPostBeans>();

        try {
            // データベースへ接続
            conn = DBManager.getConnection();
            PreparedStatement st = null;
            // SELECT文を準備
            st = conn.prepareStatement("SELECT t_post.id,t_post.user_id,title_id,title,sentence,name,t_post.create_date,C.post_id,COUNT(t_like.id) AS like_cnt FROM t_post LEFT JOIN t_user ON t_post.user_id = t_user.id LEFT JOIN t_title ON t_post.title_id = t_title.id LEFT JOIN t_like ON t_post.id = t_like.post_id LEFT JOIN (SELECT post_id FROM t_like WHERE t_like.user_id = ?) AS C ON t_post.id = C.post_id GROUP BY t_post.id ORDER BY create_date DESC");
            st.setInt(1,id);
            // SELECTを実行し、結果表を取得
            ResultSet rs = st.executeQuery();

            // 結果表に格納されたレコードの内容を
            // Userインスタンスに設定し、ArrayListインスタンスに追加
            while (rs.next()) {
            	int id1 = rs.getInt("id");
            	int user_id = rs.getInt("user_id");
            	int title_id = rs.getInt("title_id");
                String title = rs.getString("title");
                String sentence = rs.getString("sentence");
                String name = rs.getString("name");
            	int post_id = rs.getInt("post_id");
                int like_cnt = rs.getInt("like_cnt");
                Timestamp ts = rs.getTimestamp("create_date");
                String create_date = Helper.date(ts);
                UserPostBeans user = new UserPostBeans(id1, user_id, title_id, title, sentence, name, create_date, post_id, like_cnt);

                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return userList;
    }
}
