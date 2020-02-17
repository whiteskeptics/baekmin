package com.project.bustaja.terminal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.bustaja.terminal.dao.TerminalDAO;
import com.project.bustaja.terminal.dao.TerminalVO;

@Service
public class TerminalServiceImpl implements TerminalService{
	
	@Autowired
	private TerminalDAO dao;

	@Override
	public void insertTerminal(TerminalVO vo) {
		// TODO Auto-generated method stub
		dao.insertTerminal(vo);
	}

	@Override
	public List<TerminalVO> listTerminal(int page, int limit) {
		// TODO Auto-generated method stub
		return dao.listTerminal(page, limit);
	}

	@Override
	public List<TerminalVO> getTerminal() {
		List<TerminalVO> list = dao.getTerminal();
		return list;
	}

	@Override
	public void delTerminal(String code) {
		// TODO Auto-generated method stub
		dao.delTerminal(code);
		
	}

	@Override
	public void updateTerminal(TerminalVO vo) {
		// TODO Auto-generated method stub
		dao.updateTerminal(vo);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return dao.getCount();
	}


	
}
