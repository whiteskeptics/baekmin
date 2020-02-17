package com.project.bustaja.notice.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.bustaja.notice.dao.NoticeVO;
import com.project.bustaja.notice.service.NoticeService;

@Controller
public class NoticeController {
	
	@Autowired
	private NoticeService noticeservice;
	
	@RequestMapping(value = "/noticeList.action", method = RequestMethod.GET)
	public String NoticeList(HttpServletRequest req, HttpServletResponse res, Model model) {
		int page = 1;
		int limit = 2;
		if(req.getParameter("page") != null) {
			page = Integer.parseInt(req.getParameter("page"));
		}
		int listCnt = noticeservice.getCount();
		
		int startRow = page *2 -1;
		int lastRow = startRow + 2 -1;
		
		List<NoticeVO> noticeList = noticeservice.listNotice(startRow, lastRow);
		model.addAttribute("listCnt", listCnt);
		model.addAttribute("noticeList", noticeList);
		
		int maxPage = listCnt/limit + ((listCnt%limit != 0)? 1 : 0);
		int startPage = (page /10)+1 ;
		int endPage = startPage + 9;
		if(endPage > maxPage) endPage = maxPage;
		//계산된 결과를 속성에 넣어줌
		model.addAttribute("page",page);
		model.addAttribute("maxPage",maxPage);
		model.addAttribute("startPage",startPage);
		model.addAttribute("endPage",endPage);
		
		return "noticeList";
	}
	
	@RequestMapping(value = "/noticeInsert", method = RequestMethod.GET)
	public String noticeInsert(HttpServletRequest req, HttpServletResponse res, Model model) {
		return "insertNoitce";
	}
	
	@RequestMapping(value = "/noticeInsertaa.action", method = RequestMethod.GET)
	public String noticeInsertaa(HttpServletRequest req, HttpServletResponse res, Model model) {
		res.setCharacterEncoding("utf-8");
		NoticeVO vo = new NoticeVO();
		
		vo.setTitle(req.getParameter("title"));
		vo.setWriter(req.getParameter("writer"));
		vo.setNcontents(req.getParameter("nContents"));
		
		noticeservice.insertNotice(vo);
		return "redirect:/noticeList.action";
	}
	
	@RequestMapping(value = "/noticedelete.action", method = RequestMethod.GET)
	public String noticeDelete(HttpServletRequest req, HttpServletResponse res, Model model) {
		int seq = Integer.parseInt(req.getParameter("seq"));
		
		noticeservice.delNotice(seq);
		return "redirect:/noticeList.action";
	}
	
	@RequestMapping(value = "/getNotice.action")
	public String getNotice(NoticeVO vo, Model model) throws Exception{
		model.addAttribute("getNotice", noticeservice.getNotice(vo));
		return "getNotice";
	}
	
	@RequestMapping(value = "/updateNotice.action")
	public String updateNotice(HttpServletRequest req, Model model) throws Exception{
	

		NoticeVO vo  = noticeservice.getNotice(Integer.parseInt( req.getParameter("seq") )  );
		model.addAttribute("vo", vo);		
		return "updateNotice";
	}
	@RequestMapping(value = "/updateNoticeImpl.action")
	public String updateNoticeImpl(HttpServletRequest req, Model model) throws Exception{
		

		NoticeVO vo  = new NoticeVO();
		vo.setSeq(Integer.parseInt(req.getParameter("seq")));
		vo.setTitle(req.getParameter("title"));
		vo.setNcontents(req.getParameter("ncontents"));
		noticeservice.updateNotice(vo);
		return "redirect:/noticeList.action";
	}
	
}
