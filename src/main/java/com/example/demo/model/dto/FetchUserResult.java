package com.example.demo.model.dto;

import com.example.demo.model.User;

import java.util.List;

/**
 * Created by leizhang on 2/27/18.
 */
public class FetchUserResult {
    private User user;

    private List<User> userList;

    public FetchUserResult(User user) {
        if (user != null)
            user.setPassword(null);
        this.user = user;
    }

    public FetchUserResult(List<User> users) {
        if (users != null) {
            for (User user : users) {
                user.setPassword(null);
            }
        }
        this.userList = users;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
