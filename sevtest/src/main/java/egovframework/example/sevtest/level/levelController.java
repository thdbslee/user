package egovframework.example.sevtest.level;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import egovframework.example.sevtest.sevVO;
import egovframework.example.sevtest.service.sevService;

@Controller
public class levelController {
	/** 등업게시판 
	 *  levelVO ->등업게시판 VO 
	 *  sevVO -> 사용자정보 VO  
	 *  등업게시판 등록시 사용자 LEV_COUNT증가 
	 *  COUNT가 3이면 staff로 등업 후 자유게시판 이용 가능
	 *  LEVEL 0 : director  LEVEL 1 : manager LEVEL 2 : STAFF LEVEL3 : guest 
	 */
	@Resource(name="levelService")
	levelService levelService;
	@Resource(name="sevService")
	sevService sevService;
	@RequestMapping(value="/levelList.do")
	public String levelForm(@ModelAttribute("vo")levelVO vo,@ModelAttribute("sevvo")sevVO sevvo,HttpServletRequest request,ModelMap model,HttpSession sess)throws Exception{
		sevVO loginvo = (sevVO)sess.getAttribute("Login");
		model.addAttribute("loginvo", loginvo);
		List<levelVO> list = levelService.levelList(vo);
		model.addAttribute("list", list);
		
		
		return "/test/level/level";
	}
	
	@RequestMapping(value="/level_insert.do")
	public String levelInsert(@ModelAttribute("vo")levelVO vo,@ModelAttribute("sevvo")sevVO sevvo,HttpServletRequest request,ModelMap model,HttpSession sess)throws Exception{
		sevVO loginvo = (sevVO) sess.getAttribute("Login");
		model.addAttribute("loginvo", loginvo);
		
		return "/test/level/level_insert";
	}
	@ResponseBody
	@Transactional
	@RequestMapping(value="/level_insert_ok.do")
	public String levInsert(@ModelAttribute("vo")levelVO vo,@ModelAttribute("sevvo")sevVO sevvo,@ModelAttribute("svo")sevVO svo,
			HttpServletRequest request,ModelMap model,HttpSession sess)throws Exception{
		sevVO loginvo =(sevVO)sess.getAttribute("Login");
		if(levelService.levelInsert(vo)) { //INSERT 
			sevService.sevUpdateLev(svo); //사용자 등록게시물건수 증가시키기  --받아온값을 가지고 update 
			svo = sevService.sevLevList(svo); //사용자 게시물건수 불러오기
			int count = svo.getLEV_COUNT(); //게시물건수몇개인지 
			System.out.println("count-->"+count);
				if(count ==3) {
				//level staff로 upgrade시키기 
				sevService.sevLevelUpgrade(sevvo);
				sevvo = sevService.sevLevList(sevvo); //사용자 게시물건수 불러오기 
				System.out.println("sevvo레벨 =>"+sevvo.getLEVEL());
				loginvo.setLEVEL(sevvo.getLEVEL());
				System.out.println("로그인레벨=>"+loginvo.getLEVEL());
				sess.setAttribute("Login", loginvo); //세션업데이트하기
	
				return"upgrade";
		
				}else {
					System.out.println("등록");
					return "true";
				}
		}else {
			return "false";
		}
	}
	@RequestMapping(value="/level_edit.do")
	public String levelEditForm(@ModelAttribute("vo")levelVO vo,HttpSession sess,HttpServletRequest request,ModelMap model)throws Exception{
		sevVO loginvo = (sevVO)sess.getAttribute("Login");
		model.addAttribute("loginvo", loginvo);
		
		vo = levelService.levelSelect(vo);
		model.addAttribute("vo", vo);
		
		
		return "/test/level/level_edit";
	}
	@ResponseBody
	@Transactional
	@RequestMapping(value="/levelEidt_ok.do")
	public String levelEdit(@ModelAttribute("vo")levelVO vo,HttpSession sess,HttpServletRequest request,ModelMap model)throws Exception{
		sevVO loginvo = (sevVO) sess.getAttribute("Login");
		model.addAttribute("loginvo",loginvo);
		
		if(levelService.levelUpdate(vo)) {
			return "true";
		}else {
			return "false";
		}
	}
	@RequestMapping(value="/level_detail.do")
	public String levelDetail(@ModelAttribute("vo")levelVO vo,HttpSession sess,HttpServletRequest request,ModelMap model)throws Exception{
		sevVO loginvo = (sevVO) sess.getAttribute("Login");
		System.out.println("vo=>"+ToStringBuilder.reflectionToString(loginvo));
		model.addAttribute("loginvo", loginvo);
		 
		vo = levelService.levelSelect(vo);
		model.addAttribute("vo",vo);
		return "/test/level/level_detail";
	}
	@ResponseBody
	@Transactional
	@RequestMapping(value="/levelDelete.do")
	public String levelDelete(@ModelAttribute("vo")levelVO vo,HttpSession sess,HttpServletRequest request,ModelMap model)throws Exception{
		sevVO loginvo = (sevVO) sess.getAttribute("Login");
		vo.setINXS(request.getParameterValues("INX"));
		System.out.println("INXS->"+vo.getINXS());
		if(levelService.levelDelete(vo)) {
			return "true" ;
		}else {
			return "false";
		}
		
	}
}
