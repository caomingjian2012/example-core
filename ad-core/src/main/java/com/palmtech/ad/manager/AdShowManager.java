package com.palmtech.ad.manager;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.ServiceInterface;
import com.palmtech.ad.entity.act.AdShow;
import com.palmtech.ad.entity.act.AdShowQuery;


public interface AdShowManager extends ServiceInterface<AdShow, Long> {
	Page<AdShow> findPage(AdShowQuery query);

	
}
