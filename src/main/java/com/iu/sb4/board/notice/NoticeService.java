package com.iu.sb4.board.notice;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.iu.sb4.board.BoardService;
import com.iu.sb4.board.BoardVO;
import com.iu.sb4.board.file.FileVO;
import com.iu.sb4.util.FileManager;
import com.iu.sb4.util.FilePathGenerator;
import com.iu.sb4.util.Pager;

@Service
@Transactional(rollbackFor = Exception.class)
public class NoticeService implements BoardService{

	@Autowired
	private NoticeMapper noticeMapper;
	
	@Autowired
	private FilePathGenerator filePathGenerator;
	
	@Autowired
	private FileManager fileManager;
	
	@Value("${board.notice.filePath}")
	private String filePath;
	
	@Override
	public List<BoardVO> getList(Pager pager) throws Exception {
		pager.makeRow();
		long totalCount = noticeMapper.getCount(pager);
		pager.makePage(totalCount);
		return noticeMapper.getList(pager);
	}
	
	@Override
	public int setInsert(BoardVO boardVO, MultipartFile [] files) throws Exception {
		//insert를 해야 num값을 가져옴
		int result = noticeMapper.setInsert(boardVO);
		
		System.out.println("Num: " + boardVO.getNum());
		//1. HDD에 File저장
		//저장할 폴더의 실제 경로명 필요
		//String filePath = "upload/notice"; -> value로 값가져옴(application.properties에서 설정)
		File file = filePathGenerator.getUserResourceLoader(this.filePath);
		System.out.println(file.getAbsolutePath());
		
		for(MultipartFile multipartFile : files) {
			if(multipartFile.getSize()==0) {
				continue;
			}
			String fileName = fileManager.saveFileCopy(multipartFile, file);
			System.out.println(fileName);
			FileVO fileVO = new FileVO();
			fileVO.setFileName(fileName);
			fileVO.setOriName(multipartFile.getOriginalFilename());
			fileVO.setNum(boardVO.getNum());
			//에러발생
			//fileVO.setNum(2000);
			//하드디스크랑 데이터베이스 둘다 들어감
			result = noticeMapper.setInsertFile(fileVO);
		}
	
		return result;
		
	}

	@Override
	public int setUpdate(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setDelete(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BoardVO getOne(BoardVO boardVO) throws Exception {
		return noticeMapper.getOne(boardVO);
	}

	@Override
	public FileVO getFile(FileVO fileVO) throws Exception {
		return noticeMapper.getFile(fileVO);
	}



}
