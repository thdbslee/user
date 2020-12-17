package egovframework.example.sevtest.qa;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import egovframework.example.sevtest.sevVO;

@Controller
public class qaController {
	@Resource(name="qaService")
	qaService qaService;
	
	@RequestMapping(value="/QAlist.do")
	public String QAForm(@ModelAttribute("vo")QAVO vo,HttpServletRequest request,HttpSession sess,ModelMap model)throws Exception{
		sevVO loginvo = (sevVO) sess.getAttribute("Login");
		model.addAttribute("loginvo", loginvo);
		System.out.println("AUTH_CODE->"+loginvo.getAUTH_CODE());
		
		List<QAVO> qalist = qaService.qaList(vo);
		model.addAttribute("qalist", qalist);
		
		return"/test/QA/QAlist";
	}
	@RequestMapping(value="/qa_insert.do")
	public String QAInsertForm(@ModelAttribute("vo")QAVO vo,HttpServletRequest request,HttpSession sess,ModelMap model)throws Exception{
		sevVO loginvo = (sevVO) sess.getAttribute("Login");
		model.addAttribute("loginvo", loginvo);
		
		return"/test/QA/QAInsert";
	}
	@ResponseBody
	@Transactional
	@RequestMapping(value="/qa_insert_ok.do")
	public String QAInsert(@ModelAttribute("vo")QAVO vo,HttpServletRequest request,HttpSession sess,ModelMap model)throws Exception{
		sevVO loginvo = (sevVO)sess.getAttribute("Login");
		model.addAttribute("loginvo",loginvo);
		
		if(qaService.qaInsert(vo)) {
			return "true";
		}else {
			return "false";
		}
	}
	@RequestMapping(value="/qa_edit.do")
	public String QAEditForm(@ModelAttribute("vo")QAVO vo,HttpServletRequest request,HttpSession sess,ModelMap model)throws Exception{
		sevVO loginvo = (sevVO)sess.getAttribute("Login");
		model.addAttribute("loginvo", loginvo);
		
		vo = qaService.qaSelect(vo); //수정할 INX선택하기 
		model.addAttribute("qavo", vo);
		return"/test/QA/QAEdit";
	}
	@ResponseBody
	@Transactional
	@RequestMapping(value="/qa_edit_ok.do")
	public String QAEdit(@ModelAttribute("vo")QAVO vo,HttpServletRequest request,HttpSession sess,ModelMap model)throws Exception{
		sevVO loginvo = (sevVO) sess.getAttribute("Login");
		model.addAttribute("loginvo", loginvo);
		
		if(qaService.qaUpdate(vo)) {
			return "true";
		}else {
			return "false";
		}
	}
	@ResponseBody
	@Transactional
	@RequestMapping(value="/qaDelete.do")
	public String QA_DELETE(@ModelAttribute("vo")QAVO vo,@ModelAttribute("anvo")QA_ANSWERVO anvo, HttpServletRequest request,HttpSession sess,ModelMap model)throws Exception{
		sevVO loginvo = (sevVO) sess.getAttribute("Login");
		model.addAttribute("loginvo", loginvo);
		
		System.out.println("INX=>"+request.getParameterValues("INX"));
		vo.setINXS(request.getParameterValues("INX"));
		
		if(qaService.qaDelete(vo)) {
			qaService.answerDelete(vo);
			return "true";
		}else {
			return "false";
		}
		
	}
	@RequestMapping(value="/qa_detail.do")
	public String QA_Detail(@ModelAttribute("vo")QAVO vo,@ModelAttribute("anvo")QA_ANSWERVO anvo,HttpServletRequest request,HttpSession sess,ModelMap model)throws Exception{
		sevVO loginvo = (sevVO) sess.getAttribute("Login");
		model.addAttribute("loginvo", loginvo);
		//문의게시판선택
		vo = qaService.qaSelect(vo);
		model.addAttribute("qavo", vo);
		//문의답변리스트 불러오기 
		List<QA_ANSWERVO> list = qaService.answerList(anvo);
		model.addAttribute("list", list);
		
		return "/test/QA/QA_Detail";
	}
	//답변등록
	@ResponseBody
	@Transactional
	@RequestMapping(value="/answer_ok.do")
	public String QA_ANSWER(@ModelAttribute("anvo")QA_ANSWERVO anvo,@ModelAttribute("vo")QAVO vo,HttpServletRequest request,HttpSession sess,ModelMap model)throws Exception{
		sevVO loginvo = (sevVO) sess.getAttribute("Login");
		model.addAttribute("loginvo", loginvo);
		if(qaService.answerInsert(anvo)) { 
			if(loginvo.getAUTH_CODE().equals("9")) { 
				qaService.qaAnswerUpdate(vo); //관리자댓글달면 답변유무 Y로 update
			}
			return "true";
		}else {
			return "false";
		}
	}
}
