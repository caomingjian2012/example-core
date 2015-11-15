package com.palmtech.ad.manager;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.ServiceInterface;
import com.palmtech.ad.entity.act.AdBuiltIn;
import com.palmtech.ad.entity.act.AdBuiltInQuery;


public interface AdBuiltInManager extends ServiceInterface<AdBuiltIn, Long> {
	Page<AdBuiltIn> findPage(AdBuiltInQuery query);

	
}
