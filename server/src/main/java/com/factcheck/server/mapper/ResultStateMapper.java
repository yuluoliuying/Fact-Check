package com.factcheck.server.mapper;

import com.factcheck.server.model.ResultState;
import com.factcheck.server.model.ResultStateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResultStateMapper {
    long countByExample(ResultStateExample example);

    int deleteByExample(ResultStateExample example);

    int deleteByPrimaryKey(Integer rid);

    int insert(ResultState record);

    int insertSelective(ResultState record);

    List<ResultState> selectByExampleWithBLOBs(ResultStateExample example);

    List<ResultState> selectByExample(ResultStateExample example);

    ResultState selectByPrimaryKey(Integer rid);

    int updateByExampleSelective(@Param("record") ResultState record, @Param("example") ResultStateExample example);

    int updateByExampleWithBLOBs(@Param("record") ResultState record, @Param("example") ResultStateExample example);

    int updateByExample(@Param("record") ResultState record, @Param("example") ResultStateExample example);

    int updateByPrimaryKeySelective(ResultState record);

    int updateByPrimaryKeyWithBLOBs(ResultState record);

    int updateByPrimaryKey(ResultState record);
}