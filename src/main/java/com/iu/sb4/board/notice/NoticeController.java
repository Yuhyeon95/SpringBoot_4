package com.iu.sb4.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.sb4.board.BoardVO;
import com.iu.sb4.board.file.FileVO;
import com.iu.sb4.util.Pager;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	//파일경로 보내기 application.properties에 설정
	@Value("${board.notice.filePath}")
	private String filePath;
	
	//model.addAttribute("board", "notice")
	@ModelAttribute(name="board")
	public String getBoard() {
		return "notice";
	}
	
	@GetMapping("noticeFileDown")
	public ModelAndView getNoticeFileDown(FileVO fileVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		//저장된 파일명이 무엇인지 보내줘야 함 (fnum을 가지고 파일명이 무엇인지 조회해야함)
		//파일의 정보를 담고있는 객체
		fileVO = noticeService.getFile(fileVO);
		//파일을 찾아서 스트림 걸어야함 
		
		//파일정보를 담고있는 객체를 보내기
		mv.addObject("fileVO", fileVO);
		
		//파일경로 보내기 (직접작성 해도 됨) application.properties 있는거 가져오기(위에 넣어놓음)
		//mv.addObject("filePath", "upload/notice");
		mv.addObject("filePath", filePath);
		
		mv.setViewName("fileDown");
		System.out.println(fileVO.getFileName());
		return mv;
	}
	
	
	@GetMapping("noticeList")
	public ModelAndView getList(Pager pager) throws Exception{
		ModelAndView mv = new ModelAndView();
		List<BoardVO> ar = noticeService.getList(pager);
		System.out.println(pager.getCurPage());
		System.out.println(pager.getStartRow());
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.setViewName("board/boardList");
		return mv;
	}
	
	@GetMapping("noticeSelect")
	public ModelAndView getOne(BoardVO boardVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		boardVO =noticeService.getOne(boardVO);
		
		mv.addObject("vo", boardVO);
		mv.setViewName("board/boardSelect");
		return mv;
	}
	
	@PostMapping("noticeWrite")
	public String setInsert(BoardVO boardVO, MultipartFile [] files) throws Exception {
		for(MultipartFile f : files) {
			System.out.println(f.getOriginalFilename());
		}
		int result = noticeService.setInsert(boardVO, files);
		return "redirect:./noticeList";
	}
	
	@GetMapping("noticeWrite")
	public String setInsert() throws Exception {
		return "board/boardWrite";
	}
	
	@GetMapping("noticeDelete")
	public ModelAndView setDelete(BoardVO boardVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = noticeService.setDelete(boardVO);
		if(result > 0) {
			mv.addObject("msg", "Notice Delete Success");
		}else {
			mv.addObject("msg", "Notice Delete Fail");
		}
		mv.addObject("path","./noticeList");
		mv.setViewName("common/result");
		return mv;
	}
	
	@GetMapping("noticeUpdate")
	public ModelAndView setUpdate(BoardVO boardVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		boardVO =noticeService.getOne(boardVO);
		mv.addObject("vo", boardVO);
		mv.setViewName("board/boardUpdate");
		return mv;
	}
	
	
	@PostMapping("noticeUpdate")
	public ModelAndView setUpdate(BoardVO boardVO, MultipartFile [] files) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = noticeService.setUpdate(boardVO);
		int temp = (int) boardVO.getNum();
		
		if(result > 0) {
			mv.addObject("msg","Notice Update Success");
			mv.addObject("path", "./noticeSelect?num=" + temp);
		}else {
			mv.addObject("msg", "Notice Update Fail");
			mv.addObject("path", "./noticeList");
		}
		mv.setViewName("common/result");
		return mv;
	}
}
