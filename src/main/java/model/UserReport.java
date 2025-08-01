package model;

import java.sql.Timestamp;

public class UserReport extends Report {
	private User user;

	public UserReport(int id, String content, User moderator, String status, Timestamp creation_date,
			Timestamp atualization_date, User user) {
		super(id, content, moderator, status, creation_date, atualization_date);
		this.user = user;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
