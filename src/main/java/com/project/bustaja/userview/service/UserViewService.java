package com.project.bustaja.userview.service;

import java.util.List;

import com.project.bustaja.userview.dao.PaymentInfoVO;
import com.project.bustaja.userview.dao.UserViewVO;

public interface UserViewService {

	String getTerminalName(String paraStart);

	long getTravelNum(String paraStart, String paraArrive);

	
	List<UserViewVO> getBusTimeInfoList(long travelNum, int time);

	List<Integer> getSetSelect(String startCode, String arriveCode, String startDay, String startTime);

	String getTerminalCode(String startTermName);

	void paymentInsert(PaymentInfoVO vo, String seatNum);

	List<PaymentInfoVO> ticketSearch(String reservationNo);
	
	List<PaymentInfoVO> resCheck(String reservationNo);
	
}
