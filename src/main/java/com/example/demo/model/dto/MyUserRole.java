package com.example.demo.model.dto;

import com.example.demo.model.Role;
import org.springframework.security.core.GrantedAuthority;

/**
 * Created by leizhang on 2/27/18.
 */
public class MyUserRole implements GrantedAuthority {

    private Role role;

    public MyUserRole(Role role) {
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return role.getRole();
    }
}
