package com.factcheck.server.mapper;

import com.factcheck.server.model.Result;
import com.factcheck.server.model.ResultExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResultMapper {
    long countByExample(ResultExample example);

    int deleteByExample(ResultExample example);

    int deleteByPrimaryKey(Integer rid);

    int insert(Result record);

    int insertSelective(Result record);

    List<Result> selectByExampleWithBLOBs(ResultExample example);

    List<Result> selectByExample(ResultExample example);

    Result selectByPrimaryKey(Integer rid);

    int updateByExampleSelective(@Param("record") Result record, @Param("example") ResultExample example);

    int updateByExampleWithBLOBs(@Param("record") Result record, @Param("example") ResultExample example);

    int updateByExample(@Param("record") Result record, @Param("example") ResultExample example);

    int updateByPrimaryKeySelective(Result record);

    int updateByPrimaryKeyWithBLOBs(Result record);

    int updateByPrimaryKey(Result record);
}