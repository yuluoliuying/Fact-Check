
package com.ssm.factcheck_ssm.service;

import com.ssm.factcheck_ssm.dao.FactDao;
import com.ssm.factcheck_ssm.entity.Fact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class factServiceTemp implements FactService {

//    使用 dao 中的接口
    @Autowired
    private FactDao factDao;

    @Override
    public List<Fact> listAll() {
        return factDao.listAll();
    }
}