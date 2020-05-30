package com.factcheck.server.controller;

import com.factcheck.server.model.Message;
import com.factcheck.server.service.MessageService;
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

@Api("流言控制器")
@RestController
@RequestMapping("/message")
public class MessageController {

    @Resource
    private MessageService messageService;

    @ApiOperation("第一次审核流言")
    @PostMapping("/checkMessage")
    public String checkMessageValue(@RequestBody CheckInformation record) {
        return messageService.checkMessageValue(record.mid, record.status, record.content,record.username);
    }

    @ApiOperation("查询所有流言")
    @PostMapping("/getAllMessages")
    public List<Message> getAllMessages() {
        return messageService.getAllMessages();
    }

    @ApiOperation("查询所有未经过第一次审核的流言")
    @PostMapping("/getAllUnCheckedMessages")
    public List<Message> getAllUnCheckedMessages() {
        return messageService.getAllUnCheckedMessages();
    }

    @ApiOperation("查询所有经过第一次审核的流言")
    @PostMapping("/getAllCheckedMessages")
    public List<Message> getAllCheckedMessage() {
        return messageService.getAllCheckedMessages();
    }

    @ApiOperation("查询所有已辟谣流言")
    @PostMapping("/getAllFinishedMessages")
    public List<Message> getAllFinishedMessages() {
        return messageService.getAllFinishedMessages();
    }

    @ApiOperation("插入一条流言")
    @PostMapping("/insertMessage")
    public String insertMessage(@RequestBody Message record) {
        return messageService.insertMessage(record);
    }

    @ApiOperation("更新一条流言的标签")
    @PostMapping("/updateMessageTag")
    public String updateMessageTag(@RequestBody TagInformation record) {
        return messageService.updateMessageTag(record.tagName, record.mid,record.username);
    }

    @Data
    @ApiModel("第一次审核流言需要的信息")
    private static class CheckInformation {
        @ApiModelProperty("流言id")
        private Integer mid;
        @ApiModelProperty("审核状态（通过为 1 不通过为 -1）")
        private Integer status;
        @ApiModelProperty("审核意见")
        private String content;
        @ApiModelProperty("审核人员用户名")
        private String username;
    }

    @Data
    @ApiModel("更新流言标签所需信息")
    private static class TagInformation {
        @ApiModelProperty("标签名")
        private String tagName;
        @ApiModelProperty("流言id")
        private Integer mid;
        @ApiModelProperty("审核人员用户名")
        private String username;
    }
}
