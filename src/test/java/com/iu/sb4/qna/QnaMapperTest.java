package com.iu.sb4.qna;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.iu.sb4.board.BoardVO;
import com.iu.sb4.board.qna.QnaMapper;
import com.iu.sb4.board.qna.QnaVO;
import com.iu.sb4.util.Pager;

@SpringBootTest
@Transactional(rollbackFor = Exception.class)
@Rollback(value = true)
class QnaMapperTest {

	@Autowired
	private QnaMapper qnaMapper;
	
	//@Test
	void setInsertTest() throws Exception {
		for(int i=1;i<25;i++) {
			QnaVO qnaVO = new QnaVO();
			qnaVO.setTitle("t" + i);
			qnaVO.setWriter("w" + i);
			qnaVO.setContents("c" + i);
			qnaMapper.setInsert(qnaVO);
			
			if(i%10==0) {
				Thread.sleep(1000);
			}
		}
	}
	
	//@Test
	void qnaListTest() throws Exception {
		Pager pager = new Pager();
		pager.makeRow();
		long totalCount = qnaMapper.getCount(pager);
		pager.makePage(totalCount);
		pager.setCurPage(1);
		List<BoardVO> ar = qnaMapper.getList(pager);
		
		assertEquals(10, ar.size());
	}
	
	@Test
	void setDeleteTest() throws Exception {
		BoardVO boardVO = new BoardVO();
		boardVO.setNum(24);
		int result = qnaMapper.setDelete(boardVO);
		assertNotEquals(0, result);
	}

}
