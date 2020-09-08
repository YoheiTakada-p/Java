package servlet;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpSession;

/**
 * 定数保持、処理及び表示簡略化ヘルパークラス
 *
 * @author d-yamaguchi
 *
 */
public class Helper {
	// 検索結果
	static final String SEARCH_RESULT_PAGE = "/WEB-INF/jsp/itemsearchresult.jsp";
	// 商品ページ
	static final String ITEM_PAGE = "/WEB-INF/jsp/item.jsp";
	// TOPページ
	static final String TOP_PAGE = "/WEB-INF/jsp/index.jsp";
	// エラーページ
	static final String ERROR_PAGE = "/WEB-INF/jsp/error.jsp";
	// 買い物かごページ
	static final String CART_PAGE = "/WEB-INF/jsp/cart.jsp";
	// 購入
	static final String BUY_PAGE = "/WEB-INF/jsp/buy.jsp";
	//使用中 ユーザーパスワード更新画面
	static final String USERUPDATEPASSWORD_PAGE = "/WEB-INF/jsp/userupdatepassword.jsp";
	//使用中 ユーザーコメント更新画面
	static final String USERUPDATECOMMENT_PAGE = "/WEB-INF/jsp/userupdatecomment.jsp";
	//使用中 ユーザー名前更新画面
	static final String USERUPDATENAME_PAGE = "/WEB-INF/jsp/userupdatename.jsp";
	//ユーザー更新画面
	static final String USERUPDATE_PAGE = "/WEB-INF/jsp/userupdate.jsp";
	//使用中 ユーザー削除2画面
	static final String ADMINUSERDELETE_PAGE = "/WEB-INF/jsp/adminuserdelete.jsp";
	//使用中 ユーザー削除画面
	static final String USERDELETE_PAGE = "/WEB-INF/jsp/userdelete.jsp";
	//使用中 ユーザー情報2画面
	static final String USERPROF2_PAGE = "/WEB-INF/jsp/userprof2.jsp";
	//使用中 ユーザー情報画面
	static final String USERPROF_PAGE = "/WEB-INF/jsp/userprof.jsp";
	//使用中 投稿画面
	static final String POST_PAGE = "/WEB-INF/jsp/post.jsp";
	//使用中 管理者パスワード変更画面
	static final String ADMINUPDATEPASSWORD_PAGE = "/WEB-INF/jsp/adminupdatepassword.jsp";
	//使用中 管理者コメント変更画面
	static final String ADMINUPDATECOMMENT_PAGE = "/WEB-INF/jsp/adminupdatecomment.jsp";
	//使用中 管理者名前変更画面
	static final String ADMINUPDATENAME_PAGE = "/WEB-INF/jsp/adminupdatename.jsp";
	//使用中 管理者投稿画面
	static final String ADMINPOST_PAGE = "/WEB-INF/jsp/adminpost.jsp";
	//使用中 管理者ユーザ一覧画面
	static final String ADMINUSER_PAGE = "/WEB-INF/jsp/adminuser.jsp";
	//使用中 管理者タイトル画面
	static final String ADMINTITLE_PAGE = "/WEB-INF/jsp/admintitle.jsp";
	//使用中 管理者ユーザー情報画面
	static final String ADMINPROF_PAGE = "/WEB-INF/jsp/adminprof.jsp";
	//使用中 メイン画面
	static final String MAIN_PAGE = "/WEB-INF/jsp/main.jsp";
	//使用中 ログイン
	static final String LOGIN_PAGE = "/WEB-INF/jsp/login.jsp";
	// ログアウト
	static final String LOGOUT_PAGE = "/WEB-INF/jsp/logout.jsp";
	//使用中 新規登録
	static final String REGIST_PAGE = "/WEB-INF/jsp/userregist.jsp";
	//使用中 新規登録入力内容確認
	static final String REGIST_CONFIRM_PAGE = "/WEB-INF/jsp/userregistcon.jsp";
	//使用中 新規登録完了
	static final String REGIST_RESULT_PAGE = "/WEB-INF/jsp/userregistre.jsp";

	public static Helper getInstance() {
		return new Helper();
	}
	/**
	 * simpledateformat
	 */

	public static String date(Timestamp ts) {
		SimpleDateFormat sdf = new SimpleDateFormat("y年M月d日HH時mm分");
		String a = sdf.format(ts);
		return a;

	}
	/**
	 * ハッシュ関数
	 *
	 * @param target
	 * @return
	 */
	public static String getSha256(String target) {
		MessageDigest md = null;
		StringBuffer buf = new StringBuffer();
		try {
			md = MessageDigest.getInstance("SHA-256");
			md.update(target.getBytes());
			byte[] digest = md.digest();

			for (int i = 0; i < digest.length; i++) {
				buf.append(String.format("%02x", digest[i]));
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return buf.toString();
	}

	/**
	 * セッションから指定データを取得（削除も一緒に行う）
	 *
	 * @param session
	 * @param str
	 * @return
	 */
	public static Object cutSessionAttribute(HttpSession session, String str) {
		Object test = session.getAttribute(str);
		session.removeAttribute(str);

		return test;
	}

	/**
	 * ログインIDのバリデーション
	 *
	 * @param inputLoginId
	 * @return
	 */
	public static boolean isLoginIdValidation(String inputLoginId) {
		// 英数字アンダースコア以外が入力されていたら
		if (inputLoginId.matches("[0-9a-zA-Z-_]+")) {
			return true;
		}

		return false;

	}


}
