package com.madefu.spd1.controller;

import com.madefu.spd1.mybatis.generator.mapper.test_v0.TuseraccountpoMapper;
import com.madefu.spd1.mybatis.generator.persistobj.Tuseraccountpo;
import com.madefu.spd1.mybatis.generator.persistobj.TuseraccountpoExample;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/simple/")
public class SimpleController {

    final TuseraccountpoMapper userAccountMapper;



    @PostMapping("/insertUser")
    public @ResponseBody Tuseraccountpo insertUser(Tuseraccountpo user){
//        int id = userAccountMapper.insert(user);
        userAccountMapper.insertSelective(user);
        return user;
    }

    @RequestMapping("/add")
    public String add(String name){

        return "hello,"+name;
    }

    @RequestMapping("/selectAllUser")
    public List<Tuseraccountpo> selectUser(){
        return userAccountMapper.selectByExample(new TuseraccountpoExample());
    }

}
