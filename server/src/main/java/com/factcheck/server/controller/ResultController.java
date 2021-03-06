package com.factcheck.server.controller;

import com.factcheck.server.model.Result;
import com.factcheck.server.service.ResultService;
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

@Api("起草文章控制器")
@RestController
@RequestMapping("/result")
public class ResultController {
    @Resource
    private ResultService resultService;

    @ApiOperation("插入一篇文章")
    @PostMapping("/insertResult")
    public String insertResult(@RequestBody Result record) {
        return resultService.insertResult(record);
    }

    @ApiOperation("通过id查询文章")
    @PostMapping("/getResultById")
    public Result getResultById(@RequestBody Rid rid) {
        return resultService.selectResultById(rid.rid);
    }

    @ApiOperation("查询任意n篇文章")
    @PostMapping("/getRandomResult")
    public List<Result> getRandomResult(@RequestBody Index index) {
        return resultService.getRandomResult(index.index);
    }

    @ApiOperation("查询最近的n篇文章")
    @PostMapping("/getRecentResult")
    public List<Result> getRecentResult(@RequestBody Index index) {
        return resultService.getRecentResult(index.index);
    }

    @ApiOperation("查询所有需要审核的文章")
    @PostMapping("/getAllUncheckedResult")
    public List<Result> getAllUncheckedResult() {
        return resultService.getAllUnCheckedResult();
    }

    @ApiOperation("更新一篇文章")
    @PostMapping("/updateResult")
    public String updateResult(@RequestBody Result record) {
        return resultService.updateResult(record);
    }

    @ApiOperation("查询一篇文章是否通过第二次审核")
    @PostMapping("/isChecked")
    public boolean isChecked(@RequestBody Rid rid) {
        return resultService.isChecked(rid.rid);
    }

    @ApiOperation("第二次审核文章（即根据通过第一次审核的流言起草的文章）")
    @PostMapping("/checkResult")
    public String checkResult(@RequestBody CheckInformation record) {
        return resultService.checkResult(record.rid, record.mid, record.status, record.content, record.username);
    }

    @ApiOperation("查询所有被否决的文章")
    @PostMapping("/getAllDeniedResult")
    public List<Result> getAllDeniedResult() {
        return resultService.getAllDeniedResult();
    }

    @ApiOperation("重新起草文章")
    @PostMapping("/reDraftResult")
    public String reDraftResult(@RequestBody Result record) {
        return resultService.reDraftResult(record);
    }

    @ApiOperation("获取所有被否决的文章以及对应的修改建议")
    @PostMapping("/getAllDeniedResultWithAdvice")
    public List<DeniedResultWithAdvice> getAllDeniedResultWithAdvice() {
        return resultService.getAllDeniedResultWithAdvice();
    }

    @ApiOperation("获取所有审核通过的文章")
    @PostMapping("/getAllCheckedResult")
    public List<Result> getAllCheckedResult() {
        return resultService.getAllCheckedResult();
    }

    @Data
    @ApiModel("文章id")
    private static class Rid {
        @ApiModelProperty("文章id")
        private Integer rid;
    }

    @Data
    @ApiModel("文章数量")
    private static class Index {
        @ApiModelProperty("文章数量")
        private Integer index;
    }

    @Data
    @ApiModel("第二次审核文章需要的信息")
    private static class CheckInformation {
        @ApiModelProperty("流言id（注意这个id是文章相关的流言的id，不是文章id）")
        private Integer mid;
        @ApiModelProperty("文章id")
        private Integer rid;
        @ApiModelProperty("审核状态（通过为 1 不通过为 -1）")
        private Integer status;
        @ApiModelProperty("审核意见")
        private String content;
        @ApiModelProperty("审核人员用户名")
        private String username;
    }

    @Data
    @ApiModel("不合格的文章和它的审核意见")
    public static class DeniedResultWithAdvice {

        @ApiModelProperty("文章")
        private Result result;

        @ApiModelProperty("审核意见")
        private String advice;
    }
}
