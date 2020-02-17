package com.project.bustaja.travel.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.bustaja.company.dao.CompanyVO;
import com.project.bustaja.terminal.dao.TerminalVO;
import com.project.bustaja.travel.dao.TravelVO;
import com.project.bustaja.travel.service.TravelService;

@Controller
public class TravelController {
	
	@Autowired
	private TravelService travelService;
	
	@RequestMapping(value = "/travleList.action", method = RequestMethod.GET)
	public String travelList(HttpServletRequest req, HttpServletResponse res, Model model) {
//		System.out.println("이곳은 운행노선 관련 컨트롤러이며... 운행노선 리스트를 출력하기 위한 곳임.....");
		int page = 1; 
		int limit = 2;
		if(req.getParameter("page") != null) {
			page = Integer.parseInt( req.getParameter("page") );
		}
		
		int listCnt = travelService.getCount();
		System.out.println("자료의 개수 : " + listCnt);
		int startRow = page *2 -1;
		int lastRow = startRow + 2 -1;
		List<TravelVO> travelList = travelService.listTravel(startRow, lastRow);
		model.addAttribute("listCnt", listCnt);
		model.addAttribute("travelList", travelList); //가져온 자료가 담김
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
		
		return "travelList";
	}
	
	@RequestMapping(value = "/travelInsert.action", method = RequestMethod.GET)
	public String travelInsert(HttpServletRequest req, HttpServletResponse res, Model model) {
//		
		
		return "insertTravel";
	}
	
	@RequestMapping(value = "/insertTravelaa.action")
	public String travelInsertaa(HttpServletRequest req, HttpServletResponse res, Model model) {
		
		
		res.setCharacterEncoding("utf-8");
		TravelVO vo = new TravelVO();
		vo.setTravelNum(Integer.parseInt(req.getParameter("travelNum")));
		vo.setDeparture(req.getParameter("departure"));
		vo.setDestination(req.getParameter("destination"));
		vo.setRunTime(req.getParameter("runTime"));
		vo.setDistance(Integer.parseInt(req.getParameter("distance")));
		vo.setFee(Integer.parseInt(req.getParameter("fee")));
		vo.setFlatform(Integer.parseInt(req.getParameter("flatform")));
		
		travelService.insertTravel(vo);
		return "redirect:/travleList.action";
	}
	
	@RequestMapping(value = "/traveldelete.action", method = RequestMethod.GET)
	public String travelDelete(HttpServletRequest req, HttpServletResponse res, Model model) {
		int travelNum = Integer.parseInt( req.getParameter("travelNum"));
		
		travelService.delTravel(travelNum);
		return "redirect:/travleList.action";
	}
	

	
}
