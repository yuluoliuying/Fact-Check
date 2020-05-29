package com.factcheck.server.service;

import com.factcheck.server.mapper.MessageProcessMapper;
import com.factcheck.server.mapper.MessageStateMapper;
import com.factcheck.server.mapper.ResultMapper;
import com.factcheck.server.model.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class ResultService {
    @Resource
    private ResultMapper resultMapper;
    @Resource
    private MessageProcessMapper messageProcessMapper;
    @Resource
    private MessageStateMapper messageStateMapper;

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
        messageStateMapper.updateByPrimaryKey(messageState);
        messageProcessMapper.insert(messageProcess);
        return "操作成功";
    }


    public List<Result> getRandomResult(Integer index) {
        ResultExample resultExample = new ResultExample();
        int sum = resultMapper.selectByExample(resultExample).size();
        if (sum <= index) {
            return resultMapper.selectByExample(resultExample);
        } else {
            Random random = new Random();
            Set<Integer> set = new HashSet<>();
            while (set.size() != index) {
                int num = random.nextInt(sum) + 1;
                set.add(num);
            }
            resultExample.createCriteria().andRidIn(new ArrayList<>(set));
            return resultMapper.selectByExample(resultExample);
        }
    }

    public List<Result> getRecentResult(Integer index) {
        ResultExample resultExample = new ResultExample();
        int sum = resultMapper.selectByExample(resultExample).size();
        if (sum <= index) {
            return resultMapper.selectByExample(resultExample);
        } else {
            resultExample.setOrderByClause("releaseTime ASC");
            resultExample.createCriteria().andReleaseTimeLessThan(new Date());

            List<Result> origin = resultMapper.selectByExample(resultExample);
            List<Result> results = new ArrayList<>();
            for (int i = 0; i < index; i++) {
                results.add(origin.get(i));
            }
            return results;
        }
    }

    public Result selectResultById(Integer rid) {
        return resultMapper.selectByPrimaryKey(rid);
    }

    public String updateResult(Result record) {
        resultMapper.updateByPrimaryKey(record);
        return "操作成功";
    }

    public boolean isChecked(Integer rid) {
        MessageStateExample messageStateExample = new MessageStateExample();
        messageStateExample.createCriteria().andMidEqualTo(rid).andStatusEqualTo(3);
        return messageStateMapper.selectByExample(messageStateExample).size() != 0;
    }

    public String checkResult(Integer mid, Integer status, String content, String username) {
        MessageState messageState = new MessageState();
        MessageProcess messageProcess = new MessageProcess();
        messageState.setMid(mid);
        messageProcess.setMid(mid);
        messageProcess.setType(3);
        messageProcess.setUsername(username);
        messageProcess.setContent(content);
        if (status == -1) {
            messageState.setStatus(2);
            messageProcess.setState(0);
        } else {
            messageState.setStatus(3);
            messageProcess.setState(1);
        }
        messageStateMapper.updateByPrimaryKey(messageState);
        messageProcessMapper.insert(messageProcess);
        return "操作成功";
    }


}