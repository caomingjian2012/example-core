package com.palmtech.ad.manager;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.ServiceInterface;
import com.palmtech.ad.entity.act.AdClick;
import com.palmtech.ad.entity.act.AdClickQuery;


public interface AdClickManager extends ServiceInterface<AdClick, Long> {
	Page<AdClick> findPage(AdClickQuery query);

	
}
