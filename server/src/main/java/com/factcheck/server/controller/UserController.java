package com.factcheck.server.controller;

import com.factcheck.server.model.User;
import com.factcheck.server.model.UserTag;
import com.factcheck.server.service.UserService;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/test")
    public List<User> test() {
        return userService.list();
    }

    @RequestMapping("/signUp")
    public String signUp(@RequestBody User record) {
        return userService.signUp(record);
    }

    @RequestMapping("/signIn")
    public String signIn(@RequestBody User record) {
        return userService.signIn(record);
    }

    @RequestMapping("/updateUserRole")
    public String updateUserRole(@RequestBody UpdateRoleOperation record) {
        return userService.updateUserRole(record.roleName, record.operator, record.username);
    }

    @RequestMapping("/addUserTag")
    public String addUserTag(@RequestBody UserTag record) {
        return userService.addUserTag(record.getUsername(), record.getTagName());
    }

    @Data
    private static class UpdateRoleOperation {
        private String operator;

        private String username;

        private String roleName;
    }
}
