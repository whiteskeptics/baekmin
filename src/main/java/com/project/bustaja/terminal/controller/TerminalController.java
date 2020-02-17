package com.project.bustaja.terminal.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.bustaja.terminal.dao.TerminalVO;
import com.project.bustaja.terminal.service.TerminalService;

@Controller
public class TerminalController {

	@Autowired
	private TerminalService terminalService;
	
	@RequestMapping(value = "/terminalList.action", method = RequestMethod.GET)
	public String terminalList(HttpServletRequest req, HttpServletResponse res, Model model) {
		int page = 1;
		int limit = 2;
		if(req.getParameter("page") != null) {
			page = Integer.parseInt(req.getParameter("page"));
		}
		int listCnt = terminalService.getCount();
		
		int startRow = page *2 -1;
		int lastRow = startRow + 2 -1;
		List<TerminalVO> terminalList = terminalService.listTerminal(startRow, lastRow);
		model.addAttribute("listCnt", listCnt);
		model.addAttribute("terminalList", terminalList);
		
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
		
		return "terminalList";
	}

	@RequestMapping(value = "/terminalInsert", method = RequestMethod.GET)
	public String terminalInsert(HttpServletRequest req, HttpServletResponse res, Model model) {
		return "insertTerminal";
	}
	
	@RequestMapping(value = "/terminalInsertaa.action")
	public String terminalInsertaa(HttpServletRequest req, HttpServletResponse res, Model model) {
		res.setCharacterEncoding("utf-8");
		TerminalVO vo = new TerminalVO();
		vo.setTermCode(req.getParameter("termCode"));
		vo.setTermName(req.getParameter("termName"));
		vo.setBusType(req.getParameter("busType"));
		vo.setAddress(req.getParameter("address"));
		vo.setPhone(req.getParameter("phone"));
		vo.setHomepage(req.getParameter("homepage"));
		terminalService.insertTerminal(vo);
		return "redirect:/terminalList.action";
	}
	
	@RequestMapping(value = "/terminalDelete.action", method = RequestMethod.GET)
	public String terminalDelete(HttpServletRequest req, HttpServletResponse res, Model model) {
		String code = req.getParameter("termCode");
		
		terminalService.delTerminal(code);
		return "redirect:/terminalList.action";
	}
	
	@RequestMapping(value = "/getTerminalName.action")
	public String getTerminal(HttpServletRequest req, HttpServletResponse res, Model model) {
		System.out.println("여기까지는 넘어 오는가?+++++++++++++++++++++++");
		List<TerminalVO> list = terminalService.getTerminal();
		model.addAttribute("list",list);
		return "userMain";
	}
	
}
