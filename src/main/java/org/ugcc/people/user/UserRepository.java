package org.ugcc.people.user;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Component
public class UserRepository {
    private static Map<String, User> users = new HashMap<>();

    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    public User findUser(String id) {
        return users.get(id);
    }
}
