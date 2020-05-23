package com.factcheck.server.service;

import com.factcheck.server.mapper.UserMapper;
import com.factcheck.server.model.User;
import com.factcheck.server.model.UserExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    public List<User> list() {
        UserExample example = new UserExample();
        example.createCriteria().andUidEqualTo(1);
        return userMapper.selectByExample(example);
    }
}
