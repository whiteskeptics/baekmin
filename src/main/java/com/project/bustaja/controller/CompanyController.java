package com.project.bustaja.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.bustaja.company.dao.CompanyVO;
import com.project.bustaja.company.service.CompanyService;

@Controller
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	
	@RequestMapping(value = "/companyList.action", method = RequestMethod.GET)
	public String companyList(HttpServletRequest req, HttpServletResponse res, Model model) {
//		System.out.println("이곳은 운송회사 관련 컨트롤러이며... 운송회사 리스트를 출력하기 위한 곳임.....");
		int page = 1; 
		int limit = 2;
		if(req.getParameter("page") != null) {
			page = Integer.parseInt( req.getParameter("page") );
		}
		
		int listCnt = companyService.getCount();
//		System.out.println("자료의 개수 : " + listCnt);
		int startRow = page *2 -1;
		int lastRow = startRow + 2 -1;
		List<CompanyVO> companyList = companyService.listCompany(startRow, lastRow);
		model.addAttribute("listCnt", listCnt);
		model.addAttribute("companyList", companyList); //가져온 자료가 담김
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
		
		return "companyList";
	}
	
	@RequestMapping(value = "/companyInsrt.action", method = RequestMethod.GET)
	public String companyInsert(HttpServletRequest req, HttpServletResponse res, Model model) {
//		
		
		return "insertCompany";
	}
	@RequestMapping(value = "/insertCompanyaa.action")
	public String companyInsertaa(HttpServletRequest req, HttpServletResponse res, Model model) {
		
		
		res.setCharacterEncoding("utf-8");
		CompanyVO vo = new CompanyVO();
		vo.setCompanyCode(Long.parseLong(req.getParameter("companyCode")));
		vo.setCompanyName(req.getParameter("companyName"));
		companyService.insertCompany(vo);
		return "redirect:/companyList.action";
	}
	
	@RequestMapping(value = "/companydelete.action", method = RequestMethod.GET)
	public String companyDelete(HttpServletRequest req, HttpServletResponse res, Model model) {
		long code = Long.parseLong( req.getParameter("companyCode") );
		
		companyService.delCompany(code);
		return "redirect:/companyList.action";
	}
	
}
