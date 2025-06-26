package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import com.example.model.User;

public class UserDAO {

	private DataSource dataSource; // Updated to DataSource for proper DI

	// Setter Injection for DataSource
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<User> getAllUsers() throws SQLException {
		List<User> users = new ArrayList<>();
		try (Connection connection = dataSource.getConnection();
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM student")) {

			while (rs.next()) {
				users.add(new User(rs.getInt("STDID"), rs.getString("STDNAME"), rs.getLong("STDMOBILE")));

			}
		}
		return users;
	}

	public void createUser(User user) throws SQLException {
		try (Connection connection = dataSource.getConnection();
				PreparedStatement ps = connection
						.prepareStatement("INSERT INTO USERS (STDID, STDNAME, STDMOBILE) VALUES (?, ?, ?)");) {

			ps.setInt(1, user.getId());
			ps.setString(2, user.getName());
			ps.setLong(3, user.getMobile());
			ps.executeUpdate();
		}
	}

	public void updateUser(User user) throws SQLException {
		try (Connection connection = dataSource.getConnection();
				PreparedStatement ps = connection
						.prepareStatement("UPDATE USERS SET STDID = ?, STDNAME = ?, STDMOBILE = ? WHERE ID = ?");) {
			ps.setInt(1, user.getId());
			ps.setString(2, user.getName());
			ps.setLong(3, user.getMobile());
			ps.setInt(3, user.getId());
			ps.executeUpdate();
		}
	}

	public void deleteUser(int id) throws SQLException {
		try (Connection connection = dataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement("DELETE FROM USERS WHERE STDID = ?");) {
			ps.setInt(1, id);
			ps.executeUpdate();
		}
	}
}