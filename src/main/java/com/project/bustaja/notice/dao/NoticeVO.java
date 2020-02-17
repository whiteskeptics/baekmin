package com.project.bustaja.notice.dao;

import java.io.Serializable;
import java.util.Date;

public class NoticeVO implements Serializable{
	private int seq;
	private String title;
	private String writer;
	private String ncontents;
	private Date ndate;
	private long ncount;
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getNcontents() {
		return ncontents;
	}
	public void setNcontents(String ncontents) {
		this.ncontents = ncontents;
	}
	public Date getNdate() {
		return ndate;
	}
	public void setNdate(Date date) {
		this.ndate = date;
	}
	public long getNcount() {
		return ncount;
	}
	public void setNcount(long ncount) {
		this.ncount = ncount;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ncontents == null) ? 0 : ncontents.hashCode());
		result = prime * result + (int) (ncount ^ (ncount >>> 32));
		result = prime * result + ((ndate == null) ? 0 : ndate.hashCode());
		result = prime * result + seq;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((writer == null) ? 0 : writer.hashCode());
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
		NoticeVO other = (NoticeVO) obj;
		if (ncontents == null) {
			if (other.ncontents != null)
				return false;
		} else if (!ncontents.equals(other.ncontents))
			return false;
		if (ncount != other.ncount)
			return false;
		if (ndate == null) {
			if (other.ndate != null)
				return false;
		} else if (!ndate.equals(other.ndate))
			return false;
		if (seq != other.seq)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (writer == null) {
			if (other.writer != null)
				return false;
		} else if (!writer.equals(other.writer))
			return false;
		return true;
	}
	public NoticeVO() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "NoticeVO [seq=" + seq + ", title=" + title + ", writer=" + writer + ", ncontents=" + ncontents
				+ ", ndate=" + ndate + ", ncount=" + ncount + "]";
	}
	
	
	
}
