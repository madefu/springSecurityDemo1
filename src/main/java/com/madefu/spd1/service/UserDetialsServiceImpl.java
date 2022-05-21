package com.madefu.spd1.service;

import com.madefu.spd1.mybatis.generator.mapper.test_v0.TuseraccountdetailpoMapper;
import com.madefu.spd1.mybatis.generator.mapper.test_v0.TuseraccountpoMapper;
import com.madefu.spd1.mybatis.generator.persistobj.Tuseraccountdetailpo;
import com.madefu.spd1.mybatis.generator.persistobj.Tuseraccountpo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@RequiredArgsConstructor
@Service("userDetailService")
public class UserDetialsServiceImpl implements UserDetailsService {


    private final PasswordEncoder pe;

    final TuseraccountpoMapper userAccountMapper;


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        List<GrantedAuthority> lst =  AuthorityUtils.commaSeparatedStringToAuthorityList("Admin,Seller");
        //TODO 实际中去查DB or Ldap
//        Tuseraccountpo user = new Tuseraccountpo();
//        user.setUserName("madefu");
        Tuseraccountpo user = userAccountMapper.selectOneByUserName(userName);
        if(user== null){
            throw new UsernameNotFoundException("user {"+userName+"} not found");
        }
        return new User(user.getUserName(),user.getPassword(),lst);
//        return new User("madefu", pe.encode("123456"),lst);
    }
}
