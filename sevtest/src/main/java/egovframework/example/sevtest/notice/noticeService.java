package egovframework.example.sevtest.notice;

import java.util.List;

public interface noticeService {
	
	public boolean noticeInsert(noticeVO vo)throws Exception;

	public List<noticeVO> noticeList(noticeVO vo)throws Exception;

	public noticeVO noticeSelect(noticeVO vo) throws Exception;
	public void noticeInfoCount(noticeVO vo)throws Exception;
	
	public boolean noticeUpdate(noticeVO vo)throws Exception;
	public boolean noticeDelete(noticeVO vo)throws Exception;
}
