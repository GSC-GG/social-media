package model;

import java.sql.Timestamp;
import java.util.ArrayList;

public abstract class Report {
	protected int id;
	protected String content;
	protected User moderator;
	protected String status;
	protected Timestamp creation_date;
	protected Timestamp atualization_date;
	
	public Report(int id, String content, User moderator, String status, Timestamp creation_date, Timestamp atualization_date) {
		this.id = id;
		this.content = content;
		this.moderator = moderator;
		this.status = status;
		this.creation_date = creation_date;
		this.setAtualization_date(atualization_date);
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
	public User getModerator() {
		return moderator;
	}
	public void setModerator(User moderator) {
		this.moderator = moderator;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		ArrayList<String> status_list = new ArrayList<String>();
		status_list.add("pending");
		status_list.add("archived");
		status_list.add("concluded");
		
		if (status_list.contains(status)) {
			this.status = status;
		} else {
			throw new IllegalArgumentException("Invalid status attribution (only \"pending\", \"archived\" or \"concluded\"");
		}
	}
	public Timestamp getCreation_date() {
		return creation_date;
	}
	/*
	 * public void setCreation_date(Timestamp creation_date) { this.creation_date =
	 * creation_date; }
	 */
	public Timestamp getAtualization_date() {
		return atualization_date;
	}
	public void setAtualization_date(Timestamp atualization_date) {
		this.atualization_date = atualization_date;
	}
}
