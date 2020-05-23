package com.factcheck.server.controller;

import com.factcheck.server.model.User;
import com.factcheck.server.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/test")
    public List<User> test() {
        return userService.list();
    }
}
