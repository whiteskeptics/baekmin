package com.project.bustaja.time.dao;

import java.io.Serializable;

public class TimeVO implements Serializable{
	
	private int routeNum;
	private int company;
	private int seatClass;
	private String startTime;
	private int busNum;
	
	public TimeVO() {
		
	}

	public TimeVO(int routeNum, int company, int seatClass, String startTime, int busNum) {
		super();
		this.routeNum = routeNum;
		this.company = company;
		this.seatClass = seatClass;
		this.startTime = startTime;
		this.busNum = busNum;
	}

	public int getRouteNum() {
		return routeNum;
	}

	public void setRouteNum(int routeNum) {
		this.routeNum = routeNum;
	}

	public int getCompany() {
		return company;
	}

	public void setCompany(int company) {
		this.company = company;
	}

	public int getSeatClass() {
		return seatClass;
	}

	public void setSeatClass(int seatClass) {
		this.seatClass = seatClass;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public int getBusNum() {
		return busNum;
	}

	public void setBusNum(int busNum) {
		this.busNum = busNum;
	}

	@Override
	public String toString() {
		return "TimeVO [routeNum=" + routeNum + ", company=" + company + ", seatClass=" + seatClass + ", startTime="
				+ startTime + ", busNum=" + busNum + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + busNum;
		result = prime * result + company;
		result = prime * result + routeNum;
		result = prime * result + seatClass;
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
		TimeVO other = (TimeVO) obj;
		if (busNum != other.busNum)
			return false;
		if (company != other.company)
			return false;
		if (routeNum != other.routeNum)
			return false;
		if (seatClass != other.seatClass)
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		return true;
	}
	
	
}
