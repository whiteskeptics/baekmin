package com.project.bustaja.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.bustaja.company.dao.CompanyVO;
import com.project.bustaja.user.dao.UserDAO;
import com.project.bustaja.user.dao.UserVO;
import com.project.bustaja.user.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login.action", method=RequestMethod.GET)
	public String userLoginView(UserVO vo) throws Exception{
		
		System.out.println("로그인 화면으로 이동");
		return "redirect:login.jsp";
	}
	
	@RequestMapping(value="/logincheck.action")
	public String userLogin(HttpServletRequest req,HttpServletResponse res, HttpSession session) throws Exception{
		
		String cid = req.getParameter("cid");
		String cpw = req.getParameter("cpw");
		if( cid == null || cpw == null) {
			return "redirect:login.jsp";
		}
		
		UserVO user = userService.getUser(cid,cpw);
		
		if(user != null) {
					
			session.setAttribute("level", user.getLev());
			session.setAttribute("userName", user.getCid());
			if(user.getLev() == 5 ) { 
				return "redirect:NewFile.jsp"; //관리자 페이지로의 이동
			}else {
				return "redirect:/getTerminalName.action"; //사용자 페이지로의 이동
			}
		}else {
			return "redirect:login.jsp";
		}
		
	}
	
	@RequestMapping("/logout.action")
	public ModelAndView logout(HttpServletRequest request, ModelAndView mav) throws Exception {
		System.out.println("로그아웃처리");
		
		request.getSession().invalidate();
		mav.setViewName("redirect:login.jsp");
		return mav;
		
	}
	
	@RequestMapping(value="/joinview.action", method=RequestMethod.GET)
	public String userJoin(UserVO vo) throws Exception{
		
		System.out.println("회원가입 화면으로 이동");
		return "redirect:join.jsp";
	}
	
	
	@RequestMapping(value = "/joincheck.action")
	public String userInsert(HttpServletRequest req, HttpServletResponse res, Model model) {
		
		
		res.setCharacterEncoding("utf-8");
		UserVO vo = new UserVO();
		vo.setCid(req.getParameter("cid"));
		vo.setCpw(req.getParameter("cpw"));
		vo.setCname(req.getParameter("cname"));
		vo.setCphone(req.getParameter("cphone"));
		userService.insertUser(vo);
		
		return "redirect:joincheck.jsp";
	}
	
}
