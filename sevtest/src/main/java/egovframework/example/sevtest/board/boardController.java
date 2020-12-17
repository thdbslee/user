package egovframework.example.sevtest.board;

import java.io.File;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import egovframework.example.cmmn.ComDefaultVO;
import egovframework.example.cmmn.service.EgovFileMngService;
import egovframework.example.cmmn.service.EgovFileMngUtil;
import egovframework.example.sevtest.sevVO;
import egovframework.example.sevtest.service.*;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
@Controller
public class boardController {
	@Resource(name="sevService")
	sevService sevService;
	@Resource(name="boardService")
	boardService boardService;
	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;

	//자유게시판
	@RequestMapping(value="/board.do", produces="application/text; charset=utf8")
	public String boardForm(@ModelAttribute("vo")boardVO vo,HttpServletRequest request,HttpSession sess,ModelMap model)throws Exception{
			List<boardVO> list = boardService.boardList(vo);
			
			model.addAttribute("list", list);//리스트불러오기위해 
		
			return"/test/board/board";
	}
	@RequestMapping(value="/boardInsert.do")
	public String boardInsertForm(@ModelAttribute("vo")boardVO vo,HttpServletRequest request,HttpSession sess,ModelMap model)throws Exception{
		sevVO loginvo = (sevVO)sess.getAttribute("Login");
		model.addAttribute("login", loginvo);
		return"/test/board/boardInsert";
	}
	@ResponseBody
	@Transactional
	@RequestMapping(value="/boardInsert_ok.do")
	public String boardInsert(@ModelAttribute("vo")boardVO vo,HttpServletRequest request,HttpSession sess,ModelMap model)throws Exception{
		sevVO loginvo = (sevVO)sess.getAttribute("Login");
		//로그인아이디나타내기 
		model.addAttribute("login", loginvo);
		String rtn = "";
		MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> files = multiRequest.getFileMap();
		InputStream fis = null;
		Iterator itr = files.entrySet().iterator();

		while (true) {
			MultipartFile file;
			do {
				do {
					if (!itr.hasNext()) {
						if(boardService.boardInsert(vo)) {
							return "true";
						}else {
							return "false";
						}
					
						
					}

					Entry<String, MultipartFile> entry = (Entry) itr.next();
					file = (MultipartFile) entry.getValue();
				} while ("".equals(file.getOriginalFilename()));
			} while (!file.getOriginalFilename().endsWith(".jpg") && !file.getOriginalFilename().endsWith(".JPG")
					&& !file.getOriginalFilename().endsWith(".png")
					&& !file.getOriginalFilename().endsWith(".PNG"));

			
			String filePath = request.getSession().getServletContext().getRealPath("/");
			System.out.println("filePath=>"+filePath);
			String ext = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(46));
			System.out.println("ext->"+ext);
			String destination = System.nanoTime() + ext;
			System.out.println("destination->"+destination);
			File saveFile = new File(filePath + "/upload/" + destination);
			System.out.println("saveFile=>"+saveFile);
			file.transferTo(saveFile);
			vo.setIMG_1(destination);
			
		}
		
		}
	
	@ResponseBody
	@Transactional
	@RequestMapping(value="/boardDelete.do")
	public String boardDelete(@ModelAttribute("vo")boardVO vo,commentVO cmvo,HttpSession sess,HttpServletRequest request,ModelMap model)throws Exception{
		sevVO loginvo = (sevVO) sess.getAttribute("Login");
		vo.setINXS(request.getParameterValues("INX_CHK"));
		//System.out.println(ToStringBuilder.reflectionToString(vo));
		
			if(boardService.boardDelete(vo)) {//게시물삭제시
				boardService.boardComDelete(vo); //게시물번호와같은 댓글삭제
				return "true";
			}else {
				return "false";
			}

		
	}
	
	@RequestMapping(value="/boardEdit.do")
	public String boardEditForm(@ModelAttribute("vo")boardVO vo,HttpSession sess,HttpServletRequest request,ModelMap model)throws Exception{
		sevVO loginvo = (sevVO)sess.getAttribute("Login");
		vo = boardService.boardSelect(vo);
		model.addAttribute("boardvo",vo);
		return "/test/board/boardEdit";
	}
	
	@ResponseBody
	@Transactional
	@RequestMapping(value="/boardEdit_ok.do")
	public String boardEdit(@ModelAttribute("vo")boardVO vo,HttpSession sess,HttpServletRequest request,ModelMap model)throws Exception{
		sevVO loginvo = (sevVO)sess.getAttribute("Login");
		if(boardService.boardUpdate(vo)) {
			return"ture";
		}else {
			return "false";
		}
		
	}
	/** 댓글달기
	 * @param vo
	 * @param cmvo
	 * @param sess
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/boardDetail.do", produces="application/text; charset=utf8")
	public String boardDetail(@ModelAttribute("vo")boardVO vo,@ModelAttribute("cmvo")commentVO cmvo,HttpSession sess,HttpServletRequest request,ModelMap model)throws Exception{
		sevVO loginvo = (sevVO) sess.getAttribute("Login");
		model.addAttribute("sevvo", loginvo);
		
		/** EgovPropertyService.sample */
		cmvo.setPageUnit(propertiesService.getInt("pageUnit"));
		cmvo.setPageSize(propertiesService.getInt("pageSize"));

		/** pageing setting */
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(cmvo.getPageIndex());//현재페이지번호
		paginationInfo.setRecordCountPerPage(5); //한 페이지에 게시되는 게시물 건수
		paginationInfo.setPageSize(cmvo.getPageSize());//페이지리스트에게시되는페이지건수
		//paginationInfo.setRecordCountPerPage(cmvo.getPageUnit());//한페이지당게시되는게시물건수
		
		cmvo.setFirstIndex(paginationInfo.getFirstRecordIndex());
		cmvo.setLastIndex(paginationInfo.getLastRecordIndex());
		cmvo.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
		//게시판선택
		vo = boardService.boardSelect(vo);
		model.addAttribute("boardvo", vo);
		//게시판 선택 후 조회 수 증가시키기 
		boardService.boardInfoUpdate(vo);
		
		//댓글리스트불러오기
		List<commentVO> list = boardService.commentList(cmvo);
		model.addAttribute("cmlist", list);
		
		int totCnt = boardService.commenTotCnt(cmvo);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);
		
	
		
		return "/test/board/boardDetail";
	}
	//댓글등록
	@ResponseBody
	@Transactional
	@RequestMapping(value="/comment_ok.do", produces="application/text; charset=utf8")
	public String commentInsert(@ModelAttribute("cmvo")commentVO cmvo,HttpSession sess,HttpServletRequest request,ModelMap model)throws Exception{
		
		if(boardService.commentInsert(cmvo)) {
			return "true";
		}else {
			return "false";
		}
	}
	//댓글삭제
	@ResponseBody
	@Transactional
	@RequestMapping(value="/comDelete.do")
	public String comDelete(@ModelAttribute("cmvo")commentVO cmvo,HttpSession sess,HttpServletRequest request,ModelMap model)throws Exception{
		sevVO loginvo = (sevVO) sess.getAttribute("Login");
		
		cmvo.setINX(Integer.parseInt(request.getParameter("delInx"))); //delInx값을 넣어준다 
		if(boardService.commentDelete(cmvo)) {
			return "true";
		}else {
			return "false";
		}
	}
	
	
}
