package com.factcheck.server.mapper;

import com.factcheck.server.model.MessageLog;
import com.factcheck.server.model.MessageLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MessageLogMapper {
    long countByExample(MessageLogExample example);

    int deleteByExample(MessageLogExample example);

    int deleteByPrimaryKey(Integer lid);

    int insert(MessageLog record);

    int insertSelective(MessageLog record);

    List<MessageLog> selectByExampleWithBLOBs(MessageLogExample example);

    List<MessageLog> selectByExample(MessageLogExample example);

    MessageLog selectByPrimaryKey(Integer lid);

    int updateByExampleSelective(@Param("record") MessageLog record, @Param("example") MessageLogExample example);

    int updateByExampleWithBLOBs(@Param("record") MessageLog record, @Param("example") MessageLogExample example);

    int updateByExample(@Param("record") MessageLog record, @Param("example") MessageLogExample example);

    int updateByPrimaryKeySelective(MessageLog record);

    int updateByPrimaryKeyWithBLOBs(MessageLog record);

    int updateByPrimaryKey(MessageLog record);
}