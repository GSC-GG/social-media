package model;

import java.sql.Timestamp;

public abstract class Comment {
	protected int id;
	protected String content;
	protected User user;
	protected boolean on;			//1 on, 0 removed
	protected Timestamp creation_date;
	
	public Comment(int id, String content, User user, boolean on, Timestamp creation_date) {
		this.id = id;
		this.content = content;
		this.user = user;
		this.on = on;
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
	public boolean isOn() {
		return on;
	}
	public void setStatus(boolean on) {
		this.on = on;
	}
	public Timestamp getCreation_date() {
		return creation_date;
	}
	/*
	 * public void setCreation_date(Timestamp creation_date) { this.creation_date =
	 * creation_date; }
	 */	
}
