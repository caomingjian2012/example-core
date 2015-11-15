package com.palmtech.ad.manager;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.ServiceInterface;
import com.palmtech.ad.entity.act.Launch;
import com.palmtech.ad.entity.act.LaunchQuery;


public interface LaunchManager extends ServiceInterface<Launch, Long> {
	Page<Launch> findPage(LaunchQuery query);

	
}
