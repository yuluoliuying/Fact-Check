package com.factcheck.server.service;

import com.factcheck.server.mapper.MessageMapper;
import com.factcheck.server.mapper.MessageProcessMapper;
import com.factcheck.server.mapper.MessageStateMapper;
import com.factcheck.server.model.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {

    @Resource
    private MessageMapper messageMapper;
    @Resource
    private MessageStateMapper messageStateMapper;
    @Resource
    private MessageProcessMapper messageProcessMapper;

    public String insertMessage(Message record) {
        messageMapper.insert(record);
        MessageState messageState = new MessageState();
        messageState.setMid(record.getMid());
        messageState.setStatus(0);
        messageStateMapper.insert(messageState);
        MessageProcess messageProcess = new MessageProcess();
        messageProcess.setMid(record.getMid());
        messageProcess.setType(0);
        messageProcess.setState(1);
        messageProcess.setUsername(record.getUsername());
        messageProcessMapper.insert(messageProcess);
        return "成功提交流言";
    }

    public String updateMessageTag(String tagName, Integer mid,String username) {
        Message message = messageMapper.selectByPrimaryKey(mid);
        if (message == null) {
            return "此流言不存在";
        }
        String originTag = message.getTagName();
        String newTag = originTag + " " + tagName;
        message.setTagName(newTag);
        messageMapper.updateByPrimaryKey(message);
        return "操作成功";
    }

    public String checkMessageValue(Integer mid, Integer status, String content,String username) {
        MessageState messageState = new MessageState();
        MessageProcess messageProcess = new MessageProcess();
        messageState.setMid(mid);
        if (status == -1) {
            messageState.setStatus(-1);
        } else {
            messageState.setStatus(1);
        }
        messageProcess.setMid(mid);
        messageProcess.setType(1);
        messageProcess.setState(1);
        messageProcess.setContent(content);
        messageProcess.setUsername(username);
        messageStateMapper.updateByPrimaryKey(messageState);
        messageProcessMapper.insert(messageProcess);
        return "操作完成";
    }


    public List<Message> getAllMessages() {
        MessageExample messageExample = new MessageExample();
        return messageMapper.selectByExample(messageExample);
    }

    public List<Message> getAllUnCheckedMessages() {
        MessageStateExample messageStateExample = new MessageStateExample();
        messageStateExample.createCriteria().andStatusEqualTo(0);
        return getMessages(messageStateExample);
    }

    public List<Message> getAllCheckedMessages() {
        MessageStateExample messageStateExample = new MessageStateExample();
        messageStateExample.createCriteria().andStatusEqualTo(1);
        return getMessages(messageStateExample);
    }

    public List<Message> getAllFinishedMessages() {
        MessageStateExample messageStateExample = new MessageStateExample();
        messageStateExample.createCriteria().andStatusEqualTo(4);
        return getMessages(messageStateExample);
    }


    private List<Message> getMessages(MessageStateExample messageStateExample) {
        List<MessageState> messageStates = messageStateMapper.selectByExample(messageStateExample);
        MessageExample messageExample = new MessageExample();
        List<Integer> midList = new ArrayList<>();
        for (MessageState state : messageStates) {
            midList.add(state.getMid());
        }
        messageExample.createCriteria().andMidIn(midList);
        return messageMapper.selectByExample(messageExample);
    }


}
