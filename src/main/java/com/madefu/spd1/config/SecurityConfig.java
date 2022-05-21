package com.madefu.spd1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder pw;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

//        String pwd  = pw.encode("123");
        //使用配置类的方式
//        auth.inMemoryAuthentication().withUser("Admin").password(pwd).roles(new String[]{"Admin","Seller"});
        //使用实现类的方式
        auth.userDetailsService(userDetailService).passwordEncoder(pw);
    }

    /**
     * 不加这个类，会报
     * java.lang.IllegalArgumentException: There is no PasswordEncoder mapped for the id "null"
     * 因为系统会去寻找PasswordEncoder，这个类是必须要指定的
     */
    @Bean
    public static PasswordEncoder password(){
        return new BCryptPasswordEncoder();
    }

    private UserDetailsService userDetailService;

    @Autowired
    public void setUserDetailService(UserDetailsService us){
        this.userDetailService=us;
    }

}
