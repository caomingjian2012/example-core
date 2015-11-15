package com.palmtech.ad.manager;

import java.util.List;
import java.util.Map;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.ServiceInterface;
import com.palmtech.ad.entity.ad.PushApp;
import com.palmtech.ad.entity.ad.PushAppQuery;


public interface PushAppManager extends ServiceInterface<PushApp, String> {
	Page<PushApp> findPage(PushAppQuery query);

	Map<String,PushApp> findAll2Map();
	
	List<PushApp> findAbleApp();
}
