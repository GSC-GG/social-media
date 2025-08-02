package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import database.DBConnection;

public class Migration extends AbstractDAO {
	
	public Migration() throws SQLException {
        this.conn = new DBConnection().getConnection();
        //String schema = this.dbConnection.getSchema();
        PreparedStatement stmt;
        String usersTable = "CREATE TABLE IF NOT EXISTS Users ("
        		+ "id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,"
        		+ "first_name VARCHAR(32) NOT NULL,"
        		+ "last_name VARCHAR(64) NOT NULL,"
        		+ "username VARCHAR(16) NOT NULL,"
        		+ "nickname VARCHAR(16) NOT NULL,"
        		+ "photo VARCHAR(64),"
        		+ "email VARCHAR(64) NOT NULL,"
        		+ "password VARCHAR(64) NOT NULL,"
        		+ "level ENUM('user', 'moderator', 'administrator') DEFAULT 'user',"
        		+ "status ENUM('active', 'inactive', 'banned') DEFAULT 'active',"
        		+ "creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP"
        		+ ")";
        stmt = conn.prepareStatement(usersTable);
        stmt.execute();
        
        String postsTable = "CREATE TABLE IF NOT EXISTS Posts ("
        		+ "id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,"
        		+ "content VARCHAR(2000) DEFAULT ' ',"
        		+ "annex VARCHAR(64),"
        		+ "idUser INT UNSIGNED NOT NULL,"
        		+ "status ENUM('public', 'archived', 'deleted') DEFAULT 'public',"
        		+ "creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,"
        		+ "edition_date TIMESTAMP NULL ON UPDATE CURRENT_TIMESTAMP,"
        		+ "FOREIGN KEY (idUser) REFERENCES Users (id)"
        		+ ")";
        stmt = conn.prepareStatement(postsTable);
        stmt.execute();
        
        String commentsTable = "CREATE TABLE IF NOT EXISTS Comments ("
        		+ "id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,"
        		+ "content VARCHAR(2000) NOT NULL,"
        		+ "idUser INT UNSIGNED NOT NULL,"
        		+ "idComment INT UNSIGNED,"
        		+ "idPost INT UNSIGNED,"
        		+ "removed BOOLEAN DEFAULT 1,"
        		+ "creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,"
        		+ "FOREIGN KEY (idUser) REFERENCES Users (id),"
        		+ "FOREIGN KEY (idComment) REFERENCES Comments (id),"
        		+ "FOREIGN KEY (idPost) REFERENCES Posts (id)"
        		+ ")";
        stmt = conn.prepareStatement(commentsTable);
        stmt.execute();
        
        String likesTable = "CREATE TABLE IF NOT EXISTS Likes ("
        		+ "id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,"
        		+ "idPost INT UNSIGNED,"
        		+ "idUser INT UNSIGNED NOT NULL,"
        		+ "removed BOOLEAN DEFAULT 1,"
        		+ "creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,"
        		+ "FOREIGN KEY (idUser) REFERENCES Users (id),"
        		+ "FOREIGN KEY (idPost) REFERENCES Posts (id)"
        		+ ")";
        stmt = conn.prepareStatement(likesTable);
        stmt.execute();
        
        String reportsTable = "CREATE TABLE IF NOT EXISTS Reports ("
        		+ "id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,"
        		+ "content VARCHAR(2000) NOT NULL,"
        		+ "idReporter INT UNSIGNED NOT NULL,"
        		+ "idModerator INT UNSIGNED,"
        		+ "idComment INT UNSIGNED,"
        		+ "idPost INT UNSIGNED,"
        		+ "status ENUM('pending', 'archived', 'concluded') DEFAULT 'pending',"
        		+ "result VARCHAR(200),"
        		+ "creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,"
        		+ "atualization_date TIMESTAMP NULL ON UPDATE CURRENT_TIMESTAMP,"
        		+ "FOREIGN KEY (idReporter) REFERENCES Users (id),"
        		+ "FOREIGN KEY (idModerator) REFERENCES Users (id),"
        		+ "FOREIGN KEY (idComment) REFERENCES Comments (id),"
        		+ "FOREIGN KEY (idPost) REFERENCES Posts (id)"
        		+ ")";
        stmt = conn.prepareStatement(reportsTable);
        stmt.execute();
        
        String followsTable = "CREATE TABLE IF NOT EXISTS Follows ("
        		+ "idFollower INT UNSIGNED NOT NULL,"
        		+ "idFollowed INT UNSIGNED NOT NULL,"
        		+ "FOREIGN KEY (idFollower) REFERENCES Users (id),"
        		+ "FOREIGN KEY (idFollowed) REFERENCES Users (id)"
        		+ ")";
        stmt = conn.prepareStatement(followsTable);
        stmt.execute();
        stmt.close();
    }
}
