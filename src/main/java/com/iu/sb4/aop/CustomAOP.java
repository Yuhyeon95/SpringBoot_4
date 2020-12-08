package com.iu.sb4.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CustomAOP {

	//com.iu.sb4.board.notice 모든Service 매개변수가 상관이 없는 get method들
	@Before("execution(* com.iu.sb4.board.notice.*Service.get*(..))")
	public void noticeBefore() throws Exception {
		System.out.println("Point cut 실행 전 ----------------------------");
	}
	
	//noticeAfter
	//NoticeService get으로 시작하는 모든 메서드를 실행 후 작동하는 advice 메서드 생성
	@After("execution(* com.iu.sb4.board.notice.NoticeService.get*(..))")
	public void noticeAfter() throws Exception {
		System.out.println("Point cut 실행 후-----------------------------");
	}
	
	//noticeAround
	//NoticeService set으로 시작하는 모든 메서드 들이 실행 전후 advice
	@Around("execution(* com.iu.sb4.board..*Service.set*(..))")
	public Object noticeAround(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("Point cut 실행 전");
		Object obj = null;
		obj = joinPoint.proceed();//point cut 실행
		
		System.out.println("point cut 실행 후");
		return obj;
	}
}
