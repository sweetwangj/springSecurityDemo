package com.operation.qkwall.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private YcAnthencationProder provider;
	@Autowired
	AccessDeniedServletHandler accessDeniedServletHandler;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//允许访问静态资源
		http.authorizeRequests()
				.antMatchers("/css/**", "/js/**", "/images/**",
						"/resources/**")
				.permitAll();
		//所有的访问都需要权限验证
		http.authorizeRequests().anyRequest().authenticated();
		//访问失败页url
		http.formLogin().failureUrl("/login?error").
				//登录信息保存
						successHandler(loginSuccessHandler()).
				//访问成功页url
						defaultSuccessUrl("/login")
				//默认访问页
				.loginPage("/login")
				.permitAll().and().logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				//注销失败跳转到登录页面
				.logoutSuccessUrl("/login").permitAll()
				.and()
				.exceptionHandling().accessDeniedHandler(accessDeniedServletHandler);

		// 允许iframe 嵌套
		http.headers().frameOptions().disable();
		//关闭csrf 防止循环定向
		http.csrf().disable();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
		web.ignoring().antMatchers("/img/**");
	}


	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		//采用自定义验证
		auth.authenticationProvider(provider);
		//默认的认证方式
		//auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(4);
	}
	
	
	/**
	 * 用户或者管理员登录日志
	 */
	@Bean
	public LoginSuccessHandler loginSuccessHandler(){
		return new LoginSuccessHandler();
	}
	



}
