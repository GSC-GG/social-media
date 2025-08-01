package model;

import java.sql.Timestamp;

public class Like {
	private int id;
	private Post post;
	private User user;
	private boolean on;			//1 on, 0 removed
	private Timestamp creation_date;
	
	public Like(int id, Post post, User user, boolean on, Timestamp creation_date) {
		super();
		this.id = id;
		this.post = post;
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
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
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
