package egovframework.example.sevtest.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import egovframework.example.sevtest.sevVO;
import egovframework.example.sevtest.service.*;
import net.sf.json.JSONObject;
@Controller
public class sevController {
	@Resource(name="sevService")
	private sevService sevService;
	
	
	//로그인 인덱스.jsp첫페이지 login.do로 설정
	@RequestMapping(value="/login.do")
	public String login(@ModelAttribute("vo")sevVO vo,HttpServletRequest request,ModelMap model,HttpSession sess)throws Exception{
		sevVO loginVO = (sevVO)sess.getAttribute("Login");
		
		return"/test/login";
	}
	//로그인 성공시 index.do화면으로 
	@RequestMapping(value="/index.do")
	public String index(HttpSession sess,HttpServletRequest request,ModelMap model)throws Exception{
		sevVO loginVo =(sevVO)sess.getAttribute("Login");
		if(loginVo.getAUTH_CODE().equals("9")) {//관리자
			return "redirect:/mainTest.do";
		}else {//일반사용자
			return "redirect:/userMain.do";
		}
	}
	//메뉴 
	@RequestMapping(value="/layoutMenu.do")
	public String topmenu(HttpServletRequest request, Model model, HttpSession sess) throws Exception{
		return "/test/layout/menu";
	}
	@ResponseBody
	@Transactional
	@RequestMapping(value="/userLogin.do")
	public String userLogin(@ModelAttribute("vo")sevVO vo,@ModelAttribute("failVo")sevVO failVo
	,HttpServletRequest request,ModelMap model,HttpSession sess)throws Exception{
		JSONObject json = new JSONObject();
		vo = sevService.UserLogin(vo); //아이디비밀번호확인
		if(vo!=null) {//아이디비밀번호맞으면 
			//이미락걸린경우
			if(vo.getLOCK_YN().equals("Y")) {
				json.put("resultCode", "LOCK");
			}else {
				sevService.LoginDate(vo); //로그인한날짜등록
				sess.setAttribute("Login", vo);
				json.put("resultCode", "Y");
			}
		}else {//로그인 실패시 
			String loginId = request.getParameter("ID");
			failVo.setID(loginId);
			failVo = sevService.userFailInfo(failVo);
			if(failVo !=null) {
				int failcount = failVo.getFAIL_COUNT();
				if(failcount < 5) {
					sevService.UserFailCountUpdate(failVo);
					json.put("resultCode", "N");
				}else {
					sevService.UserLock(failVo);
					json.put("resultCode","LOCK");
				}
			}
		}
			return json.toString();
			
	}
	//로그아웃
	@RequestMapping(value="/logout.do")
	public String logout(HttpSession sess,HttpServletRequest request)throws Exception{
		sess.invalidate();
		return "redirect:/login.do";
	}
	//회원가입
	@RequestMapping(value="/join.do")
	public String joinForm(HttpServletRequest request,ModelMap model)throws Exception{
		return"/test/join";
	}
	//회원가입ok
	@ResponseBody
	@Transactional
	@RequestMapping(value="/join_ok.do")
	public String join_ok(HttpServletRequest request,ModelMap model,@ModelAttribute("vo")sevVO vo)throws Exception{
		int idcount = sevService.idcount(vo); //아이디중복확인
		if(idcount==0) {
			if(sevService.joinInsert(vo)) { 
				return "true";
			}else {
				return "n";
			}
		}else {
			return "false";
		}
		
	}
	//비밀번호변경
	@RequestMapping(value="/changePasswd.do")
	public String changePasswd(@ModelAttribute("vo")sevVO vo,HttpServletRequest request,ModelMap model,HttpSession sess)throws Exception{
		sevVO loginvo = (sevVO) sess.getAttribute("Login");
		model.addAttribute("loginvo", loginvo);
		return "/test/passwdchange";
	}
	//비밀번호변경확인
	@ResponseBody
	@Transactional
	@RequestMapping(value="/passwdchange_ok.do")
	public String changePasswdOK(@ModelAttribute("vo")sevVO vo,@ModelAttribute("newvo")sevVO newvo
		,HttpServletRequest request,HttpSession sess,ModelMap model)throws Exception{
		sevVO loginvo =(sevVO) sess.getAttribute("Login");
		//sevVO vo에 현재비밀번호넣기 
		vo.setPASSWD(request.getParameter("OLDPASSWD").toString());
		//sevVO newvo에 새비밀번호 넣기
		newvo.setPASSWD(request.getParameter("NEWPASSWD").toString());
		//현재 비밀번호 맞는지 확인
		int passcount = sevService.passcount(vo);
		if(passcount > 0) {
			//비밀번호변경로직추가
			sevService.updatePasswd(newvo);
			return "Y"; //변경완료
		}else {
			return "N"; //변경실패
		}
	}
	
	//사용자관리
	@RequestMapping(value="/mainTest.do")
	public String mainTest(@ModelAttribute("vo")sevVO vo,HttpServletRequest request,ModelMap model,HttpSession sess) throws Exception {
		sevVO loginvo = (sevVO) sess.getAttribute("Login");
		if(loginvo.getAUTH_CODE().equals("9")) {
			model.addAttribute("login", loginvo); //jsp에 로그인한 이름 확인하기*/
			
			List<sevVO> list = sevService.sevList(vo);//작성자리스트 
			model.addAttribute("list", list);
			return "/test/hello";	
		}else {
			return "redirect:/index.do";
		}

	}
	//일반모드로로그인시
	@RequestMapping(value="/userMain.do")
	public String userMain(@ModelAttribute("vo")sevVO vo,HttpServletRequest request,ModelMap model,HttpSession sess) throws Exception {
		sevVO loginvo = (sevVO) sess.getAttribute("Login");
		model.addAttribute("login", loginvo); //jsp에 로그인한 이름 확인하기
		
		List<sevVO> list = sevService.sevList(vo);//작성자리스트 
		model.addAttribute("list", list);
		return "/test/userMain";
	}
	@RequestMapping(value="/sev_manage.do")
	public String manageForm(@ModelAttribute("vo")sevVO vo,HttpServletRequest request,ModelMap model,HttpSession sess)throws Exception{
		sevVO loginvo = (sevVO) sess.getAttribute("Login");
		model.addAttribute("loginvo", loginvo);
		if(loginvo.getAUTH_CODE().equals("9")) {
			List<sevVO> list = sevService.sevList(vo);
			model.addAttribute("list", list);
			return "/test/manage";
		}else {
			return "redirect:/index.do";
		}
		
	}
	@RequestMapping(value="/user_List.do")
	public String userForm(@ModelAttribute("vo")sevVO vo,HttpSession sess,HttpServletRequest request,ModelMap model)throws Exception{
		sevVO loginvo = (sevVO)sess.getAttribute("Login");
		List<sevVO> list = sevService.sevList(vo);
		model.addAttribute("list", list);
		return "/test/userList";
	}
	//직원등록폼
	@RequestMapping(value="/workInsert.do")
	public String workInsertForm(@ModelAttribute("vo")sevVO vo,HttpServletRequest request,ModelMap model)throws Exception{
		return "/test/workInsert";
	}
	//직원등록
	@ResponseBody
	@Transactional
	@RequestMapping(value="/workInsert_ok.do", method=RequestMethod.POST,produces = "application/text; charset=utf8")
	public String workInsert(@ModelAttribute("vo")sevVO vo,HttpServletRequest request,ModelMap model)throws Exception{
		int idcount = sevService.idcount(vo);
		if(idcount ==0) {
			if(sevService.sevInsrert(vo)) {
				return "TRUE";
			}else {
				return "n";
			}
		}else {
			return "false";
		}
		
	}
	//직원수정화면 
	@RequestMapping(value="/workEdit.do")
	public String workEditForm(@ModelAttribute("vo")sevVO vo,HttpServletRequest request,ModelMap model)throws Exception{
		
		vo =sevService.sevSelect(vo); //inx체크하기 ? 
		model.addAttribute("editvo", vo);
		return"/test/workEdit";
	}
	@ResponseBody
	@Transactional
	@RequestMapping(value ="/workEdit_ok.do", method=RequestMethod.POST)
	public String workEditOk(@ModelAttribute("vo")sevVO vo,HttpServletRequest request,ModelMap model,HttpSession sess)throws Exception{
		if(sevService.sevUpdate(vo)) {
			return "true";
		}else {
			return "false";
		}
		
	}
	@ResponseBody
	@Transactional
	@RequestMapping(value="/workDelete.do",method=RequestMethod.POST)
	public String workDelete(@ModelAttribute("vo")sevVO vo,HttpServletRequest request,ModelMap model)throws Exception{
		vo.setINXS(request.getParameterValues("inx_check"));

		if(sevService.sevDelete(vo)) {
			return "true";
		}else {
			return "false";
		}
	}
	// 개인정보MyPage
	@RequestMapping(value="/setting.do")
	public String settingForm(HttpSession sess,HttpServletRequest request,ModelMap model)throws Exception{
		sevVO loginvo = (sevVO) sess.getAttribute("Login");
		model.addAttribute("loginvo", loginvo);
		return"/test/setting/settingForm";
	}
	//Mypage 비밀번호확인 후 변경홈페이지나오게
	@ResponseBody
	@Transactional
	@RequestMapping(value="/setting_passwd.do")
	public String settingpasswd(@ModelAttribute("vo")sevVO vo,HttpSession sess,HttpServletRequest request,ModelMap model)throws Exception{
		sevVO loginvo = (sevVO)sess.getAttribute("Login");
		vo = sevService.UserLogin(vo);
		if(vo!=null) {
			return "true";
		}else {
			return "false";
		}
	}
	@RequestMapping(value="/setting_edit_form.do")
	public String setEditForm(@ModelAttribute("vo")sevVO vo,HttpSession sess,HttpServletRequest request,ModelMap model)throws Exception{
		sevVO loginvo = (sevVO) sess.getAttribute("Login");
		model.addAttribute("loginvo",loginvo);
		return"/test/setting/setting";
	}
	
	@ResponseBody
	@Transactional
	@RequestMapping(value="/setting_eidt.do")
	public String settingEdit(@ModelAttribute("vo")sevVO vo,HttpSession sess
		,HttpServletRequest request,ModelMap model)throws Exception{
		sevVO loginvo = (sevVO) sess.getAttribute("Login");
		model.addAttribute("vo", vo);
		if(sevService.userSettingUpdate(vo)) {
			sess.setAttribute("Login", loginvo); //세션업데이트하기->로그아웃안해도 세션바뀜
			return "true";
		}else {
			return "false";
		}
		
	}
}
