package com.funtl.oauth2.server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * 创建一个类继承 AuthorizationServerConfigurerAdapter 并添加相关注解：
 * @Configuration Configuration
 * @EnableAuthorizationServer EnableAuthorizationServer
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    @Autowired
    public BCryptPasswordEncoder passwordEncoder;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        super.configure(clients);
        // 配置客户端
        clients
                // 使用内存设置
                .inMemory()
                // client_id
                .withClient("client")
                // client_secret 需要加密
                .secret(passwordEncoder.encode("secret"))
                // 授权类型
                .authorizedGrantTypes("authorization_code")
                // 授权范围
                .scopes("app")
                // 注册回调地址
                .redirectUris("http://www.funtl.com");
    }
}
