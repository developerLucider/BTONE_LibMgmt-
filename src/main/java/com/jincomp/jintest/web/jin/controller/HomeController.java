package com.jincomp.jintest.web.jin.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import com.jincomp.jintest.web.jin.service.BookService;
import com.jincomp.jintest.web.jin.vo.BookVO;
import com.jincomp.jintest.web.jin.vo.EventVO;
import com.jincomp.jintest.web.jin.vo.RentVO;
import com.jincomp.jintest.web.jin.vo.UserVO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class HomeController {
	
	@Autowired
	private static final Logger log = LoggerFactory.getLogger(HomeController.class);

	private final BookService bookService;


	@GetMapping("/") // 처음 DOMAIN 주소로 접근시 jsp 호출용.
	public String showFirstHome(Model model) throws Exception {
		
		log.info("{}", "메인 컨트롤러 진입");
				
	
		return "/main/home"; // home.jsp 로 구성s
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 * 관리자 페이지 이동 
	 */
	@GetMapping("/admin")
	public String showAdmin(HttpServletRequest request,
	HttpServletResponse response, ModelMap model) throws Exception {
		
		return "/admin/adminhome";
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 * 회원가입 페이지 이동
	 */
	@GetMapping("/regist")
	public String showRegist(HttpServletRequest request,
	HttpServletResponse response, ModelMap model) throws Exception {
		
		return "/regist/regist";
	}
	
	/**
	 * 로그인 페이지 이동
	 */
	@GetMapping("/login")
	public String showLogin(HttpServletRequest request,
	HttpServletResponse response, Model model) throws Exception {
		
		return "/login/login";
	}
	
	/**
	 * 스웨거 페이지 이동
	 */
	@GetMapping("/swagger-ui/user-rest-controller")
	public String swagger() {
		
		return null;
	}
}
