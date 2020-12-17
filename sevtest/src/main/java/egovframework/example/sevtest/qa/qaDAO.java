package egovframework.example.sevtest.qa;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
@Repository("qaDAO")
public class qaDAO extends EgovAbstractDAO {

	public List<QAVO> qaList(QAVO vo) throws Exception {
		return (List<QAVO>) list("qaDAO.qaList",vo);
	}
	public boolean qaInsert(QAVO vo)throws Exception{
		boolean bol = false;
		bol = update("qaDAO.qaInsert",vo) > 0 ? true : false;
		return bol;
	}
	public QAVO qaSelect(QAVO vo)throws Exception{
		return (QAVO) select ("qaDAO.qaSelect",vo);
	}
	public boolean qaUpdate(QAVO vo)throws Exception{
		boolean bol = false;
		bol = update("qaDAO.qaUpdate",vo) > 0 ? true : false;
		return bol;
	}
	public boolean qaDelete(QAVO vo) throws Exception{
		boolean bol = false;
		bol = update("qaDAO.qaDelete",vo) > 0 ? true : false;
		return bol;
	}
	//댓글 
	public List<QA_ANSWERVO> answerList(QA_ANSWERVO anvo)throws Exception{
		return (List<QA_ANSWERVO>) list ("qaDAO.answerList",anvo);
	}

	public boolean answerInsert(QA_ANSWERVO anvo)throws Exception {
		boolean bol = false;
		bol = update("qaDAO.answerInsert", anvo) > 0 ? true : false ; 
		return bol;
	}
	public void qaAnswerUpdate(QAVO vo)throws Exception{
		update("qaDAO.qaAnswerUpdate",vo);
	}
	public void answerDelete(QAVO vo)throws Exception{
		delete("qaDAO.answerDelete",vo);
	}
}
