package com.project.bustaja.travel.dao;

import java.io.Serializable;

public class TravelVO implements Serializable{
	
	private int travelNum;
	private String departure;
	private String destination;
	private String runTime;
	private int distance;
	private int fee;
	private int flatform;
	
	public TravelVO() {
		
	}

	public TravelVO(int travelNum, String departure, String destination, String runTime, int distance, int fee,
			int flatform) {
		super();
		this.travelNum = travelNum;
		this.departure = departure;
		this.destination = destination;
		this.runTime = runTime;
		this.distance = distance;
		this.fee = fee;
		this.flatform = flatform;
	}

	public int getTravelNum() {
		return travelNum;
	}

	public void setTravelNum(int travelNum) {
		this.travelNum = travelNum;
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

	public String getRunTime() {
		return runTime;
	}

	public void setRunTime(String runTime) {
		this.runTime = runTime;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	public int getFlatform() {
		return flatform;
	}

	public void setFlatform(int flatform) {
		this.flatform = flatform;
	}

	@Override
	public String toString() {
		return "TravelVO [travelNum=" + travelNum + ", departure=" + departure + ", destination=" + destination
				+ ", runTime=" + runTime + ", distance=" + distance + ", fee=" + fee + ", flatform=" + flatform + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((departure == null) ? 0 : departure.hashCode());
		result = prime * result + ((destination == null) ? 0 : destination.hashCode());
		result = prime * result + distance;
		result = prime * result + fee;
		result = prime * result + flatform;
		result = prime * result + ((runTime == null) ? 0 : runTime.hashCode());
		result = prime * result + travelNum;
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
		TravelVO other = (TravelVO) obj;
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
		if (distance != other.distance)
			return false;
		if (fee != other.fee)
			return false;
		if (flatform != other.flatform)
			return false;
		if (runTime == null) {
			if (other.runTime != null)
				return false;
		} else if (!runTime.equals(other.runTime))
			return false;
		if (travelNum != other.travelNum)
			return false;
		return true;
	}

	
	
}
