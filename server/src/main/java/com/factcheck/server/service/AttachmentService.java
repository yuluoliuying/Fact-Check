package com.factcheck.server.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class AttachmentService {
    public String upload(MultipartFile file) {
        String basePath = System.getProperty("user.dir") + "/attachment";
        String fullName = file.getOriginalFilename();
        String fileName = fullName.substring(0, fullName.lastIndexOf("."));
        String fileType = fullName.substring(fullName.lastIndexOf(".") + 1);

        File descFile = new File(basePath + File.separator + fullName);
        int count = 1;
        while (descFile.exists()) {
            String newName = fileName + "(" + count + ")." + fileType;
            descFile = new File(basePath + File.separator + newName);
            count++;
        }
        if (!descFile.getParentFile().exists()) descFile.getParentFile().mkdirs();
        try {
            file.transferTo(descFile);
        } catch (IOException e) {
            return e.toString();
        }
        return String.format("{\"finalName\":\"%s\"}", descFile.getName());
    }
}
