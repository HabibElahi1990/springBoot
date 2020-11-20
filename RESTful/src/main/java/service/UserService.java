package service;

import model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Habib, on 20/11/2020
 */
@Service
public class UserService {

    private static List<User> userList = new ArrayList<>();

    public void saveUser(User user) {
        userList.add(user);
    }

    public String getUser(Long userId) {
        Optional<User> first = userList.stream().filter(n -> n.getId().equals(userId)).findFirst();
        return first.get().toString();
    }

    public User updateUser(User user) {
        userList.stream()
                .filter(n -> n.getId().equals(user.getId()))
                .forEach(n -> {
                    n.setUserName(user.getUserName());
                    n.setPassword(user.getPassword());
                    n.setActiveFlag(user.getActiveFlag());
                });

        Optional<User> first = userList.stream().filter(n -> n.getId().equals(user.getId())).findFirst();
        return first.orElse(null);
    }

    public void deleteUser(Long userId) {
        for (User user : userList) {
            if (user.getId().equals(userId)) {
                userList.remove(user);
                return;
            }
        }
    }

    public List<User> getAllUser() {
        return userList;
    }
}
