package com.aaa.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity //启动安全框架
@EnableGlobalMethodSecurity(prePostEnabled = true)//开启注解级别方法权限控制
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    //重写config方法
   /* @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder().encode("admin")).roles("admin");
        auth.inMemoryAuthentication().withUser("wxp").password(passwordEncoder().encode("admin")).roles("wxp");
    }*/

    //设置拦截除了登录界面其他任何请求都需要验证
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers().frameOptions().disable();
        http.authorizeRequests()
                .antMatchers("/userLogin").permitAll() //放行跳转到登录界面
                .anyRequest().fullyAuthenticated()
                .and()
                .formLogin().loginPage("/userLogin").defaultSuccessUrl("/index")
                .and()
                .csrf().disable();//必须加
    }

    //静态请求要放行
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/webjars/**").antMatchers("/static/**");
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
