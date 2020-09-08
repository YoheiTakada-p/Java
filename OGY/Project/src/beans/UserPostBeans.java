package beans;

import java.io.Serializable;

public class UserPostBeans implements Serializable {
	private int id;
	private int user_id;
	private int title_id;
	private int post_id;
	private String title;
	private String sentence;
	private String name;
	private String create_date;
	private int like_cnt;

	public UserPostBeans(int id, int user_id, int title_id, String title, String sentence, String name, String create_date, int post_id, int like_cnt) {
		this.id = id;
		this.user_id = user_id;
		this.title_id = title_id;
		this.post_id = post_id;
		this.title = title;
		this.sentence = sentence;
		this.name = name;
		this.create_date = create_date;
		this.like_cnt = like_cnt;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSentence() {
		return sentence;
	}

	public void setSentence(String sentence) {
		this.sentence = sentence;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreate_date() {
		return create_date;
	}

	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}

	public int getLike_cnt() {
		return like_cnt;
	}

	public void setLike_cnt(int like_cnt) {
		this.like_cnt = like_cnt;
	}

	public int getTitle_id() {
		return title_id;
	}

	public void setTitle_id(int title_id) {
		this.title_id = title_id;
	}

	public int getPost_id() {
		return post_id;
	}

	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

}
