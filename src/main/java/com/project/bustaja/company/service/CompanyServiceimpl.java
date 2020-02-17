package com.project.bustaja.company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.bustaja.company.dao.CompanyDAO;
import com.project.bustaja.company.dao.CompanyVO;

@Service
public class CompanyServiceimpl implements CompanyService{

	@Autowired
	private CompanyDAO dao;
	
	@Override
	public void insertCompany(CompanyVO vo) {
		//이곳에 필요한 작업들이 들어갈 수 있음 상황에 따라서......페이징작업이나 기타 등등의 작업
		dao.insertCompany(vo);
		
	}

	@Override
	public List<CompanyVO> listCompany(int page, int limit) {
		//이곳에 필요한 작업들이 들어갈 수 있음 상황에 따라서......페이징작업이나 기타 등등의 작업
		
		return dao.listCompany(page, limit);	
		
	}

	@Override
	public CompanyVO getCompany() {
		//이곳에 필요한 작업들이 들어갈 수 있음 상황에 따라서......페이징작업이나 기타 등등의 작업
		CompanyVO vo = dao.getCompany();
		return vo;
	}

	@Override
	public void delCompany(long code) {
		//이곳에 필요한 작업들이 들어갈 수 있음 상황에 따라서......페이징작업이나 기타 등등의 작업
		
		dao.delCompany(code);
		
	}

	@Override
	public void updateCompany(CompanyVO vo) {
		//이곳에 필요한 작업들이 들어갈 수 있음 상황에 따라서......페이징작업이나 기타 등등의 작업
		dao.updateCompany(vo);
		
	}

	@Override
	public int getCount() {
		return dao.getCount();
	}
	
}
