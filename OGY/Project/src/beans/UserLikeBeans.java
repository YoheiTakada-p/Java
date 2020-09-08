package beans;

import java.io.Serializable;

public class UserLikeBeans implements Serializable{
	private int like;

	public int getLike() {
		return like;
	}

	public void setLike(int like) {
		this.like = like;
	}
}
