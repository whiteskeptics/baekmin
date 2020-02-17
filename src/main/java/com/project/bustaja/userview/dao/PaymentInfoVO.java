package com.project.bustaja.userview.dao;

import java.io.Serializable;

public class PaymentInfoVO implements Serializable{
	
	private long seq;
	private String reservationNo;
	private String userId;
	private String departure;
	private String destination;
	private String startDay;
	private String startTime;
	private int seatNum;
	private long busPrice;
	public long getSeq() {
		return seq;
	}
	public void setSeq(long seq) {
		this.seq = seq;
	}
	public String getReservationNo() {
		return reservationNo;
	}
	public void setReservationNo(String reservationNo) {
		this.reservationNo = reservationNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getDeparture() {
		return departure;
	}
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getStartDay() {
		return startDay;
	}
	public void setStartDay(String startDay) {
		this.startDay = startDay;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	
	public long getBusPrice() {
		return busPrice;
	}
	public void setBusPrice(long busPrice) {
		this.busPrice = busPrice;
	}
	public int getSeatNum() {
		return seatNum;
	}
	public void setSeatNum(int seatNum) {
		this.seatNum = seatNum;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (busPrice ^ (busPrice >>> 32));
		result = prime * result + ((departure == null) ? 0 : departure.hashCode());
		result = prime * result + ((destination == null) ? 0 : destination.hashCode());
		result = prime * result + ((reservationNo == null) ? 0 : reservationNo.hashCode());
		result = prime * result + seatNum;
		result = prime * result + (int) (seq ^ (seq >>> 32));
		result = prime * result + ((startDay == null) ? 0 : startDay.hashCode());
		result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PaymentInfoVO other = (PaymentInfoVO) obj;
		if (busPrice != other.busPrice)
			return false;
		if (departure == null) {
			if (other.departure != null)
				return false;
		} else if (!departure.equals(other.departure))
			return false;
		if (destination == null) {
			if (other.destination != null)
				return false;
		} else if (!destination.equals(other.destination))
			return false;
		if (reservationNo == null) {
			if (other.reservationNo != null)
				return false;
		} else if (!reservationNo.equals(other.reservationNo))
			return false;
		if (seatNum != other.seatNum)
			return false;
		if (seq != other.seq)
			return false;
		if (startDay == null) {
			if (other.startDay != null)
				return false;
		} else if (!startDay.equals(other.startDay))
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PaymentInfoVO [seq=" + seq + ", reservationNo=" + reservationNo + ", userId=" + userId + ", departure="
				+ departure + ", destination=" + destination + ", startDay=" + startDay + ", startTime=" + startTime
				+ ", seatNum=" + seatNum + ", busPrice=" + busPrice + "]";
	}
	
	
	
	

}
