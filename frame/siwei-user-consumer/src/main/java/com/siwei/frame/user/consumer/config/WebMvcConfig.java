package com.siwei.frame.user.consumer.config;

import com.siwei.frame.user.consumer.intercepter.TokenIntecepter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author linxiunan
 * @Description 拦截器配置文件
 * @date 2018年9月11日
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(tokenIntecepter()).addPathPatterns("/**").addPathPatterns("/**/**");
	}
	
	@Bean
	public TokenIntecepter tokenIntecepter() {
		return new TokenIntecepter();
	}

}
