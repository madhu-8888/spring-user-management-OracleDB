package com.example.service;

import java.sql.SQLException;
import java.util.List;

import com.example.dao.UserDAO;
import com.example.model.User;

public class UserService {
	

    private UserDAO userDAO;

    // Constructor Injection
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public List<User> getAllUsers() throws SQLException {
        return userDAO.getAllUsers();
    }

    public void createUser(User user) throws SQLException {
        userDAO.createUser(user);
    }

    public void updateUser(User user) throws SQLException {
        userDAO.updateUser(user);
    }

    public void deleteUser(int id) throws SQLException {
        userDAO.deleteUser(id);
    }
}
