package model;

import java.sql.Timestamp;

public class AnswerComment extends Comment {
	private Comment comment;

	public AnswerComment(int id, String content, User user, boolean removed, Timestamp creation_date, Comment comment) {
		super(id, content, user, removed, creation_date);
		this.comment = comment;
	}

	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
	}
}
