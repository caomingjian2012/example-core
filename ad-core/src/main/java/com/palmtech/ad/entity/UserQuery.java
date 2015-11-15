package com.palmtech.ad.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.common.plugins.myframework.BaseQuery;



public class UserQuery extends BaseQuery  {
    private static final long serialVersionUID = 3148176768559230877L;
    
    String wordLike;
	public String getWordLike() {
		return wordLike;
	}

	public void setWordLike(String wordLike) {
		this.wordLike = wordLike;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

