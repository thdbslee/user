package egovframework.example.sevtest.board;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
@Repository("boardDAO")
public class boardDAO extends EgovAbstractDAO{

	public List<boardVO> boardList(boardVO vo) throws Exception {
		
		return (List<boardVO>) list("boardDAO.boardList",vo);
	}

	public boardVO boardSelect(boardVO vo) throws Exception {
		// TODO Auto-generated method stub
		return (boardVO)select("boardDAO.boardSelect",vo);
	}
	public boolean boardInsert(boardVO vo)throws Exception {
		boolean bol = false;
		bol =update("boardDAO.boardInsert",vo)>0 ? true: false;
		System.out.println("boardInsertDAO->"+bol);
		return bol;
	}
	public boolean boardDelete(boardVO vo)throws Exception{
		boolean bol = false;
		bol = update("boardDAO.boardDelete",vo)>0?true:false;
		return bol;
	}
	public void boardComDelete(boardVO vo)throws Exception{
		delete("boardDAO.boardComDelete",vo);
	}
	public boolean boardUpdate(boardVO vo)throws Exception{
		boolean bol = false;
		bol = update("boardDAO.boardUpdate",vo)>0 ? true : false;
		return bol;
	}
	public void boardInfoUpdate(boardVO vo)throws Exception{
		update("boardDAO.boardInfoUpdate",vo);
	}
	//댓글
	public List<commentVO> commentList(commentVO cmvo) throws Exception {
		return (List<commentVO>) list ("boardDAO.commentList",cmvo) ;
	}
	public boolean commentInsert(commentVO cmvo)throws Exception{
		boolean bol = false;
		bol = update("boardDAO.commentInsert",cmvo) > 0 ? true : false;
		return bol;
	}
	public int commenTotCnt(commentVO cmvo)throws Exception{
		return (int) select("boardDAO.commenTotCnt",cmvo);
	}
	public boolean commentDelete(commentVO cmvo)throws Exception{
		boolean bol = false;
		bol = update("boardDAO.commentDelete",cmvo) > 0 ? true : false;
		System.out.println("DeleteDAO->"+bol);
		return bol;
	}
}
