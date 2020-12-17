package egovframework.example.sevtest.totalwrite;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
@Service("totalService")
public class totalServiceImpl extends EgovAbstractServiceImpl implements totalService{
	@Resource(name="totalDAO")
	totalDAO totalDAO;

	@Override
	public List<totalVO> totalWriteList(totalVO vo) throws Exception {
		System.out.println("totalServie");
		return totalDAO.totalWriteList(vo);
	}
	@Override
	public totalVO totalSelect(totalVO vo)throws Exception{
		return totalDAO.totalSelect(vo);
	}
	@Override
	public void totalDelete(totalVO vo) throws Exception {
		// TODO Auto-generated method stub
		totalDAO.totalDelete(vo);
	}
	
}
