package com.project.bustaja.userview.dao;

import java.io.Serializable;

public class UserViewVO implements Serializable{//최종적으로 나와야 할 정보를 담은 객체
	private int routeNum; //경로 고유번호
	private String startTime; //출발시간
	private int seatClass; //좌석등급코드
	private String companyName; //운송회사명
	private long companyCode; //운송회사 코드
	private String seatName; //좌석등급명
	private int seatCnt; //좌석 등급에 다른 전체 좌석 수
	private long busPrice; //좌석 등급에 따른 요금
	private long distance; //거리
	private String runTime; // 소요시간
	
	private String startTerminalName; //출발터미널명
	private String arriveTerminalName; //도착 터미널 명
	public int getRouteNum() {
		return routeNum;
	}
	public void setRouteNum(int routeNum) {
		this.routeNum = routeNum;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public int getSeatClass() {
		return seatClass;
	}
	public void setSeatClass(int seatClass) {
		this.seatClass = seatClass;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public long getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(long companyCode) {
		this.companyCode = companyCode;
	}
	public String getSeatName() {
		return seatName;
	}
	public void setSeatName(String seatName) {
		this.seatName = seatName;
	}
	public int getSeatCnt() {
		return seatCnt;
	}
	public void setSeatCnt(int seatCnt) {
		this.seatCnt = seatCnt;
	}
	public long getBusPrice() {
		return busPrice;
	}
	public void setBusPrice(long busPrice) {
		this.busPrice = busPrice;
	}
	public long getDistance() {
		return distance;
	}
	public void setDistance(long distance) {
		this.distance = distance;
	}
	public String getRunTime() {
		return runTime;
	}
	public void setRunTime(String runTime) {
		this.runTime = runTime;
	}
	public String getStartTerminalName() {
		return startTerminalName;
	}
	public void setStartTerminalName(String startTerminalName) {
		this.startTerminalName = startTerminalName;
	}
	public String getArriveTerminalName() {
		return arriveTerminalName;
	}
	public void setArriveTerminalName(String arriveTerminalName) {
		this.arriveTerminalName = arriveTerminalName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arriveTerminalName == null) ? 0 : arriveTerminalName.hashCode());
		result = prime * result + (int) (busPrice ^ (busPrice >>> 32));
		result = prime * result + (int) (companyCode ^ (companyCode >>> 32));
		result = prime * result + ((companyName == null) ? 0 : companyName.hashCode());
		result = prime * result + (int) (distance ^ (distance >>> 32));
		result = prime * result + routeNum;
		result = prime * result + ((runTime == null) ? 0 : runTime.hashCode());
		result = prime * result + seatClass;
		result = prime * result + seatCnt;
		result = prime * result + ((seatName == null) ? 0 : seatName.hashCode());
		result = prime * result + ((startTerminalName == null) ? 0 : startTerminalName.hashCode());
		result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
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
		UserViewVO other = (UserViewVO) obj;
		if (arriveTerminalName == null) {
			if (other.arriveTerminalName != null)
				return false;
		} else if (!arriveTerminalName.equals(other.arriveTerminalName))
			return false;
		if (busPrice != other.busPrice)
			return false;
		if (companyCode != other.companyCode)
			return false;
		if (companyName == null) {
			if (other.companyName != null)
				return false;
		} else if (!companyName.equals(other.companyName))
			return false;
		if (distance != other.distance)
			return false;
		if (routeNum != other.routeNum)
			return false;
		if (runTime == null) {
			if (other.runTime != null)
				return false;
		} else if (!runTime.equals(other.runTime))
			return false;
		if (seatClass != other.seatClass)
			return false;
		if (seatCnt != other.seatCnt)
			return false;
		if (seatName == null) {
			if (other.seatName != null)
				return false;
		} else if (!seatName.equals(other.seatName))
			return false;
		if (startTerminalName == null) {
			if (other.startTerminalName != null)
				return false;
		} else if (!startTerminalName.equals(other.startTerminalName))
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "UserViewVO [routeNum=" + routeNum + ", startTime=" + startTime + ", seatClass=" + seatClass
				+ ", companyName=" + companyName + ", companyCode=" + companyCode + ", seatName=" + seatName
				+ ", seatCnt=" + seatCnt + ", busPrice=" + busPrice + ", distance=" + distance + ", runTime=" + runTime
				+ ", startTerminalName=" + startTerminalName + ", arriveTerminalName=" + arriveTerminalName + "]";
	}
	
	
}
