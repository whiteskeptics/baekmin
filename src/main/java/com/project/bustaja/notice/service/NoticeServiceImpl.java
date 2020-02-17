package com.project.bustaja.notice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.bustaja.notice.dao.NoticeDAO;
import com.project.bustaja.notice.dao.NoticeVO;

@Service
public class NoticeServiceImpl implements NoticeService{

	@Autowired
	private NoticeDAO dao;
	
	@Override
	public void insertNotice(NoticeVO vo) {
		dao.insertNotice(vo);
		
	}

	@Override
	public List<NoticeVO> listNotice(int page, int limit) {
		return dao.listNotice(page, limit);
	}

	@Override
	public NoticeVO getNotice(NoticeVO vo) {
		return dao.getNotice(vo);
	}

	@Override
	public void delNotice(int seq) {
		dao.delNotice(seq);
		
	}

	@Override
	public void updateNotice(NoticeVO vo) {
		dao.updateNotice(vo);
	}

	@Override
	public int getCount() {
		return dao.getCount();
	}

	@Override
	public NoticeVO getNotice(int seq) {
		// TODO Auto-generated method stub
		return dao.getNotice(seq);
	}
	
}
