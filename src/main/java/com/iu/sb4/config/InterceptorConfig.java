package com.iu.sb4.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.iu.sb4.interceptor.CustomInterceptor;
import com.iu.sb4.interceptor.NoticeAdminInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer{

	@Autowired
	private CustomInterceptor customInterceptor;
	
	@Autowired
	private NoticeAdminInterceptor noticeAdminInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		//적용할 Interceptor 등록
		registry.addInterceptor(customInterceptor)
		
		//Interceptor 에서 사용할 URL 작성(method 체이닝)
		.addPathPatterns("/notice/**")
		//.addPathPatterns(patterns)
		
		//Interceptor에서 제외할 URL 작성
		.excludePathPatterns("/notice/noticeWrite");
		
		registry.addInterceptor(noticeAdminInterceptor)
		.addPathPatterns("/notice/noticeWrite")
		.addPathPatterns("/notice/noticeDelete");
		
		
		WebMvcConfigurer.super.addInterceptors(registry);
	}
}
