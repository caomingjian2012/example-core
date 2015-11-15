package com.palmtech.ad.entity.st;

import com.common.plugins.myframework.BaseQuery;



public class StApkDailyQuery extends BaseQuery  {
    private static final long serialVersionUID = 3148176768559230877L;
   
   
    String kw;
    java.util.Date calendarBegin;
    java.util.Date calendarEnd;
	 
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
	
}

