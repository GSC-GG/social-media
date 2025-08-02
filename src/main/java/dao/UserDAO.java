package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import database.DBConnection;
import model.User;

public class UserDAO extends AbstractDAO {

    public UserDAO() throws SQLException {
        this.conn = new DBConnection().getConnection();
    }
	
	public void inserir(User user) throws SQLException {
		String sql = "INSERT INTO Users (first_name, last_name, username, nickname, photo, email, password, level, status) "
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
}
