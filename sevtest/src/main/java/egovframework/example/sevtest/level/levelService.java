package egovframework.example.sevtest.level;

import java.util.List;

import egovframework.example.sevtest.sevVO;

public interface levelService {
	public List<levelVO> levelList(levelVO vo)throws Exception;
	public boolean levelInsert(levelVO vo) throws Exception;
	public levelVO levelSelect(levelVO vo)throws Exception; //수정.상세보기 
	public boolean levelUpdate(levelVO vo)throws Exception;
	public boolean levelDelete(levelVO vo)throws Exception;
	
}
