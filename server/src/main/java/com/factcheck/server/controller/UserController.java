package com.factcheck.server.controller;

import com.factcheck.server.model.Tag;
import com.factcheck.server.model.User;
import com.factcheck.server.model.UserTag;
import com.factcheck.server.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Api("用户控制器")
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @ApiOperation("测试")
    @PostMapping("/test")
    public List<User> test() {
        return userService.list();
    }

    @ApiOperation("注册")
    @PostMapping("/signUp")
    public String signUp(@RequestBody User record) {
        return userService.signUp(record);
    }

    @ApiOperation("登录")
    @PostMapping("/signIn")
    public String signIn(@RequestBody User record) {
        return userService.signIn(record);
    }

    @ApiOperation("更新用户的角色")
    @PostMapping("/updateUserRole")
    public String updateUserRole(@RequestBody UpdateRoleOperation record) {
        return userService.updateUserRole(record.roleName, record.operator, record.username);
    }

    @ApiOperation("添加用户的标签")
    @PostMapping("/addUserTag")
    public String addUserTag(@RequestBody UserTag record) {
        return userService.addUserTag(record.getUsername(), record.getTagName());
    }

    @ApiOperation("获取所有的标签")
    @PostMapping("/getAllTags")
    public List<Tag> getAllTags() {
        return userService.getAllTags();
    }

    @Data
    @ApiModel("更新用户角色所需信息")
    private static class UpdateRoleOperation {
        @ApiModelProperty("操作人员用户名")
        private String operator;
        @ApiModelProperty("被操作人员用户名")
        private String username;
        @ApiModelProperty("角色名")
        private String roleName;
    }
}
