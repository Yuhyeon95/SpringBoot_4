package com.iu.sb4.member;

import java.util.List;


import lombok.Data;

@Data
public class MemberVO {

	private String id;
	private String pw;
	private String name;
	private int age;
	private String email;
	//여러 개의 MemberRole 담기
	private List<MemberRoleVO> roles;
}
