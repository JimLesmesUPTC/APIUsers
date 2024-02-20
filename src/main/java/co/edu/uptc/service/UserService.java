package co.edu.uptc.service;

import co.edu.uptc.model.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    List<User> fetchUserList();

    User updateUser(User user, Long id);

    void deleteUserById(Long id);
}
