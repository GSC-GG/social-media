package model;

import java.sql.Timestamp;
import java.util.ArrayList;

public abstract class Report {
	protected int id;
	protected String content;
	protected User reporter;
	protected User moderator;
	protected String status;
	protected String result;
	protected Timestamp creation_date;
	protected Timestamp atualization_date;
	
	public Report(int id, String content, User reporter, User moderator, String status, String result, Timestamp creation_date, Timestamp atualization_date) {
		this.id = id;
		this.content = content;
		this.reporter = reporter;
		this.moderator = moderator;
		this.status = status;
		this.result = result;
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
	public User getReporter() {
		return reporter;
	}
	public void Reporter(User reporter) {
		this.reporter = reporter;
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
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
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
