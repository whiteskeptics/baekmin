package com.project.bustaja.userview.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.bustaja.userview.dao.PaymentInfoVO;
import com.project.bustaja.userview.dao.UserViewDAO;
import com.project.bustaja.userview.dao.UserViewVO;

@Service
public class UserViewServiceImpl implements UserViewService {

	@Autowired
	private UserViewDAO dao;
//	
	@Override
	public String getTerminalName(String paraStart) {
		
		return dao.getTerminalName(paraStart);
	}
//
	@Override
	public long getTravelNum(String paraStart, String paraArrive) {
		// TODO Auto-generated method stub
		return dao.getTravelNum(paraStart, paraArrive);
	}
//
	@Override
	public List<UserViewVO> getBusTimeInfoList(long travelNum, int time) {
		
		return dao.getBusTimeInfoList(travelNum, time);
	}
	
	@Override
	public List<Integer> getSetSelect(String startCode, String arriveCode, String startDay, String startTime) {
		// TODO Auto-generated method stub
		return dao.getSetSelect(startCode, arriveCode,startDay,startTime);
	}
	@Override
	public String getTerminalCode(String startTermName) {
		// TODO Auto-generated method stub
		return dao.getTerminalCode(startTermName);
	}
	@Override
	public void paymentInsert(PaymentInfoVO vo, String seatNum) {
		dao.paymentInsert(vo, seatNum);
	}
	@Override
	public List<PaymentInfoVO> ticketSearch(String reservationNo) {
		
		return dao.ticketSearch(reservationNo);
	}
	@Override
	public List<PaymentInfoVO> resCheck(String reservationNo) {
		
		return dao.resCheck(reservationNo);
	}


}
