package com.project.bustaja.terminal.dao;

import java.io.Serializable;

public class TerminalVO implements Serializable{
	private String termCode;
	private String termName;
	private String busType;
	private String address;
	private String phone;
	private String homepage;
	
	public TerminalVO() {
		
	}

	public TerminalVO(String termCode, String termName, String busType, String address, String phone, String homepage) {
		super();
		this.termCode = termCode;
		this.termName = termName;
		this.busType = busType;
		this.address = address;
		this.phone = phone;
		this.homepage = homepage;
	}

	public String getTermCode() {
		return termCode;
	}

	public void setTermCode(String termCode) {
		this.termCode = termCode;
	}

	public String getTermName() {
		return termName;
	}

	public void setTermName(String termName) {
		this.termName = termName;
	}

	public String getBusType() {
		return busType;
	}

	public void setBusType(String busType) {
		this.busType = busType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	@Override
	public String toString() {
		return "TerminalVO [termCode=" + termCode + ", termName=" + termName + ", busType=" + busType + ", address="
				+ address + ", phone=" + phone + ", homepage=" + homepage + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((busType == null) ? 0 : busType.hashCode());
		result = prime * result + ((homepage == null) ? 0 : homepage.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((termCode == null) ? 0 : termCode.hashCode());
		result = prime * result + ((termName == null) ? 0 : termName.hashCode());
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
		TerminalVO other = (TerminalVO) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (busType == null) {
			if (other.busType != null)
				return false;
		} else if (!busType.equals(other.busType))
			return false;
		if (homepage == null) {
			if (other.homepage != null)
				return false;
		} else if (!homepage.equals(other.homepage))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (termCode == null) {
			if (other.termCode != null)
				return false;
		} else if (!termCode.equals(other.termCode))
			return false;
		if (termName == null) {
			if (other.termName != null)
				return false;
		} else if (!termName.equals(other.termName))
			return false;
		return true;
	}
	
	
}
