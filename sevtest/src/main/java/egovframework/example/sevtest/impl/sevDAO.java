package egovframework.example.sevtest.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.example.sevtest.sevVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("sevDAO")
public class sevDAO  extends EgovAbstractDAO{
	//로그인
	public sevVO UserLogin(sevVO vo) throws Exception{
		// TODO Auto-generated method stub
		return (sevVO) select("sevDAO.UserLogin",vo);
	}
	public void LoginDate(sevVO vo)throws Exception{
		System.out.println("sevDAOLoginDate");
		update("sevDAO.LoginDate",vo);
	}

	public sevVO userFailInfo(sevVO vo) throws Exception{
		// TODO Auto-generated method stub
		return (sevVO)select("sevDAO.userFailInfo",vo);
	}

	public void UserFailCountUpdate(sevVO vo)throws Exception {
		// TODO Auto-generated method stub
		update("sevDAO.UserFailCountUpdate",vo);
	}

	public void UserLock(sevVO vo)throws Exception {
		// TODO Auto-generated method stub
		update("sevDAO.UserLock",vo);
	}
	//사용자
	public List<sevVO> sevList(sevVO vo) throws Exception {
		// TODO Auto-generated method stub
		return (List<sevVO>) list("sevDAO.sevList",vo);
	}

	public boolean sevInsert(sevVO vo) throws Exception{
		boolean bol = false;
		bol = update("sevDAO.sevInsert",vo) > 0 ? true : false;
		System.out.println("DAO BOL ==>"+bol);
		return bol;
	}
	public sevVO sevSelect(sevVO vo)throws Exception{
		return (sevVO) select("sevDAO.sevSelect",vo);
	}
	public boolean sevUpdate(sevVO vo)throws Exception{
		boolean bol = false;
		bol = update("sevDAO.sevUpdate",vo) > 0 ? true : false;
		return bol;
	}
	public boolean sevDelete(sevVO vo)throws Exception{
		boolean bol = false;
		bol = update("sevDAO.sevDelete",vo) > 0 ? true : false;
		return bol;
	}
	//회원가입
	public int idcount(sevVO vo) throws Exception {
		// TODO Auto-generated method stub
		return (int)select("sevDAO.idcount",vo);
	}
	public boolean joinInsert(sevVO vo)throws Exception{
		boolean bol = false;
		bol = update("sevDAO.joinInsert",vo) > 0 ? true : false;
		return bol;
	}
	//비밀번호변경
	public int passcount(sevVO vo)throws Exception{
		return (int)select("sevDAO.passcount",vo);
	}
	public void updatePasswd(sevVO vo)throws Exception{
		update("sevDAO.updatePasswd",vo);
	}
	//개인정보변경
	public boolean userSettingUpdate(sevVO vo)throws Exception{
		boolean bol = false;
		bol = update("sevDAO.userSettingUpdate",vo) > 0? true : false;
		return bol;
	}
	public void sevUpdateLev(sevVO sevvo)throws Exception{
		update("sevDAO.sevUpdateLev",sevvo);
	}
	public sevVO sevLevList(sevVO sevvo)throws Exception{
		return (sevVO) select("sevDAO.sevLevList",sevvo);
	}
	public void sevLevelUpgrade(sevVO sevvo)throws Exception{
		update("sevDAO.sevLevelUpgrade",sevvo);
	}
}
