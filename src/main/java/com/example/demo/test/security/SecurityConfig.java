package com.example.demo.test.security;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    // 密码明文加密方式配置
//    @Bean
//    public PasswordEncoder myEncoder() {
//        return new BCryptPasswordEncoder();
//    }

    // 认证用户时用户信息加载配置
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("admin").password(myEncoder().encode("12345")).roles("ADMIN")
//                .and()
//                .withUser("user").password(myEncoder().encode("12345")).roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 基于token，不需要csrf
        http.csrf().disable()
                // 基于token，不需要session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                // 下面开始设置权限
                .authorizeRequests()
                // 需要登录
                .antMatchers("/hello3").authenticated()
                // 除上面外的所有请求全部放开
                .anyRequest().permitAll();
    }
}
