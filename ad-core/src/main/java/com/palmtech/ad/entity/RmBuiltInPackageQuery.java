package com.palmtech.ad.entity;

import com.common.plugins.myframework.BaseQuery;



public class RmBuiltInPackageQuery extends BaseQuery  {
    private static final long serialVersionUID = 3148176768559230877L;
   
    String packageName;
    java.util.Date calendarBegin;
    java.util.Date calendarEnd;
   
	public String getPackageName() {
		return packageName;
	}


	public void setPackageName(String packageName) {
		this.packageName = packageName;
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


	@Override
	public String toString() {
		return "RmMsgQuery [packageName=" + packageName + ", calendarBegin="
				+ calendarBegin + ", calendarEnd=" + calendarEnd + "]";
	}

}

