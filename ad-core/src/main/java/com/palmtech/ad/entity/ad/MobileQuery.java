package com.palmtech.ad.entity.ad;

import java.util.Date;

import com.common.plugins.myframework.BaseQuery;



public class MobileQuery extends BaseQuery  {
    private static final long serialVersionUID = 3148176768559230877L;
   
    String uuid;
    String kw;
    Date calendarBegin;
    Date calendarEnd;
    
    
	public String getKw() {
		return kw;
	}
	public void setKw(String kw) {
		this.kw = kw;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public Date getCalendarBegin() {
		return calendarBegin;
	}
	public void setCalendarBegin(Date calendarBegin) {
		this.calendarBegin = calendarBegin;
	}
	public Date getCalendarEnd() {
		return calendarEnd;
	}
	public void setCalendarEnd(Date calendarEnd) {
		this.calendarEnd = calendarEnd;
	}
	@Override
	public String toString() {
		return "MobileQuery [uuid=" + uuid + ", calendarBegin=" + calendarBegin
				+ ", calendarEnd=" + calendarEnd + "]";
	}
    
	
	
}

