package com.iu.sb4.member;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.websocket.Session;

import org.apache.coyote.http11.Http11AprProtocol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/**")
public class MemberController {

	@Autowired
	private MemberService memberService;

	@ModelAttribute(name="member")
	public String getMember() {
		return "member";
	}
	
	@GetMapping("memberJoin")
	public String setMemberJoin(MemberVO memberVO) throws Exception{
		return "member/memberJoin";
	}
	
	@PostMapping("memberJoin")
	public ModelAndView setMemberJoin(@Valid MemberVO memberVO, BindingResult bindingResult, MultipartFile [] files) throws Exception{
		ModelAndView mv = new ModelAndView();
		if(bindingResult.hasErrors()) {
			mv.setViewName("member/memberJoin");	
		}
		//검증이 통과일 때 실행하는 코드 작성
		
		return mv;
	}
	
	@GetMapping("memberLogin")
	public void getMemberLogin(MemberVO memberVO) throws Exception {
		
	}
	
	@PostMapping("memberLogin")
	public ModelAndView getMemberLogin(MemberVO memberVO, HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		memberVO = memberService.getMemberLogin(memberVO);
		
		if(memberVO != null) {
			session.setAttribute("member", memberVO);
			mv.setViewName("redirect:../");
		}else {
			String message = "Login Fail";
			mv.addObject("msg", message);
			mv.addObject("path", "./memberLogin");
			mv.setViewName("common/result");
		}
		
		return mv;
	}
	
	
	
	@GetMapping("memberLogout")
	public String getmemberLogout(HttpSession session) throws Exception{
		session.invalidate();
		return "redirect:../";
	}

	@GetMapping("memberPage")
	public void getMemberPage() throws Exception {
		
	}
}
