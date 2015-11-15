package com.palmtech.ad.manager;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.ServiceInterface;
import com.palmtech.ad.entity.act.AdRequest;
import com.palmtech.ad.entity.act.AdRequestQuery;


public interface AdRequestManager extends ServiceInterface<AdRequest, Long> {
	Page<AdRequest> findPage(AdRequestQuery query);

	
}
