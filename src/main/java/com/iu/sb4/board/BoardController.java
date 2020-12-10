package com.iu.sb4.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.iu.sb4.board.notice.NoticeService;
import com.iu.sb4.util.Pager;

//RestController : Controller + ResponseBody(각각 설정하지 않아도 자동으로 들어감)
@RestController
@RequestMapping("/board/**")
public class BoardController {
	
	@Autowired
	private NoticeService noticeService;

	@GetMapping("boardSelect")
	public BoardVO boardSelect(BoardVO boardVO) throws Exception {
		System.out.println("Board Select Controller");
		boardVO = noticeService.getOne(boardVO);
		System.out.println("title : " + boardVO.getTitle());
		// {"키":"밸류", "키": "밸류" }
		//String result = "{";
		//result = result + "\"num\":" + boardVO.getNum() + "," ;
		//result = result + "\"title\":\"" + boardVO.getTitle() + "\"}";
		//writer, contents
		//String writer = "\"writer\":\"" + boardVO.getWriter() + "\"";
		//String contents = "\"contents\":\"" + boardVO.getContents() + "\"";
		//System.out.println(writer);
		//System.out.println(contents);
		//System.out.println(result);
		return boardVO;
	}
	
	@GetMapping("boardList")
	//@ResponseBody
	public List<BoardVO> boardList(Pager pager) throws Exception{
		System.out.println("Board List Controller");
		List<BoardVO> ar = noticeService.getList(pager);
		return ar;
	}
}
