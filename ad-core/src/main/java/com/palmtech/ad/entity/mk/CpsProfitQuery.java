package com.palmtech.ad.entity.mk;

import com.common.plugins.myframework.BaseQuery;



public class CpsProfitQuery extends BaseQuery  {

	
	private static final long serialVersionUID = 3821665202362133677L;
  
	java.util.Date calendarBegin;
	java.util.Date calendarEnd;

	String kw;

	String apk;


	public CpsProfitQuery(){
		super();
		super.sortColumns=" calendar asc";
	}


	public java.util.Date getCalendarBegin() {
		return calendarBegin;
	}

	public void setCalendarBegin(java.util.Date calendarBegin) {
		this.calendarBegin = calendarBegin;
	}

	public java.util.Date getCalendarEnd() {
		return calendarEnd;
	}

	public void setCalendarEnd(java.util.Date calendarEnd) {
		this.calendarEnd = calendarEnd;
	}

	public String getKw() {
		return kw;
	}


	public void setKw(String kw) {
		this.kw = kw;
	}


	public String getApk() {
		return apk;
	}


	public void setApk(String apk) {
		this.apk = apk;
	}

	
	
}

