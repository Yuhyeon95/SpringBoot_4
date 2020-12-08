package com.iu.sb4.board.notice;

import java.util.List;

import com.iu.sb4.board.BoardVO;
import com.iu.sb4.board.file.FileVO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class NoticeVO extends BoardVO{

	//파일들을 담을 수 있게 추가
	//만약 모든 Board에 들어간다면 BoardVO 에 추가
	private List<FileVO> files;
}
