package com.madefu.spd1.service;

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

@Service("userDetailService")
public class UserDetialsServiceImpl implements UserDetailsService {


    private PasswordEncoder pe;

    /**
     * 依赖setter和构造函数的注入可以省去Autowired
     * @param pe
     */
    @Autowired
    private void setPasswordEncoder(PasswordEncoder password){
        this.pe=password;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        List<GrantedAuthority> lst =  AuthorityUtils.commaSeparatedStringToAuthorityList("Admin,Seller");
        //TODO 实际中去查DB or Ldap
        return new User("madefu", pe.encode("123456"),lst);
    }
}
