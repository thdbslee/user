package egovframework.example.sevtest.totalwrite;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
@Repository("totalDAO")
public class totalDAO extends EgovAbstractDAO {

	public List<totalVO> totalWriteList(totalVO vo) throws Exception{
		System.out.println("totalDAO");
		return (List<totalVO>)list("totalDAO.totalWriteList",vo);
	}
	public totalVO totalSelect(totalVO vo) throws Exception{
		return (totalVO) select("totalDAO.totalSelect",vo);
	}
	public void totalDelete(totalVO vo) throws Exception {
		// TODO Auto-generated method stub
		delete("totalDAO.totalDelete",vo);
	}
	
}
