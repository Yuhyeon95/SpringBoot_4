package com.iu.sb4.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.iu.sb4.member.MemberVO;

@Component
public class NoticeMemberInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		MemberVO memberVO = (MemberVO) request.getSession().getAttribute("member");
		
		
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

	
}
