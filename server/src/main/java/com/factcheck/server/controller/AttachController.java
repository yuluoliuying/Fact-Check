package com.factcheck.server.controller;

import com.factcheck.server.service.AttachmentService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@Api("附件相关")
@RestController
public class AttachController {
    @Resource
    private AttachmentService attachmentService;

    @PostMapping("/attachment")
    public String upload(@RequestParam("file_data") MultipartFile file) {
        return attachmentService.upload(file);
    }
}
