package model;

import java.sql.Timestamp;

public abstract class Comment {
	protected int id;
	protected String content;
	protected User user;
	protected boolean removed;			//0 on, 1 removed
	protected Timestamp creation_date;
	
	public Comment(int id, String content, User user, boolean removed, Timestamp creation_date) {
		this.id = id;
		this.content = content;
		this.user = user;
		this.removed = removed;
		this.creation_date = creation_date;
	}
	
	public int getId() {
		return id;
	}
	/*
	 * public void setId(int id) { this.id = id; }
	 */
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public boolean isRemoved() {
		return removed;
	}
	public void setStatus(boolean posted) {
		this.removed = !removed;
	}
	public Timestamp getCreation_date() {
		return creation_date;
	}
	/*
	 * public void setCreation_date(Timestamp creation_date) { this.creation_date =
	 * creation_date; }
	 */	
}
