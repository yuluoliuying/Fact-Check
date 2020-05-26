package com.factcheck.server.mapper;

import com.factcheck.server.model.MessageState;
import com.factcheck.server.model.MessageStateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MessageStateMapper {
    long countByExample(MessageStateExample example);

    int deleteByExample(MessageStateExample example);

    int deleteByPrimaryKey(@Param("mid") Integer mid, @Param("status") Integer status);

    int insert(MessageState record);

    int insertSelective(MessageState record);

    List<MessageState> selectByExample(MessageStateExample example);

    MessageState selectByPrimaryKey(@Param("mid") Integer mid, @Param("status") Integer status);

    int updateByExampleSelective(@Param("record") MessageState record, @Param("example") MessageStateExample example);

    int updateByExample(@Param("record") MessageState record, @Param("example") MessageStateExample example);

    int updateByPrimaryKeySelective(MessageState record);

    int updateByPrimaryKey(MessageState record);
}