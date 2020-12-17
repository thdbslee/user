package egovframework.example.sevtest.totalwrite;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import egovframework.example.sevtest.sevVO;
import egovframework.example.sevtest.board.boardService;
import egovframework.example.sevtest.board.boardVO;
import egovframework.example.sevtest.notice.noticeVO;
//전체작성한글
@Controller
public class totalController {
	@Resource(name="totalService")
	totalService totalService;
	@Resource(name="boardService")
	boardService boardService;
	
	@RequestMapping(value="/totwrite.do")
	public String totalForm(@ModelAttribute("vo")totalVO vo 
			,HttpSession sess,HttpServletRequest request, Model model)throws Exception{

		sevVO loginvo = (sevVO)sess.getAttribute("Login");
		model.addAttribute("login", loginvo);
		vo.setID(loginvo.getID());
		List<totalVO> list = totalService.totalWriteList(vo);
		model.addAttribute("list", list);

		return "/test/total/totalwrite";
	}
	@RequestMapping(value="/total_detail.do")
	public String totalDetail(@ModelAttribute("vo")totalVO vo,HttpSession sess,HttpServletRequest request,Model model)throws Exception{
		sevVO loginvo = (sevVO) sess.getAttribute("Login");
		vo.setID(loginvo.getID());
		vo = totalService.totalSelect(vo);
		model.addAttribute("totalvo", vo);
		
		return"/test/total/totalDetail";
	}
	@ResponseBody
	@Transactional
	@RequestMapping(value="/totalDelete.do")
	public String totDelete(@ModelAttribute("vo")totalVO vo,HttpServletRequest request,HttpSession sess,Model model)throws Exception{
		totalService.totalDelete(vo);
		return "true";
	}
}
