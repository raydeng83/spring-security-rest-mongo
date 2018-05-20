package com.example.demo.service;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.model.dto.FetchUserResult;
import com.example.demo.model.dto.UpdateUserResult;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leizhang on 2/27/18.
 */
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    public UpdateUserResult createUser(User user) {
        List<String> errorMessages = validateUser(user);
        if (errorMessages == null || errorMessages.size() == 0) {
            if (user.getRoles() == null || user.getRoles().size() == 0) {
                List<Role> roles = new ArrayList<>();
                roles.add(new Role("ROLE_USER"));
                user.setRoles(roles);
            }
            User createdUser = userRepository.save(user);
            return new UpdateUserResult(createdUser);
        } else {
            return new UpdateUserResult(errorMessages);
        }
    }

    public FetchUserResult getUserByUsername(String username) {
        return new FetchUserResult(userRepository.findByUsername(username));
    }

    private List<String> validateUser(User user) {
        List<String> errorMessages = new ArrayList<>();
        checkNull(errorMessages, user.getFirstName(), "First Name");
        checkNull(errorMessages, user.getLastName(), "Last Name");
        checkNull(errorMessages, user.getPassword(), "Password");
        checkNull(errorMessages, user.getUsername(), "Username");
        return errorMessages;
    }

    private void checkNull(List<String> errorMessages, String value, String fieldName) {
        if (StringUtils.isEmpty(value)) {
            errorMessages.add(fieldName + " can't be null.");
        }
    }
}
