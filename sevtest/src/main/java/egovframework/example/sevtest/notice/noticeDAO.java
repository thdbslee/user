package egovframework.example.sevtest.notice;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
@Repository("noticeDAO")
public class noticeDAO extends EgovAbstractDAO {

	public boolean noticeInsert(noticeVO vo) throws Exception {
		boolean bol = false;
		bol = update("noticeDAO.noticeInsert",vo) > 0 ? true: false;
		return bol ;
	}

	public List<noticeVO> noticeList(noticeVO vo)throws Exception {
		// TODO Auto-generated method stub
		return (List<noticeVO>) list("noticeDAO.noticeList",vo);
	}
	public noticeVO noticeSelect(noticeVO vo)throws Exception{
		return (noticeVO) select("noticeDAO.noticeSelect",vo);
	}
	public boolean noticeUpdate(noticeVO vo)throws Exception{
		boolean bol = false;
		bol = update("noticeDAO.noticeUpdate",vo) > 0 ? true : false;
		return bol;
	}
	public boolean noticeDelete(noticeVO vo)throws Exception{
		boolean bol = false;
		bol = update("noticeDAO.noticeDelete",vo) > 0 ? true : false ; 
		System.out.println("bol :" +bol);
		return bol;
	}

	public void noticeInfoCount(noticeVO vo) {
		update("noticeDAO.noticeInfoCount",vo);
	}
}
