package egovframework.example.sevtest.qa;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
@Service("qaService")
public class qaServiceImpl extends EgovAbstractServiceImpl implements qaService {
	@Resource(name="qaDAO")
	qaDAO qaDAO;
	
	@Override
	public List<QAVO> qaList(QAVO vo) throws Exception {
		// TODO Auto-generated method stub
		return qaDAO.qaList(vo);
	}
	public boolean qaInsert(QAVO vo)throws Exception{
		return qaDAO.qaInsert(vo);
	}
	public QAVO qaSelect(QAVO vo)throws Exception{
		return qaDAO.qaSelect(vo);
	}
	public boolean qaUpdate(QAVO vo)throws Exception{
		return qaDAO.qaUpdate(vo);
	}
	public boolean qaDelete(QAVO vo)throws Exception{
		return qaDAO.qaDelete(vo);
	}
	//답변 
	public List<QA_ANSWERVO> answerList(QA_ANSWERVO anvo)throws Exception{
		return qaDAO.answerList(anvo);
	}
	public boolean answerInsert(QA_ANSWERVO anvo)throws Exception{
		return qaDAO.answerInsert(anvo);
	}
	//답변등록시 답변유무 N->Y 로  UPDATE
	public void qaAnswerUpdate(QAVO vo)throws Exception{
		qaDAO.qaAnswerUpdate(vo);
	}
	public void answerDelete(QAVO vo)throws Exception{
		 qaDAO.answerDelete(vo);
	}
}
