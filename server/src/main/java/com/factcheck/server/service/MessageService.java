package com.factcheck.server.service;

import com.factcheck.server.mapper.MessageMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MessageService {

    @Resource
    private MessageMapper messageMapper;
}
