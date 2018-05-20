package com.example.demo.model;

import org.springframework.data.annotation.Id;

/**
 * Created by leizhang on 2/27/18.
 */
public class Role {
    @Id
    private String role;

    public Role() {
    }

    public Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
