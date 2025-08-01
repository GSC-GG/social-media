package model;

import java.sql.Timestamp;
import java.util.ArrayList;

public class User {
	private int id;
	private String first_name;
	private String last_name;
	private String username;
	private String nickname;
	private String photo;
	private String email;
	private String password;
	private String level;			//user, mod, admin
	private String status;			//banned, inactive, active
	private ArrayList<User> followers;
	private ArrayList<User> following;
	private Timestamp creation_date;
	
	public User(int id, String first_name, String last_name, String username, String nickname, String photo,
			String email, String password, String level, String status, ArrayList<User> followers,
			ArrayList<User> following, Timestamp creation_date) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.username = username;
		this.nickname = nickname;
		this.photo = photo;
		this.email = email;
		this.password = password;
		this.level = level;
		this.status = status;
		this.followers = followers;
		this.following = following;
		this.creation_date = creation_date;
	}
	
	public int getId() {
		return id;
	}
	/*
	 * public void setId(int id) { this.id = id; }
	 */
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		ArrayList<String> level_list = new ArrayList<String>();
		level_list.add("user");
		level_list.add("moderator");
		level_list.add("administrator");
		
		if (level.equals("mod"))
			level = "moderator";
		if (level.equals("admin"))
			level = "administrator";
		
		if (level_list.contains(level)) {
			this.level = level;
		} else {
			throw new IllegalArgumentException("Invalid level attribution (only \"user\", \"moderator/mod\" or \"administrator/admin\"");
		}
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		ArrayList<String> status_list = new ArrayList<String>();
		status_list.add("active");
		status_list.add("inactive");
		status_list.add("banned");
		
		if (status_list.contains(status)) {
			this.status = status;
		} else {
			throw new IllegalArgumentException("Invalid status attribution (only \"active\", \"inactive\" or \"banned\"");
		}
	}
	public ArrayList<User> getFollowers() {
		return followers;
	}
	public void setFollowers(ArrayList<User> followers) {
		this.followers = followers;
	}
	public ArrayList<User> getFollowing() {
		return following;
	}
	public void setFollowing(ArrayList<User> following) {
		this.following = following;
	}
	public Timestamp getCreation_date() {
		return creation_date;
	}
	/*
	 * public void setCreation_date(Timestamp creation_date) { this.creation_date =
	 * creation_date; }
	 */
}
