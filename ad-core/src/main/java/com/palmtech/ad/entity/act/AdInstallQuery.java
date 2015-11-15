package com.palmtech.ad.entity.act;

import com.common.plugins.myframework.BaseQuery;



public class AdInstallQuery extends BaseQuery  {
    private static final long serialVersionUID = 3148176768559230877L;
   
    Long clientId;
    String ad;
    java.util.Date calendarBegin;
    java.util.Date calendarEnd;
	public Long getClientId() {
		return clientId;
	}
	public void setClientId(Long clientId) {
		this.clientId = clientId;
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
	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}
   
}

