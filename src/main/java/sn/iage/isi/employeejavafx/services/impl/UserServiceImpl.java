package sn.iage.isi.employeejavafx.services.impl;

import sn.iage.isi.employeejavafx.config.DB;
import sn.iage.isi.employeejavafx.models.User;
import sn.iage.isi.employeejavafx.services.UserService;
import sn.iage.isi.employeejavafx.tools.Utils;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    private DB db = new DB();
    private int ok;
    private ResultSet rs;

    @Override
    public boolean createUser(User user) {
        String hashedPassword = Utils.hashPassword(user.getPassword());
        String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
        try {
            db.initPrepar(sql);
            db.getPstm().setString(1, user.getUsername());
            db.getPstm().setString(2, hashedPassword);
            int rowsAffected = db.executeMaj();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public User getUserByUsername(String username) {
        User user = null;
        String sql = "SELECT * FROM users WHERE username = ?";
        try {
            db.initPrepar(sql);
            db.getPstm().setString(1, username);
            rs = db.executeSelect();
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.closeConnection();
        }
        return user;
    }

    @Override
    public List<User> getAllUsers() {

        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try{
            db.initPrepar(sql);
            rs = db.executeSelect();
            while (rs.next()){
                User user = new User();
                user.setId(rs.getInt(1));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                users.add(user);
            }
            db.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }



}
