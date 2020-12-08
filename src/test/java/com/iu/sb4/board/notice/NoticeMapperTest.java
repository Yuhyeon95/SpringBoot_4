package com.iu.sb4.board.notice;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.iu.sb4.board.BoardVO;
import com.iu.sb4.util.Pager;

@SpringBootTest
class NoticeMapperTest {

	@Autowired
	private NoticeMapper noticeMapper;
	
	//@Test
	void getList() throws Exception {
		Pager pager = new Pager();
		pager.setPerPage(5);
		pager.setCurPage(1);
		pager.makeRow();
		pager.setKind("title");
		pager.setSearch("1");
		List<BoardVO> ar = noticeMapper.getList(pager);
		//assertEquals(10, ar.size());
	}
	
	//@Test
	void getOneTest() throws Exception {
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setNum(2);
		
		BoardVO boardVO = noticeMapper.getOne(noticeVO);
		
		assertNotNull(boardVO);
	}
	
	@Test
	void setDeleteTest() throws Exception {
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setNum(9);
		int result = noticeMapper.setDelete(noticeVO);
		assertNotEquals(0, result);
	}
	
	//@Test
	void setUpdateTest() throws Exception {
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setTitle("t3");
		noticeVO.setWriter("w3");
		noticeVO.setContents("c3");
		noticeVO.setNum(3);
		int result = noticeMapper.setUpdate(noticeVO);
		assertNotEquals(0, result);
	}
	
	//@Test
	void setInsertTest() throws Exception{
		for(int i =0;i<100;i++) {
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setTitle("t" + i);
		noticeVO.setWriter("w" + i);
		noticeVO.setContents("c" + i);

		int result = noticeMapper.setInsert(noticeVO);
		
		
		if(i%10==0) {
			Thread.sleep(1000);
			}
		}
	}
	

}
