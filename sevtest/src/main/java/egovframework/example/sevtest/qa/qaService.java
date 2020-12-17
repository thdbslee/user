package egovframework.example.sevtest.qa;

import java.util.List;

public interface qaService {

	 public List<QAVO> qaList(QAVO vo)throws Exception;
	 public boolean qaInsert(QAVO vo)throws Exception;
	 public QAVO qaSelect(QAVO vo)throws Exception;
	 public boolean qaUpdate(QAVO vo)throws Exception;
	 public boolean qaDelete(QAVO vo)throws Exception;
	 
	 //답변 
	 public List<QA_ANSWERVO> answerList(QA_ANSWERVO anvo)throws Exception; 
	 public boolean answerInsert(QA_ANSWERVO anvo)throws Exception;
	 public void qaAnswerUpdate(QAVO vo)throws Exception;
	 public void answerDelete(QAVO vo)throws Exception;
	 
}
