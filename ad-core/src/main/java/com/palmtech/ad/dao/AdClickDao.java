package com.palmtech.ad.dao;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.DaoInterface;
import com.palmtech.ad.entity.act.AdClick;
import com.palmtech.ad.entity.act.AdClickQuery;

public interface AdClickDao extends DaoInterface<AdClick,java.lang.Long> {

	Page<AdClick> findPage(AdClickQuery query);
	

}
