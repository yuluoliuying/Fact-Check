package com.factcheck.server.mapper;

import com.factcheck.server.model.MessageProcess;
import com.factcheck.server.model.MessageProcessExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MessageProcessMapper {
    long countByExample(MessageProcessExample example);

    int deleteByExample(MessageProcessExample example);

    int deleteByPrimaryKey(Integer processNum);

    int insert(MessageProcess record);

    int insertSelective(MessageProcess record);

    List<MessageProcess> selectByExampleWithBLOBs(MessageProcessExample example);

    List<MessageProcess> selectByExample(MessageProcessExample example);

    MessageProcess selectByPrimaryKey(Integer processNum);

    int updateByExampleSelective(@Param("record") MessageProcess record, @Param("example") MessageProcessExample example);

    int updateByExampleWithBLOBs(@Param("record") MessageProcess record, @Param("example") MessageProcessExample example);

    int updateByExample(@Param("record") MessageProcess record, @Param("example") MessageProcessExample example);

    int updateByPrimaryKeySelective(MessageProcess record);

    int updateByPrimaryKeyWithBLOBs(MessageProcess record);

    int updateByPrimaryKey(MessageProcess record);
}