package com.project.bustaja.userview.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.project.bustaja.terminal.dao.TerminalRowMapper;
import com.project.bustaja.terminal.dao.TerminalVO;
import com.project.bustaja.time.dao.TimeRowMapper;
import com.project.bustaja.time.dao.TimeVO;
import com.project.bustaja.travel.dao.TravelRowMapper;
import com.project.bustaja.travel.dao.TravelVO;

@Repository
public class UserViewDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public String getTerminalName(String termCode) {
		String sql = "select * from Terminal where termCode = ?";
		List<TerminalVO> list = (List<TerminalVO>) jdbcTemplate.query(sql, new Object[] {termCode}, new TerminalRowMapper());
		return list.get(0).getTermName();



	}

	public long getTravelNum(String paraStart, String paraArrive) {
		String sql = "select * from TravelInfo where departure  = ? and destination = ?";
		List<TravelVO> list = (List<TravelVO>) jdbcTemplate.query(sql, new Object[] {paraStart, paraArrive}, new TravelRowMapper());
		return list.get(0).getTravelNum();
	}

	public List<UserViewVO> getBusTimeInfoList(long travelNum, int time) {
//		String col = ":";

		StringBuffer sql = new StringBuffer();
		
			sql.append("select routeNum, starttime, seatclass, companyName, companyCode, seatName, seatCNT, weight * fee as busPrice, distance, runTime from ");
			sql.append("(select * from bustimeinfo where routeNum = ? and to_number(  concat( substr(starttime, 1, instr(startTime, ':', 1)-1), substr(starttime, instr(startTime, ':', 1)+1) )  ) >= ?) aa, " );
			sql.append("company bb, ");
			sql.append("seatclass cc, ");
			sql.append("travelInfo dd ");
			sql.append("where aa.company = bb.companyCode ");
			sql.append("and aa.seatclass = cc.seatcode ");
			sql.append("and aa.routeNum = dd.travelNum ");

		List<UserViewVO> list = jdbcTemplate.query(sql.toString(), new Object[] {travelNum, time}, new UserViewRowMapper());
		return list;
	}

	public List<Integer> getSetSelect(String startCode, String arriveCode,  String startDay, String startTime) {
		String sql = "select seatNum from paymentInfo where departure = ? and destination=? and starttime = ? and startday = ?";
		List<Integer> list =  jdbcTemplate.query(sql,  new Object[] {startCode, arriveCode, startTime, startDay }, new RowMapper<Integer>() {

			@Override
			public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Integer( rs.getInt("seatNum") );
			}
			
		} );
		return list;
	}

	public String getTerminalCode(String startTermName) {
		
		String sql = "select termCode from terminal where termName = ?";
		String termName = jdbcTemplate.queryForObject(sql,  new Object[] {startTermName}, new RowMapper<String>() {

			@Override
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getString("termCode");
			}
			
		} );
		return termName;
	}

	public void paymentInsert(PaymentInfoVO vo, String seatNum) {
		String sql = "insert into paymentinfo values( paymentInfo_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ? )";
		jdbcTemplate.update(sql, vo.getReservationNo(), vo.getUserId(), vo.getDeparture(), vo.getDestination(), vo.getStartDay(), vo.getStartTime(), seatNum, vo.getBusPrice());
		
		return;
	}

	public List<PaymentInfoVO> ticketSearch(String reservationNo) {
		String sql = "select * from paymentInfo where reservationNo = ? ";
		
		List<PaymentInfoVO> list = jdbcTemplate.query(sql,  new Object[] { reservationNo}, new RowMapper<PaymentInfoVO>() {

			@Override
			public PaymentInfoVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				PaymentInfoVO vo = new PaymentInfoVO();
				vo.setBusPrice(rs.getLong("BusPrice"));
				vo.setDeparture(rs.getString("Departure"));
				vo.setDestination(rs.getString("Destination"));
				vo.setReservationNo(rs.getString("ReservationNo"));
				vo.setSeatNum(rs.getInt("SeatNum"));
				vo.setStartDay(rs.getString("startday"));
				vo.setStartTime(rs.getString("startTime"));
				return vo;
			}
			
		} );
		return list;
	}

	public List<PaymentInfoVO> resCheck(String reservationNo) {
		String sql = "select * from paymentInfo where reservationNo = ? ";
		
		List<PaymentInfoVO> list = jdbcTemplate.query(sql,  new Object[] { reservationNo}, new RowMapper<PaymentInfoVO>() {

			@Override
			public PaymentInfoVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				PaymentInfoVO vo = new PaymentInfoVO();
				vo.setBusPrice(rs.getLong("BusPrice"));
				vo.setDeparture(rs.getString("Departure"));
				vo.setDestination(rs.getString("Destination"));
				vo.setReservationNo(rs.getString("ReservationNo"));
				vo.setSeatNum(rs.getInt("SeatNum"));
				vo.setStartDay(rs.getString("startday"));
				vo.setStartTime(rs.getString("startTime"));
				return vo;
			}
			
		} );
		return list;
	}

	
}
