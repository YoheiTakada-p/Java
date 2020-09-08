package beans;
import java.io.Serializable;


public class UserDataBeans implements Serializable {
	private String name;
	private String loginId;
	private String password;
	private int id;
	private String comment;
	private String create_date;

	// コンストラクタ
	public UserDataBeans() {
		this.name = "";
		this.loginId = "";
		this.password = "";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * ユーザー情報更新時の必要情報をまとめてセットするための処理
	 *
	 * @param name
	 * @param loginId
	 */
	public void setUpdateUserDataBeansInfo(String name, String loginId, String address, int id) {
		this.name = name;
		this.loginId = loginId;
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String commnet) {
		this.comment = commnet;
	}
	/**
	 * ユーザー情報(ネームとコメントのみ)の必要情報をまとめてセットするための処理
	 *
	 * @param name
	 * @param comment
	 */
	public void setUserDataBeansInfo(String name, String comment) {
		this.name = name;
		this.comment = comment;
	}
	/**
	 * ユーザー情報(全部)の必要情報をまとめてセットするための処理
	 *
	 * @param name
	 * @param comment
	 */
	public UserDataBeans(int id, String loginId, String name, String comment ,String create_date) {
		this.id = id;
		this.name = name;
		this.loginId = loginId;
		this.comment = comment;
		this.create_date = create_date;
	}

	public String getCreate_date() {
		return create_date;
	}

	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}

}