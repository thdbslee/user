package egovframework.example.sevtest.board;

import java.util.List;

public interface boardService {
	//게시판
	public List<boardVO> boardList(boardVO vo)throws Exception;
	public boardVO boardSelect(boardVO vo) throws Exception;
	public boolean boardInsert(boardVO vo)throws Exception;
	public boolean boardDelete(boardVO vo)throws Exception;
	public void boardComDelete(boardVO vo)throws Exception; //게시물삭제시해당하는댓글같이삭제
	public boolean boardUpdate(boardVO vo)throws Exception;
	public void boardInfoUpdate(boardVO vo)throws Exception;
	
	//댓글
	public List<commentVO> commentList(commentVO cmvo)throws Exception;
	public boolean commentInsert(commentVO cmvo)throws Exception;
	public int commenTotCnt(commentVO cmvo)throws Exception;
	public boolean commentDelete(commentVO cmvo)throws Exception;
}
