package com.factcheck.server.controller;

import com.factcheck.server.model.Result;
import com.factcheck.server.service.ResultService;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/result")
public class ResultController {
    @Resource
    private ResultService resultService;

    @RequestMapping("/insertResult")
    public String insertResult(@RequestBody Result record) {
        return resultService.insertResult(record);
    }

    @RequestMapping("/getResultById")
    public Result getResultById(@RequestBody Rid rid) {
        return resultService.selectResultById(rid.rid);
    }

    @RequestMapping("/getRandomResult")
    public List<Result> getRandomResult(@RequestBody Index index) {
        return resultService.getRandomResult(index.index);
    }

    @RequestMapping("/getRecentResult")
    public List<Result> getRecentResult(@RequestBody Index index) {
        return resultService.getRecentResult(index.index);
    }

    @RequestMapping("/updateResult")
    public String updateResult(@RequestBody Result record) {
        return resultService.updateResult(record);
    }

    @RequestMapping("/isChecked")
    public boolean isChecked(@RequestBody Rid rid) {
        return resultService.isChecked(rid.rid);
    }

    @RequestMapping("/checkResult")
    public String checkResult(@RequestBody CheckInformation record) {
        return resultService.checkResult(record.mid, record.status, record.content, record.username);
    }

    @Data
    private static class Rid {
        private Integer rid;
    }

    @Data
    private static class Index {
        private Integer index;
    }

    @Data
    private static class CheckInformation {
        private Integer mid;

        private Integer status;

        private String content;

        private String username;
    }
}
