package com.iu.sb4.board;

import java.util.List;

import com.iu.sb4.board.file.FileVO;
import com.iu.sb4.util.Pager;

public interface BoardMapper {

	public long getCount(Pager pager) throws Exception;
	
	public int setInsert(BoardVO boardVO) throws Exception;
	
	public int setInsertFile(FileVO fileVO) throws Exception;
	
	public int setUpdate(BoardVO boardVO) throws Exception;
	
	public int setDelete(BoardVO boardVO) throws Exception;
	
	public BoardVO getOne(BoardVO boardVO) throws Exception;
	
	public List<BoardVO> getList(Pager pager) throws Exception;
	
	//FileVO fileVO(fnum 찾기)
	public FileVO getFile(FileVO fileVO) throws Exception;

}
