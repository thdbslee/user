package egovframework.example.sevtest.totalwrite;

import java.util.List;

public interface totalService {

	public List<totalVO> totalWriteList(totalVO vo) throws Exception;
	
	public totalVO totalSelect(totalVO vo)throws Exception;
	
	public void totalDelete(totalVO vo)throws Exception;

}
