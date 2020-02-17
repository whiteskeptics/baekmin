package com.project.bustaja.userview.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.bustaja.userview.dao.PaymentInfoVO;
import com.project.bustaja.userview.dao.UserViewVO;
import com.project.bustaja.userview.service.UserViewService;

@Controller
public class UserViewController {
	@Autowired
	private UserViewService userViewService;
	
	@RequestMapping(value = "/travelInfo.action")
	public String getTerminal(HttpServletRequest req, HttpServletResponse res, Model model) {
		System.out.println("여기까지는 넘어 오는가?+++++++++++++++++++++++");
		String paraStart = req.getParameter("start");
		String paraArrive = req.getParameter("arrive");
		String paraDay = req.getParameter("date");
		String paraTime= req.getParameter("time");
		String returnValue = "travelInfo";
		
		// String terminalName = db에서  출발지 터미널 명 구해서 속성에 저장함
		
		//데이터베이스의 특정시간 및 분 보다 이후의 버스 노선을 조회하기 위한 자료 만들기
		int time = Integer.parseInt(paraTime.substring(0,paraTime.indexOf(':') )+paraTime.substring(paraTime.indexOf(':')+1 )  );
		
		
//		System.out.println("시간 : " + hour + "=========================== qns : " + minute) ;
		
		
		
		
		String startTermName = userViewService.getTerminalName(paraStart);
		// String terminalName = db에서  목적지 터미널 명 구해서 속성에 저장함
		String arriveTermName = userViewService.getTerminalName(paraArrive);
		// 터미널 코드를 이용하여 트래벌넘버를 구해온다. = 변수에 담는다
		System.out.println("+++++++" + startTermName + "=========" + arriveTermName + "컨트롤러");
		long travelNum = 0;
		try {
			travelNum = userViewService.getTravelNum(paraStart, paraArrive);
			
		}catch (IndexOutOfBoundsException e) {
			System.out.println("지정한 경로의 노선이 존재하지 않습니다. 다시 확인하시기 바랍니다.");
			returnValue = "redirect:/getTerminalName.action";
		}
		
		
		// 버스타임인포테이블에서 해당 트래벌넘버의 정보를 추출하는 리스트를 구한다.
		List<UserViewVO> list = userViewService.getBusTimeInfoList(travelNum, time);
		
//		System.out.println(list.size() == 2 ? "okay good" : "========================");
		
		// 컴퍼니명에 따른 회사명을 구한다.
	// 좌석 등급에 따른 정보를 얻는다.
		// 차량번호에 따른 좌석수를 구한다.
		//해당 선택 시간에 남은 좌석수를 확인한다 =?
		
//		List<TravelVO> list = travelService.getTravel();
		model.addAttribute("list",list);
		model.addAttribute("startTermName", startTermName);
		model.addAttribute("arriveTermName", arriveTermName);
		model.addAttribute("start", paraStart);
		model.addAttribute("arrive", paraArrive);
		model.addAttribute("startDay", paraDay);
		
		return returnValue;
	}
	@RequestMapping(value = "/seatSelect.action")
	public String getSeatSelect(HttpServletRequest req, HttpServletResponse res, Model model) {
		int totalSeat = Integer.parseInt( req.getParameter("totalSeat") );//총 좌석 수
		String startCode =  req.getParameter("start"); //출발 터미널 코드
		String arriveCode = req.getParameter("arrive"); //도착 터미널 코드
		String startTime = req.getParameter("startTime"); // 출발 시간
		String startDay = req.getParameter("startDay"); //출발일자
		long busPrice = Long.parseLong( req.getParameter("busPrice") ); //가격
		
		List<Integer> seatSelectList = userViewService.getSetSelect(startCode, arriveCode,startDay, startTime);
		
		model.addAttribute("startCode", startCode);
		model.addAttribute("arriveCode", arriveCode);
		model.addAttribute("startTime", startTime);
		model.addAttribute("seatSelectList", seatSelectList);
		model.addAttribute("totalSeat", totalSeat);
		model.addAttribute("busPrice", busPrice);
		model.addAttribute("startDay", startDay);
		return "seatSelectLayout"; 
	}
	
	@RequestMapping(value = "/paymentInfo.action")
	public String getPayment(HttpServletRequest req, HttpServletResponse res, Model model) {
		
		System.out.println(req.getParameter("startCode"));
		String[] seatNum = req.getParameterValues("seatNum");
		String startCode =  req.getParameter("startCode"); //출발 터미널 코드
		String arriveCode = req.getParameter("arriveCode"); //도착 터미널 코드
		String startTime = req.getParameter("startTime"); // 출발 시간
		String startDay = req.getParameter("startDay"); // 출발 일자
		long busPrice = Long.parseLong( req.getParameter("busPrice") ); //가격
		
		System.out.println("dkdkf" + startCode + "==" + arriveCode + "==" + startTime + " " + busPrice);
		
		
		//db에서 startcode에 따른 출발지명 구하고 arrivecode에 따라서 도착지명 구한다.
		

		String startTermName = userViewService.getTerminalName(startCode);
		// String terminalName = db에서  목적지 터미널 명 구해서 속성에 저장함
		String arriveTermName = userViewService.getTerminalName(arriveCode);
		
		//출발날짜, 출발시간, 좌석번호, 결제금액= 요금*좌석 배열수
		
		model.addAttribute("startDay", startDay); //출발일 =
		model.addAttribute("seatNum", seatNum); //좌석번호(배열)
		model.addAttribute("startTermName", startTermName); //출발지 터미널 명
		model.addAttribute("arriveTermName", arriveTermName); //도착지 터미널 명
		model.addAttribute("startTime", startTime); //출발시간
		model.addAttribute("busPrice", busPrice); //버스요금
		
		return "payment";
	}
	
	@RequestMapping(value = "/paymentInsert.action")
	public String paymentInsert(HttpServletRequest req, HttpServletResponse res, Model model) {
		
		String userId = (String)req.getSession().getAttribute("userName"); //넘겨주지 않음으로 널이다....
		String startTermName = req.getParameter("startTermName"); //코드로 저장
		String arriveTermName = req.getParameter("arriveTermName"); //코드로 저장
		String startDay = req.getParameter("startDay"); //저장
		String startTime = req.getParameter("startTime"); //저장
		long busPrice = Long.parseLong(  req.getParameter("busPrice")  );
		String[]  seatNum = req.getParameterValues("seatNum"); //저장
		System.out.println("jfdksljafjdsklafdsklajfdkslafjdskla " + startTermName);
		//부족한 자료를 이용하여 필요한 자료 생성
		System.out.println(System.currentTimeMillis() +  " ========================= " + startDay);
		String departure = userViewService.getTerminalCode(startTermName); //터미널 명 얻어오기
		String destination = userViewService.getTerminalCode(arriveTermName); //도착 터미널 명 얻어오기
		String reservationNo = ""+System.currentTimeMillis(); //고유발권번호 만들기
		if(userId == null) userId="guest";
		
		
		
		PaymentInfoVO vo = new PaymentInfoVO();
//		vo.setBusPrice(busPrice);
		vo.setReservationNo(reservationNo);
		vo.setStartDay(startDay);
//		vo.setSeatNum(seatNum);
		vo.setStartTime(startTime);
		vo.setUserId(userId);
		vo.setDeparture(departure);
		vo.setDestination(destination);
		vo.setBusPrice(busPrice);
		System.out.println("===  " + vo.toString());
		for(int i = 0; i <seatNum.length; i++ ) {
			userViewService.paymentInsert(vo, seatNum[i]);
		}
		System.out.println("+========++++++모델이전");
		model.addAttribute("insertResult", vo);
		model.addAttribute("insertSeatNum", seatNum);
		
		System.out.println("모델이후+=+====================");
		return "resultTicket";
	}
	
	@RequestMapping(value = "/ticketSearch.action")
	public String ticketSearch(HttpServletRequest req, HttpServletResponse res, Model model) {
		
		String reservationNo = req.getParameter("reservationNo"); //저장
		List<PaymentInfoVO> list = userViewService.ticketSearch(reservationNo);
		model.addAttribute("list", list);
		return "resultSearchTicket";
	}
	
	@RequestMapping(value = "/ResSearch.action")
	public String resSearch(HttpServletRequest req, HttpServletResponse res, Model model) {
		
		String reservationNo = req.getParameter("reservationNo"); //저장
		List<PaymentInfoVO> list = userViewService.ticketSearch(reservationNo);
		model.addAttribute("list", list);
		return "reservationTicket";
	}
	
	@RequestMapping(value = "/rescheck.action")
	public String resCheck(HttpServletRequest req, HttpServletResponse res, Model model) {
		
		String reservationNo = req.getParameter("reservationNo"); //저장
		List<PaymentInfoVO> list = userViewService.ticketSearch(reservationNo);
		model.addAttribute("list", list);
		return "resultSearchTicket";
	}
}
