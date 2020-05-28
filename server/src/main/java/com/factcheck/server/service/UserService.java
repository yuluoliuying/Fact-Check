package com.factcheck.server.service;

import com.factcheck.server.mapper.UserMapper;
import com.factcheck.server.mapper.UserTagMapper;
import com.factcheck.server.model.User;
import com.factcheck.server.model.UserExample;
import com.factcheck.server.model.UserTag;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private UserTagMapper userTagMapper;


    public List<User> list() {
        UserExample example = new UserExample();
        example.createCriteria().andUidEqualTo(1);
        return userMapper.selectByExample(example);
    }

    public String signIn(User record) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(record.getUsername()).andPasswordEqualTo(record.getPassword());
        if (userMapper.selectByExample(userExample).size() == 0) {
            return "用户名或密码错误";
        }
        return userMapper.selectByExample(userExample).get(0).getRoleName();
    }

    public String signUp(User record) {
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(record.getUsername());
        if (userMapper.selectByExample(example).size() != 0) {
            return "用户已经存在";
        }
        userMapper.insert(record);
        return "已成功注册";
    }

    public String updateUserRole(String roleName, String operator, String username) {
        UserExample operatorExample = new UserExample();
        operatorExample.createCriteria().andUsernameEqualTo(operator);
        if (!"管理员".equals(userMapper.selectByExample(operatorExample).get(0).getRoleName())) {
            return "您无权使用此操作";
        }
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(username);
        if (userMapper.selectByExample(userExample).size() == 0) {
            return "此用户不存在";
        }
        User record = userMapper.selectByExample(userExample).get(0);
        record.setRoleName(roleName);
        userMapper.updateByExample(record, userExample);
        return "操作成功";
    }

    public String addUserTag(String username, String tagName) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(username);
        if (userMapper.selectByExample(userExample).size() == 0) {
            return "此用户不存在";
        }
        UserTag record = new UserTag();
        record.setUsername(username);
        record.setTagName(tagName);
        userTagMapper.insert(record);
        return "操作成功";

    }
}
