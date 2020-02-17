package com.project.bustaja.company.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.bustaja.company.dao.CompanyVO;

public interface CompanyService {
	void insertCompany(CompanyVO vo); //입력작업
	List<CompanyVO> listCompany(int page, int limit); //전체 조회작업(전체 회사 목록 조회)
	CompanyVO getCompany(); //특정 회사 조회(결과가 1개 나옴)
	void delCompany(long code); //회사 삭제작업
	void updateCompany(CompanyVO vo);
	int getCount();

}
