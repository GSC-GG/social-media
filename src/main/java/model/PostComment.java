package model;

import java.sql.Timestamp;

public class PostComment extends Comment {
	private Post post;

	public PostComment(int id, String content, User user, boolean on, Timestamp creation_date, Post post) {
		super(id, content, user, on, creation_date);
		this.setPost(post);
	}

	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
}
