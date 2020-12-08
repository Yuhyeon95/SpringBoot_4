package com.iu.sb4.board.qna;

import com.iu.sb4.board.BoardVO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class QnaVO extends BoardVO{
	
	private long ref;
	private long step;
	private long depth;
}
