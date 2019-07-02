package com.funtl.oauth2.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 创建一个类继承 WebSecurityConfigurerAdapter 并添加相关注解：
 *
 * @Configuration
 * @EnableWebSecurity
 * @EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)：全局方法拦截
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true,jsr250Enabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    //java.lang.IllegalArgumentException: There is no PasswordEncoder mapped for the id "null"
    //对密码进行加密
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){

        return  new BCryptPasswordEncoder() ;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        PasswordEncoderFactories.createDelegatingPasswordEncoder();
        //        super.configure(auth);
        auth.inMemoryAuthentication().
                withUser("admin").password(passwordEncoder().encode("123456")).roles("ADMIN")
                .and()
                .withUser("user").password(passwordEncoder().encode("123456")).roles("USER");
    }
}