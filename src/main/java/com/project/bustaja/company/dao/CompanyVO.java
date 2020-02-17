package com.project.bustaja.company.dao;

import java.io.Serializable;

public class CompanyVO implements  Serializable{
	private long companyCode;
	private String companyName;
	
	public CompanyVO() {
		
	}
	
	public CompanyVO(long companyCode, String companyName) {
		super();
		this.companyCode = companyCode;
		this.companyName = companyName;
	}
	public long getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(long companyCode) {
		this.companyCode = companyCode;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	@Override
	public String toString() {
		return "CompanyVO [companyCode=" + companyCode + ", companyName=" + companyName + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (companyCode ^ (companyCode >>> 32));
		result = prime * result + ((companyName == null) ? 0 : companyName.hashCode());
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
		CompanyVO other = (CompanyVO) obj;
		if (companyCode != other.companyCode)
			return false;
		if (companyName == null) {
			if (other.companyName != null)
				return false;
		} else if (!companyName.equals(other.companyName))
			return false;
		return true;
	}
	
	
	
	
	
}
