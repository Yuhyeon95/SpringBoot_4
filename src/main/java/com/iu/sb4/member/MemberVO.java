package com.iu.sb4.member;

import lombok.Data;

@Data
public class MemberVO {

	private String id;
	private String pw;
	private String name;
	private int age;
	private String email;
}