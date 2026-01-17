package sn.iage.isi.employeejavafx.services;

import sn.iage.isi.employeejavafx.models.User;

public interface UserService {
    boolean createUser(User user);
    User getUserByUsername(String username);
}
