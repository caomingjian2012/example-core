package com.palmtech.ad.manager;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.ServiceInterface;
import com.palmtech.ad.entity.act.AdActive;
import com.palmtech.ad.entity.act.AdActiveQuery;


public interface AdActiveManager extends ServiceInterface<AdActive, Long> {
	Page<AdActive> findPage(AdActiveQuery query);

	
}
