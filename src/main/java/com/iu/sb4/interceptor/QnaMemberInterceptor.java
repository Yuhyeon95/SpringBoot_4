package com.iu.sb4.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.iu.sb4.board.qna.QnaMapper;
import com.iu.sb4.member.MemberVO;

@Component
public class QnaMemberInterceptor implements HandlerInterceptor{
	
	@Autowired
	private QnaMapper qnaMapper;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		MemberVO memberVO = (MemberVO) request.getSession().getAttribute("member");
		
		boolean result = false;
		
		String path = request.getRequestURI();
		System.out.println("Path : " +path);
		
		if(memberVO != null) {
			result = true;
		}
		
		if(!result) {
			request.setAttribute("msg", "권한이 필요");
			request.setAttribute("path", "../");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp");
			view.forward(request, response);
		}
		
		return result;
	}

}
