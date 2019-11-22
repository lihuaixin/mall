package com.xxx.mall.configs.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *@desc: 修改 安全策略
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

	/**
	 * 定义安全策略
	 * 括号中的地址是不需要登录权限
	 */
	@Override
	public void configure(WebSecurity web) throws Exception {
		//web.ignoring().antMatchers("/","/encrypt","/decrypt","/encrypt/status","/monitor","/refresh");

		//所有请求都无需验证
		web.ignoring().antMatchers("/**");
	}

}
