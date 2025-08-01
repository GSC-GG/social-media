package model;

import java.sql.Timestamp;

public class CommentReport extends Report {
	private Comment comment;

	public CommentReport(int id, String content, User moderator, String status, Timestamp creation_date,
			Timestamp atualization_date, Comment comment) {
		super(id, content, moderator, status, creation_date, atualization_date);
		this.comment = comment;
	}

	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
	}
}
