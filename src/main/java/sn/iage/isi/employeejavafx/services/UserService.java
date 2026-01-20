package sn.iage.isi.employeejavafx.services;

import sn.iage.isi.employeejavafx.models.User;

import java.util.List;

public interface UserService {
    boolean createUser(User user);
    User getUserByUsername(String username);
    List<User> getAllUsers();
}
