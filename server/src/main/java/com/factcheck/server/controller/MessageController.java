package com.factcheck.server.controller;

import com.factcheck.server.model.Message;
import com.factcheck.server.service.MessageService;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Resource
    private MessageService messageService;

    @RequestMapping("/checkMessageValue")
    public String checkMessageValue(@RequestBody CheckInformation record) {
        return messageService.checkMessageValue(record.mid, record.status, record.content,record.username);
    }

    @RequestMapping("/getAllMessages")
    public List<Message> getAllMessages() {
        return messageService.getAllMessages();
    }

    @RequestMapping("/getAllUnCheckedMessages")
    public List<Message> getAllUnCheckedMessages() {
        return messageService.getAllUnCheckedMessages();
    }

    @RequestMapping("/getAllCheckedMessages")
    public List<Message> getAllCheckedMessage() {
        return messageService.getAllCheckedMessages();
    }

    @RequestMapping("/getAllFinishedMessages")
    public List<Message> getAllFinishedMessages() {
        return messageService.getAllFinishedMessages();
    }

    @RequestMapping("/insertMessage")
    public String insertMessage(@RequestBody Message record) {
        return messageService.insertMessage(record);
    }

    @RequestMapping("/updateMessageTag")
    public String updateMessageTag(@RequestBody TagInformation record) {
        return messageService.updateMessageTag(record.tagName, record.mid,record.username);
    }

    @Data
    private static class CheckInformation {
        private Integer mid;

        private Integer status;

        private String content;

        private String username;
    }

    @Data
    private static class TagInformation {
        private String tagName;

        private Integer mid;

        private String username;
    }
}
