package com.project.bustaja.time.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.bustaja.company.dao.CompanyVO;
import com.project.bustaja.time.dao.TimeVO;
import com.project.bustaja.time.service.TimeService;
import com.project.bustaja.travel.dao.TravelVO;

@Controller
public class TimeController {
    
	@Autowired
	private TimeService timeService;
	
	@RequestMapping(value = "/timeList.action", method = RequestMethod.GET)
	public String timeList(HttpServletRequest req, HttpServletResponse res, Model model) {
//		System.out.println("이곳은 노선관련 배차 관련 컨트롤러이며... 노선관련 배차 리스트를 출력하기 위한 곳임.....");
		int page = 1; 
		int limit = 2;
		if(req.getParameter("page") != null) {
			page = Integer.parseInt( req.getParameter("page") );
		}
		
		int listCnt = timeService.getCount();
//		System.out.println("자료의 개수 : " + listCnt);
		int startRow = page *2 -1;
		int lastRow = startRow + 2 -1;
		List<TimeVO> timeList = timeService.listTime(startRow, lastRow);
		model.addAttribute("listCnt", listCnt);
		model.addAttribute("timeList", timeList); //가져온 자료가 담김
		//페이지 계산
		int maxPage = listCnt/limit + ((listCnt%limit != 0)? 1 : 0);
		int startPage = (page /10)+1 ;
		int endPage = startPage + 9;
		if(endPage > maxPage) endPage = maxPage;
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaa   " + startPage + "ddddddddd   " + endPage + "cccccccccc  : "+ maxPage);
		//계산된 결과를 속성에 넣어줌
		model.addAttribute("page",page);
		model.addAttribute("maxPage",maxPage);
		model.addAttribute("startPage",startPage);
		model.addAttribute("endPage",endPage);
		
		return "timeList";
	}
	
	@RequestMapping(value = "/timeInsert.action", method = RequestMethod.GET)
	public String timeInsert(HttpServletRequest req, HttpServletResponse res, Model model) {
//		
		
		return "insertTime";
	}
	
	@RequestMapping(value = "/insertTimeaa.action")
	public String travelInsertaa(HttpServletRequest req, HttpServletResponse res, Model model) {
		
		
		res.setCharacterEncoding("utf-8");
		TimeVO vo = new TimeVO();
		vo.setRouteNum(Integer.parseInt(req.getParameter("routeNum")));
		vo.setCompany(Integer.parseInt(req.getParameter("company")));
		vo.setSeatClass(Integer.parseInt(req.getParameter("seatClass")));
		vo.setStartTime(req.getParameter("startTime"));
		vo.setBusNum(Integer.parseInt(req.getParameter("busNum")));
	
		
		timeService.insertTime(vo);
		return "redirect:/timeList.action";
	}
	
	@RequestMapping(value = "/timedelete.action", method = RequestMethod.GET)
	public String companyDelete(HttpServletRequest req, HttpServletResponse res, Model model) {
		int busNum = Integer.parseInt( req.getParameter("busNum"));
		
		timeService.delTime(busNum);
		return "redirect:/timeList.action";
	}
}
