package com.project.bustaja.terminal.service;

import java.util.List;

import com.project.bustaja.terminal.dao.TerminalVO;

public interface TerminalService {
	void insertTerminal(TerminalVO vo);
	List<TerminalVO> listTerminal(int page, int limit);
	List<TerminalVO> getTerminal();
	void delTerminal(String code);
	void updateTerminal(TerminalVO vo);
	int getCount();


}