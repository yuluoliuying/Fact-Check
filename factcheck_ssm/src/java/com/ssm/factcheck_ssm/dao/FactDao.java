package com.ssm.factcheck_ssm.dao;

import com.ssm.factcheck_ssm.entity.Fact;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FactDao {
    List<Fact> listAll();
}