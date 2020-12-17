package egovframework.example.sevtest;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SessionInterceptor extends HandlerInterceptorAdapter {
	/**
	 * 세션만료 시 로그인페이지로 이동한다.
	 * @return true(요청한 controller 호출), false(로그인페이지로 이동)
	 * @description 로그인, 로그인처리 페이지를 제외한 나머지 페이지에서 controller 호출 전에 세션유무를 파악하여 페이지 이동시킨다. 
	 * @exception Exception
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception { 
		sevVO loginVo = (sevVO) request.getSession().getAttribute("Login");	// 로그인 사용자 세션정보
		String requestURI = request.getRequestURI(); // 요청 URI ex)/index.do

		if (requestURI.indexOf("/login.do") > -1) {//uri값이 login.do인지 확인
			return true;
		} else if (requestURI.indexOf("/userLogin.do") > -1) { //uri 값이 userLogin.do인지 확인
			return true;
		} else { //uri값이 login.do, userLogin.do가 아닐경우 
			if (loginVo !=null && !loginVo.getID().isEmpty()) { //로그인값이있을경우
				return true; 
			}
			else { //로그인값이없을경우 
				// 정상적인 세션정보가 없으면 로그인페이지로 이동
				System.out.println("세션정보없음");
				ModelAndView modelAndView = new ModelAndView("redirect:/login.do");
				throw new ModelAndViewDefiningException(modelAndView);
			}
		}

	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView model) throws Exception {
		String requestURI = request.getRequestURI();   
		sevVO loginVo = (sevVO) request.getSession().getAttribute("Login");
		if (requestURI.indexOf("/board.do") > -1) { // uri가 board.do인지확인 
			if(loginVo.getLEVEL().equals("3")) {
				request.getRequestDispatcher("/levelList.do");
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('자유게시판 등업후 사용가능 등업게시판 이용하세요'); location.href='/levelList.do';</script>");
				out.flush();
				throw new ModelAndViewDefiningException(new ModelAndView("redirect:/levelList.do"));
				
			}
		}
		//로그인정보 뷰단에 보냄
		if(loginVo !=null) {
			model.addObject("loginvo", loginVo);
		}
		
	}
	
}