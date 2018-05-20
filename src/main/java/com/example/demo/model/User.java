package com.example.demo.model;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leizhang on 2/27/18.
 */
public class User {
    @Id
    private String username;

    private String firstName;
    private String lastName;
    private String password;
    private List<Role> roles;

    public User() {
    }

    public User(String username) {
        this.username = username;
    }

    public User(String username, String firstName, String lastName, String password) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.roles = new ArrayList<>();
        this.roles.add(new Role("ROLE_ADMIN"));
    }

    @Override
    public String toString() {
        return String.format(
                "User[id=%s, firstName='%s', lastName='%s']",
                username, firstName, lastName);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
