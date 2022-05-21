package com.madefu.spd1.mybatis.generator.mapper.test_v0;

import com.madefu.spd1.mybatis.generator.persistobj.Tuseraccountdetailpo;
import com.madefu.spd1.mybatis.generator.persistobj.TuseraccountdetailpoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TuseraccountdetailpoMapper {
    long countByExample(TuseraccountdetailpoExample example);

    int insert(Tuseraccountdetailpo record);

    int insertSelective(Tuseraccountdetailpo record);

    List<Tuseraccountdetailpo> selectByExample(TuseraccountdetailpoExample example);

    Tuseraccountdetailpo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Tuseraccountdetailpo record, @Param("example") TuseraccountdetailpoExample example);

    int updateByExample(@Param("record") Tuseraccountdetailpo record, @Param("example") TuseraccountdetailpoExample example);

    int updateByPrimaryKeySelective(Tuseraccountdetailpo record);

    int updateByPrimaryKey(Tuseraccountdetailpo record);
}