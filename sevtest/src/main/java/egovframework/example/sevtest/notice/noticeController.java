package egovframework.example.sevtest.notice;


import java.io.File;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


@Controller
public class noticeController {

		@Resource(name="noticeService")
		noticeService noticeService; 
		
		@RequestMapping(value="/notice.do")
		public String noticeForm(@ModelAttribute("vo")noticeVO vo,HttpServletRequest request,ModelMap model)throws Exception{
			List<noticeVO> list = noticeService.noticeList(vo);
			model.addAttribute("list", list);
			return "/test/notice/noticeForm";
		}
		@RequestMapping(value="/noticeInsert.do")
		public String noticeWrite(@ModelAttribute("vo")noticeVO vo,HttpServletRequest request,ModelMap model)throws Exception{
			return "/test/notice/noticeInsert";
		}
		@RequestMapping(value="/notceDetail.do")
		public String noticeDetail(@ModelAttribute("vo")noticeVO vo,HttpServletRequest request,ModelMap model)throws Exception{
			//select 
			noticeService.noticeInfoCount(vo); //공지사항클릭하면 조회수 증가
			vo = noticeService.noticeSelect(vo);
			model.addAttribute("noticevo", vo);
			return "/test/notice/noticeDetail";
		}
		@RequestMapping(value="/noticeUpdate.do")
		public String noticeUpdate(@ModelAttribute("vo")noticeVO vo,HttpServletRequest request,ModelMap model)throws Exception{
			vo = noticeService.noticeSelect(vo);
			model.addAttribute("noticevo", vo);
			return "/test/notice/noticeUpdate";
		}
		@ResponseBody
		@Transactional
		@RequestMapping(value="/noticeUpdate_ok.do")
		public String noticeUpdateForm(@ModelAttribute("vo")noticeVO vo,HttpServletRequest request,ModelMap model)throws Exception{
			if(noticeService.noticeUpdate(vo)) {
				return "true";
			}else {
				return "false";
			}
			
		}
		
		@ResponseBody
		@Transactional
		@RequestMapping(value="/noticeDelete.do")
		public String noticeDelete(@ModelAttribute("vo")noticeVO vo,HttpServletRequest request,ModelMap model)throws Exception{
			vo.setINXS(request.getParameterValues("INX_CHK"));
			if(noticeService.noticeDelete(vo)) {
				return"true";
			}else {
				return "false";
			}
		}
		@ResponseBody
		@Transactional
		@RequestMapping(value="/noticeInsert_ok.do")
		public String noticeInsertOK(@ModelAttribute("vo")noticeVO vo,HttpServletRequest request,ModelMap model)throws Exception{
			System.out.println("공지사항 등록");
			
			//파일업로드
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			Map<String,MultipartFile> files = multiRequest.getFileMap();
			InputStream fis = null; //입력스트림
			Iterator itr = files.entrySet().iterator(); //Map전체값출력 entrySet -key,value모두 필요한경우
			while (true) {
				MultipartFile file;
				do {
					do {
						if (!itr.hasNext()) { //hasNext : iterator가 가리키는 데이터장소의 현재위치에서 이동할 항목이있는지체크
							//이동할항목이없으면 insert
							if(noticeService.noticeInsert(vo)) {
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


}
