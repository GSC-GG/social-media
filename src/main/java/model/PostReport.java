package model;

import java.sql.Timestamp;

public class PostReport extends Report {
	private Post post;

	public PostReport(int id, String content, User reporter, User moderator, String status, String result, Timestamp creation_date,
			Timestamp atualization_date, Post post) {
		super(id, content, reporter, moderator, status, result, creation_date, atualization_date);
		this.post = post;
	}

	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
}
