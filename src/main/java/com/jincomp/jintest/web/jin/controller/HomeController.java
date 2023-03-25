package com.jincomp.jintest.web.jin.controller;

import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jincomp.jintest.web.jin.dto.MainBookListDTO;
import com.jincomp.jintest.web.jin.dto.OrderDTO;
import com.jincomp.jintest.web.jin.mapper.UserMapper;
import com.jincomp.jintest.web.jin.service.HomeService;
import com.jincomp.jintest.web.jin.service.UserService;
import com.jincomp.jintest.web.jin.vo.OrderVO;
import com.jincomp.jintest.web.jin.vo.UserVO;

@Controller
public class HomeController {
	@Autowired
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private HomeService homeService;

	@Autowired
	private UserService userService;

	@GetMapping("/") // 처음 DOMAIN 주소로 접근시 jsp 호출용.
	public String showFirstHome(HttpServletRequest request, HttpServletResponse response, ModelMap model)
			throws Exception {
		logger.debug("showFirstHome 진입");

		List<MainBookListDTO> list = homeService.getMainBookList();

		logger.debug("list : {}", list);

		model.addAttribute("list", list);

		return "/main/home"; // home.jsp 로 구성
	}

	@GetMapping("/admin")
	public String showAdmin(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {

		return "/admin/adminhome";
	}

	@GetMapping("/regist")
	public String showRegist(HttpServletRequest request, HttpServletResponse response, ModelMap model)
			throws Exception {

		return "/regist/regist";
	}

	//성인인증 페이지 진입
	@GetMapping("/adult")
	public String showAdult(HttpServletRequest request,
	HttpServletResponse response, Model model) throws Exception {
		
		return "/test/adult";
	}
	
	
	//페이지에서 인증
	@PostMapping("/adult")
	public String adult(UserVO userVO,@RequestParam("userRegNo1") String userRegNo1, HttpServletRequest request, Model model) {
		
		logger.debug("{}", "깐트롤러 진입");
		
		
		UserVO adultUser = homeService.adult(userVO, request, userRegNo1);
		
		if(adultUser != null) {
			model.addAttribute("msg", "인증완료");
		}
		
		
		return "/test/adult";
	}

	
	
	

	@GetMapping("/mypage/{userNo}")
	public String showMypage(@PathVariable int userNo, HttpServletRequest request, HttpServletResponse response, ModelMap model)
			throws Exception {
	logger.debug("mypage진입");
		
		logger.debug("userNo : {}", userNo);
		
		List<OrderVO> list = userService.orderList(userNo);   // userNo를 매개변수로 받아 로그인된 회원의 주문 내역리슽트만 가져옴
		
		logger.debug("list : {}", list);

		model.addAttribute("list", list);

		return "/mypage/mypage"; // mypage 폴더의 mypage화면으로 이동.
	}
}
