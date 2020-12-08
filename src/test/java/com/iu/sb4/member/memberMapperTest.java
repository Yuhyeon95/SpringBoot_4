package com.iu.sb4.member;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional(rollbackFor = Exception.class) // Test할때는 성공해도 실제 데이터가 변경되지 않음(Rollback함)
@Rollback(value = true)
class memberMapperTest {
	
	@Autowired
	private MemberMapper memberMapper;

	@Test
	void setInsertTest() throws Exception {
		for(int i=2;i<=20;i++) {
			MemberVO memberVO = new MemberVO();
			memberVO.setId("id" + i);
			memberVO.setPw("pw"+ i);
			memberVO.setName("name" + i);
			memberVO.setAge(i);
			memberVO.setEmail("email" + i + "@naver.com");
			int result = memberMapper.setInsert(memberVO);
			
			if(i%10==0) {
				Thread.sleep(1000);
				}
		}
	}
	
	@Test
	void setInsertFileTest() throws Exception {
		MemberFileVO memberFileVO = new MemberFileVO();
		memberFileVO.setId("id1");
		memberFileVO.setFileName("fileName");
		memberFileVO.setOriName("oriName");
		int result = memberMapper.setInsertFile(memberFileVO);
		
		assertEquals(1, result);
		}
	
	
}
