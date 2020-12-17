package egovframework.example.sevtest.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.example.sevtest.sevVO;
import egovframework.example.sevtest.service.sevService;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
@Service("sevService")
public class sevServiceImpl extends EgovAbstractServiceImpl implements sevService {
	@Resource(name="sevDAO")
	private sevDAO sevDAO;
	//로그인
	@Override
	public sevVO UserLogin(sevVO vo) throws Exception {
		// 아이디비번확인
		return sevDAO.UserLogin(vo);
	}
	@Override
	public void LoginDate(sevVO vo)throws Exception{
		sevDAO.LoginDate(vo);
	}
	@Override
	public sevVO userFailInfo(sevVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sevDAO.userFailInfo(vo);
	}

	@Override
	public void UserFailCountUpdate(sevVO vo) throws Exception {
		// TODO Auto-generated method stub
		sevDAO.UserFailCountUpdate(vo);
	}

	@Override
	public void UserLock(sevVO vo) throws Exception {
		// TODO Auto-generated method stub
		sevDAO.UserLock(vo);
	}
	//회원가입
	@Override
	public int idcount(sevVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sevDAO.idcount(vo);
	}
	@Override
	public boolean joinInsert(sevVO vo)throws Exception{
		return sevDAO.joinInsert(vo);
	}
	//현재비밀번호맞나확인
	@Override
	public int passcount(sevVO vo)throws Exception{
		return sevDAO.passcount(vo);
	}
	@Override
	public void updatePasswd(sevVO vo)throws Exception{
		sevDAO.updatePasswd(vo);
	}
	//사용자관리
	@Override
	public List<sevVO> sevList(sevVO vo) throws Exception {
		
		return sevDAO.sevList(vo);
	}

	@Override
	public boolean sevInsrert(sevVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sevDAO.sevInsert(vo);
	}
	public sevVO sevSelect(sevVO vo)throws Exception{
		return sevDAO.sevSelect(vo);
	}
	
	public boolean sevUpdate(sevVO vo)throws Exception{
		return sevDAO.sevUpdate(vo);
	}
	@Override
	public boolean sevDelete(sevVO vo)throws Exception{
		return sevDAO.sevDelete(vo);
	}
	//개인정보변경
	@Override
	public boolean userSettingUpdate(sevVO vo)throws Exception{
		return sevDAO.userSettingUpdate(vo);
	}
	//등업게시판 등록시 count 증가
	public void sevUpdateLev(sevVO sevvo)throws Exception{
		sevDAO.sevUpdateLev(sevvo);
	}
	//등록건수,id불러오기
	public sevVO sevLevList(sevVO sevvo)throws Exception{
		return sevDAO.sevLevList(sevvo);
	}
	//level guest->staff upgrade시키기 
	public void sevLevelUpgrade(sevVO sevvo)throws Exception{
		sevDAO.sevLevelUpgrade(sevvo);
	}
}
