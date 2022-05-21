package com.madefu.spd1.mybatis.generator.mapper.test_v0;

import com.madefu.spd1.mybatis.generator.persistobj.Tuseraccountpo;
import com.madefu.spd1.mybatis.generator.persistobj.TuseraccountpoExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

public interface TuseraccountpoMapper {
    long countByExample(TuseraccountpoExample example);

    int insert(Tuseraccountpo record);

    int insertSelective(Tuseraccountpo record);

    List<Tuseraccountpo> selectByExample(TuseraccountpoExample example);

    Tuseraccountpo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Tuseraccountpo record, @Param("example") TuseraccountpoExample example);

    int updateByExample(@Param("record") Tuseraccountpo record, @Param("example") TuseraccountpoExample example);

    int updateByPrimaryKeySelective(Tuseraccountpo record);

    int updateByPrimaryKey(Tuseraccountpo record);

    Tuseraccountpo selectOneByUserName(@Param("userName") String userName);
}