package dao;

import java.sql.Connection;
import java.sql.SQLException;

import database.DBConnection;

public abstract class AbstractDAO {

	protected DBConnection dbConnection;
	protected Connection conn;

	public AbstractDAO() {}
	
	public Connection getConnection() throws SQLException {
		this.dbConnection = new DBConnection();
		return this.dbConnection.getConnection();
	}
}
