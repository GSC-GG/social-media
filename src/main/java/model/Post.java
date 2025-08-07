package model;

import java.sql.Timestamp;
import java.util.ArrayList;

public class Post {
	private int id;
	private String content;
	private String annex;
	private User user;
	private String status;			//public, archived, deleted
	private Timestamp creation_date;
	private Timestamp edition_date;
	
	public Post(int id, String content, String annex, User user, String status, Timestamp creation_date) {
		this.id = id;
		this.content = content;
		this.annex = annex;
		this.user = user;
		setStatus(status);
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
	public String getAnnex() {
		return annex;
	}
	public void setAnnex(String annex) {
		this.annex = annex;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		ArrayList<String> status_list = new ArrayList<String>();
		status_list.add("public");
		status_list.add("archived");
		status_list.add("deleted");
		
		if (status_list.contains(status)) {
			this.status = status;
		} else {
			throw new IllegalArgumentException("Invalid status attribution (only \"public\", \"archived\" or \"deleted\"");
		}
	}
	public Timestamp getCreation_date() {
		return creation_date;
	}
	/*
	 * public void setCreation_date(Timestamp creation_date) { this.creation_date =
	 * creation_date; }
	 */
	public Timestamp getEdition_date() {
		return edition_date;
	}
	public void setEdition_date(Timestamp edition_date) {
		this.edition_date = edition_date;
	}	
}
