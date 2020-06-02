package com.factcheck.server.service;

import com.factcheck.server.controller.ResultController;
import com.factcheck.server.mapper.MessageProcessMapper;
import com.factcheck.server.mapper.MessageStateMapper;
import com.factcheck.server.mapper.ResultMapper;
import com.factcheck.server.mapper.ResultStateMapper;
import com.factcheck.server.model.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Time;
import java.util.*;

@Service
public class ResultService {
    @Resource
    private ResultMapper resultMapper;
    @Resource
    private MessageProcessMapper messageProcessMapper;
    @Resource
    private MessageStateMapper messageStateMapper;
    @Resource
    private ResultStateMapper resultStateMapper;

    public String insertResult(Result record) {
        resultMapper.insert(record);
        MessageState messageState = new MessageState();
        messageState.setMid(record.getMid());
        messageState.setStatus(2);
        MessageProcess messageProcess = new MessageProcess();
        messageProcess.setMid(record.getMid());
        messageProcess.setUsername(record.getUsername());
        messageProcess.setType(2);
        messageProcess.setState(1);
        ResultState resultState = new ResultState();
        resultState.setRid(record.getRid());
        resultState.setState(0);
        resultState.setContent("");
        messageStateMapper.updateByPrimaryKey(messageState);
        messageProcessMapper.insert(messageProcess);
        resultStateMapper.insert(resultState);
        return "操作成功";
    }


    public List<Result> getRandomResult(Integer index) {
        ResultExample resultExample = new ResultExample();
        int sum = resultMapper.selectByExample(resultExample).size();
        if (sum > index) {
            Random random = new Random();
            Set<Integer> set = new HashSet<>();
            while (set.size() != index) {
                int num = random.nextInt(sum) + 1;
                set.add(num);
            }
            resultExample.createCriteria().andRidIn(new ArrayList<>(set));
        }
        return resultMapper.selectByExampleWithBLOBs(resultExample);
    }

    public List<Result> getRecentResult(Integer index) {
        ResultExample resultExample = new ResultExample();
        int sum = resultMapper.selectByExample(resultExample).size();
        if (sum <= index) {
            return resultMapper.selectByExample(resultExample);
        } else {
            resultExample.setOrderByClause("`release_time` ASC");
            resultExample.createCriteria().andReleaseTimeLessThan(new Date());

            List<Result> origin = resultMapper.selectByExampleWithBLOBs(resultExample);
            if (origin.size() == 0) {
                return new ArrayList<>();
            }
            List<Result> results = new ArrayList<>();
            for (int i = 0; i < index; i++) {
                results.add(origin.get(i));
            }
            return results;
        }
    }

    public List<Result> getAllDeniedResult() {
        ResultStateExample resultStateExample = new ResultStateExample();
        resultStateExample.createCriteria().andStateEqualTo(-1);
        return getResults(resultStateExample);
    }


    public List<Result> getAllUnCheckedResult() {
        ResultStateExample resultStateExample = new ResultStateExample();
        resultStateExample.createCriteria().andStateEqualTo(0);
        return getResults(resultStateExample);
    }

    public Result selectResultById(Integer rid) {
        return resultMapper.selectByPrimaryKey(rid);
    }

    public String updateResult(Result record) {
        resultMapper.updateByPrimaryKeyWithBLOBs(record);
        return "操作成功";
    }

    public String reDraftResult(Result record) {
        resultMapper.updateByPrimaryKeyWithBLOBs(record);
        ResultState resultState = new ResultState();
        resultState.setState(0);
        resultState.setRid(record.getRid());
        resultStateMapper.updateByPrimaryKey(resultState);
        return "操作成功";
    }

    public boolean isChecked(Integer rid) {
        ResultStateExample resultStateExample = new ResultStateExample();
        resultStateExample.createCriteria().andRidEqualTo(rid).andStateEqualTo(1);
        return resultStateMapper.selectByExample(resultStateExample).size() != 0;
    }

    public String checkResult(Integer rid, Integer mid, Integer status, String content, String username) {
        MessageState messageState = new MessageState();
        MessageProcess messageProcess = new MessageProcess();
        ResultState resultState = new ResultState();
        messageState.setMid(mid);
        messageProcess.setMid(mid);
        messageProcess.setType(3);
        messageProcess.setUsername(username);
        messageProcess.setContent(content);
        resultState.setContent(content);
        resultState.setRid(rid);
        if (status == -1) {
            messageState.setStatus(2);
            messageProcess.setState(0);
            resultState.setState(-1);
        } else {
            messageState.setStatus(3);
            messageProcess.setState(1);
            resultState.setState(1);
        }
        messageStateMapper.updateByPrimaryKey(messageState);
        ResultStateExample example = new ResultStateExample();
        example.createCriteria().andRidEqualTo(resultState.getRid());
        resultStateMapper.updateByExampleWithBLOBs(resultState, example);
        messageProcessMapper.insert(messageProcess);
        return "操作成功";
    }

    private List<Result> getResults(ResultStateExample resultStateExample) {
        List<ResultState> resultStates = resultStateMapper.selectByExample(resultStateExample);
        if (resultStates.size() == 0) {
            return new ArrayList<>();
        }
        List<Integer> rids = new ArrayList<>();
        for (ResultState state : resultStates) {
            rids.add(state.getRid());
        }
        ResultExample resultExample = new ResultExample();
        resultExample.createCriteria().andRidIn(rids);
        return resultMapper.selectByExampleWithBLOBs(resultExample);
    }

    public List<ResultController.DeniedResultWithAdvice> getAllDeniedResultWithAdvice() {
        List<Result> results = getAllDeniedResult();
        if (results.size() == 0) {
            return new ArrayList<>();
        }
        List<ResultController.DeniedResultWithAdvice> list = new ArrayList<>();
        for (Result result : results) {
            ResultStateExample example = new ResultStateExample();
            example.createCriteria().andRidEqualTo(result.getRid());
            String advice = resultStateMapper.selectByExampleWithBLOBs(example).get(0).getContent();
            ResultController.DeniedResultWithAdvice deniedResultWithAdvice = new ResultController.DeniedResultWithAdvice();
            deniedResultWithAdvice.setAdvice(advice);
            deniedResultWithAdvice.setResult(result);
            list.add(deniedResultWithAdvice);
        }
        return list;
    }


}
