package com.bogdan.dao;

import com.bogdan.model.User;

import java.util.LinkedList;
import java.util.List;

public class UserDao {

    private static UserDao instance;

    UserDao() {
    }

    public static UserDao getInstance() {
        if (instance == null) {
            instance = new UserDao();
        }
        return instance;
    }

    public List<User> users = new LinkedList<>();

    public List<User> getUsersList() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public User getUser(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public boolean updateUser(User upUser) {
        for (User user : users) {
            if (user.getId() == upUser.getId()) {
                user.setAge(upUser.getAge());
                user.setName(upUser.getName());
                return true;
            }
        }
        return false;
    }

    public boolean deleteUser(String name) {
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(name)) {
                users.remove(user);
                return true;
            }
        }
        return false;
    }
}
