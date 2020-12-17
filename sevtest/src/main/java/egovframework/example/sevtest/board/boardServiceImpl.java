package egovframework.example.sevtest.board;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
@Service("boardService")
public class boardServiceImpl extends EgovAbstractServiceImpl implements boardService {
	@Resource(name="boardDAO")
	boardDAO boardDAO;
	//게시판
	@Override
	public List<boardVO> boardList(boardVO vo) throws Exception {	
		return boardDAO.boardList(vo);
	}
	@Override
	public boardVO boardSelect(boardVO vo)throws Exception{
		return boardDAO.boardSelect(vo);
	}
	@Override
	public boolean boardInsert(boardVO vo) throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.boardInsert(vo);
	}
	@Override
	public boolean boardDelete(boardVO vo)throws Exception{
		return boardDAO.boardDelete(vo);
	}
	@Override
	public void boardComDelete(boardVO vo)throws Exception{
		boardDAO.boardComDelete(vo);
	}
	@Override
	public boolean boardUpdate(boardVO vo)throws Exception{
		return boardDAO.boardUpdate(vo);
	}
	@Override
	public void boardInfoUpdate(boardVO vo)throws Exception{
		boardDAO.boardInfoUpdate(vo);
	}

	//댓글
	@Override
	public List<commentVO> commentList(commentVO cmvo)throws Exception{
		return boardDAO.commentList(cmvo);
	}
	@Override
	public boolean commentInsert(commentVO cmvo)throws Exception{
		return boardDAO.commentInsert(cmvo);
	}
	@Override
	public int commenTotCnt(commentVO cmvo)throws Exception{
		return boardDAO.commenTotCnt(cmvo);
	}
	@Override
	public boolean commentDelete(commentVO cmvo)throws Exception{
		System.out.println("DeleteService");
		return boardDAO.commentDelete(cmvo);
	}
}
