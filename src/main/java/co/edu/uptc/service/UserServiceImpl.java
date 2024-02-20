package co.edu.uptc.service;

import co.edu.uptc.model.User;
import co.edu.uptc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> fetchUserList() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user, Long id) {
        User user1 = userRepository.findById(id).get();

        if (Objects.nonNull(user.getUserName()) && !"".equalsIgnoreCase(user.getUserName())) {
            user1.setUserName(user.getUserName());
        }

        if (Objects.nonNull(user.getName()) && !"".equalsIgnoreCase(user.getName())) {
            user1.setName(user.getName());
        }

        if (Objects.nonNull(user.getDate()) && !"".equalsIgnoreCase(String.valueOf(user.getDate()))) {
            user1.setDate(user.getDate());
        }
        return userRepository.save(user1);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}
