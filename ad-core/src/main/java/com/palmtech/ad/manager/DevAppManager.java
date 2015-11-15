package com.palmtech.ad.manager;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.ServiceInterface;
import com.palmtech.ad.entity.ad.DevApp;
import com.palmtech.ad.entity.ad.DevAppQuery;


public interface DevAppManager extends ServiceInterface<DevApp, String> {
	Page<DevApp> findPage(DevAppQuery query);
	
	DevApp findByAppKey(String appkey);

	
}
