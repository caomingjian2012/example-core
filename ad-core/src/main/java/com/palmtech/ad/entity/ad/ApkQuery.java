package com.palmtech.ad.entity.ad;

import com.common.plugins.myframework.BaseQuery;



public class ApkQuery extends BaseQuery  {
    private static final long serialVersionUID = 3148176768559230877L;
   
    String code;

    
    String type;
  
    Integer  status;
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


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}
    
    


	
}

