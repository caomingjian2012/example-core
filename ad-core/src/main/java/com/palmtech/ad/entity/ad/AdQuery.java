package com.palmtech.ad.entity.ad;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.common.plugins.myframework.BaseQuery;



public class AdQuery extends BaseQuery  {
    private static final long serialVersionUID = 3148176768559230877L;
   
    String kw;
    String adcd;
    java.util.Date calendarBegin;
    java.util.Date calendarEnd;
    Integer type;
    Integer  state;
    
    
	public String getAdcd() {
		return adcd;
	}


	public void setAdcd(String adcd) {
		this.adcd = adcd;
	}


	public String getKw() {
		return kw;
	}


	public void setKw(String kw) {
		this.kw = kw;
	}
	

	public Integer getType() {
		return type;
	}


	public void setType(Integer type) {
		this.type = type;
	}

	

	public Integer getState() {
		return state;
	}


	public void setState(Integer state) {
		this.state = state;
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


	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

