package com.palmtech.ad.entity.ad;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.common.plugins.myframework.BaseQuery;



public class DevAppQuery extends BaseQuery  {
    private static final long serialVersionUID = 3148176768559230877L;
   
    String kw;
    
    
	public String getKw() {
		return kw;
	}


	public void setKw(String kw) {
		this.kw = kw;
	}


	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

