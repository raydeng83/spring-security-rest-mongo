package com.example.demo.api;

import com.example.demo.model.User;
import com.example.demo.model.dto.UpdateUserResult;
import com.example.demo.service.UserService;
import com.example.demo.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by leizhang on 2/27/18.
 */
@RestController
@RequestMapping(path = "/api/v1/admin")
public class AdminRestController {

    @Autowired
    UserService userService;

    @RequestMapping(method = POST, path = "/users")
    public Object createUser(@RequestBody User user) {
        UpdateUserResult result = userService.createUser(user);
        if (result.isSuccess()) {
            return WebUtils.createSuccessMap(result.getUser());
        } else {
            return WebUtils.failedMap(result.getErrorMessages());
        }
    }

    @RequestMapping(method = GET, path = "/user/{username}")
    public Object getUser(@PathVariable String username) {
        return (WebUtils.successMap(userService.getUserByUsername(username).getUser()));
    }


}
