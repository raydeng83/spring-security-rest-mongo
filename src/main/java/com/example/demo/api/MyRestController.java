package com.example.demo.api;

import com.example.demo.utils.WebUtils;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by leizhang on 2/20/18.
 */
@RestController
public class MyRestController {

    @RequestMapping(method = GET, path = "/greeting")
    @Secured("Role_Admin")
    public Object greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return WebUtils.successMap(name);
    }

    @RequestMapping(method = GET, path = "/currentuser")
    public Object getCurrentUser(HttpServletRequest request) {
        String name = request.getUserPrincipal().getName();
        return WebUtils.successMap(name);
    }
}
