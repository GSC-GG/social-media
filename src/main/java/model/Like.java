package model;

import java.sql.Timestamp;

public class Like {
	private int id;
	private Post post;
	private User user;
	private boolean removed;			//0 on, 1 removed
	private Timestamp creation_date;
	
	public Like(int id, Post post, User user, boolean removed, Timestamp creation_date) {
		super();
		this.id = id;
		this.post = post;
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
	public boolean isRemoved() {
		return removed;
	}
	public void setStatus(boolean removed) {
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
