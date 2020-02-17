package com.project.bustaja.notice.service;

import java.util.List;

import com.project.bustaja.notice.dao.NoticeVO;

public interface NoticeService {
	
	void insertNotice(NoticeVO vo);
	
	List<NoticeVO> listNotice(int page, int limit);
	
	NoticeVO getNotice(NoticeVO vo);
	
	void delNotice(int seq);
	
	void updateNotice(NoticeVO vo);
	
	int getCount();

	NoticeVO getNotice(int parseInt);
}
