package com.ssm.factcheck_ssm.service;

import com.ssm.factcheck_ssm.entity.Fact;

import java.util.List;

public interface FactService {
    List<Fact> listAll();
}