package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.DBConnection;
import model.User;

public class UserDAO extends AbstractDAO {

    public UserDAO() throws SQLException {
        this.conn = new DBConnection().getConnection();
    }
	
	public void insert(User user) throws SQLException {
		String sql = "INSERT INTO users (first_name, last_name, username, nickname, photo, email, password, level, status) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, user.getFirst_name());
        stmt.setString(2, user.getLast_name());
        stmt.setString(3, user.getUsername());
        stmt.setString(4, user.getNickname());
        stmt.setString(5, user.getPhoto());
        stmt.setString(6, user.getEmail());
        stmt.setString(7, user.getPassword());
        stmt.setString(8, user.getLevel());
        stmt.setString(9, user.getStatus());
        stmt.execute();
        stmt.close();
	}
	
	public void update(User user) throws SQLException {
		String sql = "UPDATE users SET first_name = ?, last_name = ?, username = ?, nickname = ?, photo = ?, email = ?, password = ?, level = ?, status = ?"
				+ "WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, user.getFirst_name());
        stmt.setString(2, user.getLast_name());
        stmt.setString(3, user.getUsername());
        stmt.setString(4, user.getNickname());
        stmt.setString(5, user.getPhoto());
        stmt.setString(6, user.getEmail());
        stmt.setString(7, user.getPassword());
        stmt.setString(8, user.getLevel());
        stmt.setString(9, user.getStatus());
        stmt.setInt(10, user.getId());
        stmt.execute();
        stmt.close();
	}
	
	public User selectFromId(int id) throws SQLException {
		String sql = "SELECT * FROM users WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        User user = null;
        if (rs != null && rs.next()) {
        	user = mapUser(rs);
        }
        rs.close();
        stmt.close();
        return user;
	}
	
	public ArrayList<User> listAll() throws SQLException {
		String sql = "SELECT * FROM users";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        ArrayList<User> list = new ArrayList<User>();
        User user = null;
        int id;

        if (rs != null) {
        	while (rs.next()) {
        		id = rs.getInt("id");
        		user = selectFromId(id);
        		list.add(user);
        	}
        	return list;
        } else {
        	return null;
        }
	}
	
	public ArrayList<User> listByName(String name) throws SQLException {
		String sql = "SELECT * FROM users WHERE username LIKE %?% OR nickname LIKE %?%";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, name);
        stmt.setString(2, name);
        ResultSet rs = stmt.executeQuery();
        
        ArrayList<User> list = new ArrayList<User>();
        User user = null;
        int id;

        if (rs != null) {
        	while (rs.next()) {
        		id = rs.getInt("id");
        		user = selectFromId(id);
        		list.add(user);
        	}
        	return list;
        } else {
        	return null;
        }
	}
	
	public ArrayList<User> listByLevel(String level) throws SQLException {
		String sql = "SELECT * FROM users WHERE level = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, level);
        ResultSet rs = stmt.executeQuery();
        
        ArrayList<User> list = new ArrayList<User>();
        User user = null;
        int id;

        if (rs != null) {
        	while (rs.next()) {
        		id = rs.getInt("id");
        		user = selectFromId(id);
        		list.add(user);
        	}
        	return list;
        } else {
        	return null;
        }
	}
	
	public ArrayList<User> listByStatus(String status) throws SQLException {
		String sql = "SELECT * FROM users WHERE level = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, status);
        ResultSet rs = stmt.executeQuery();
        
        ArrayList<User> list = new ArrayList<User>();
        User user = null;
        int id;

        if (rs != null) {
        	while (rs.next()) {
        		id = rs.getInt("id");
        		user = selectFromId(id);
        		list.add(user);
        	}
        	return list;
        } else {
        	return null;
        }
	}
	
	public User mapUser(ResultSet rs) throws SQLException {
		return new User(
				rs.getInt("id"),
				rs.getString("first_name"),
				rs.getString("last_name"),
				rs.getString("username"),
				rs.getString("nickname"),
				rs.getString("photo"),
				rs.getString("email"),
				rs.getString("password"),
				rs.getString("level"),
				rs.getString("status"),
				rs.getTimestamp("creation_date")
				);
	}
	
	public ArrayList<User> listFollows(int id) throws SQLException {
		String sql = "SELECT * FROM Follows WHERE idFollower = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        
        ArrayList<User> list = new ArrayList<User>();
        User followed = null;
        int idFollowed;
        
        if (rs != null) {
			while (rs.next()) {
				idFollowed = rs.getInt("idFollowed");
				followed = selectFromId(idFollowed);
				list.add(followed);
			}
			return list;
        } else {
        	return null;
        }
	}
	
	public ArrayList<User> listFollowers(int id) throws SQLException {
		String sql = "SELECT * FROM Follows WHERE idFollowed = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        
        ArrayList<User> list = new ArrayList<User>();
        User follower = null;
        int idFollower;
        
        if (rs != null) {
			while (rs.next()) {
				idFollower = rs.getInt("idFollower");
				follower = selectFromId(idFollower);
				list.add(follower);
			}
			return list;
        } else {
        	return null;
        }
	}
}
