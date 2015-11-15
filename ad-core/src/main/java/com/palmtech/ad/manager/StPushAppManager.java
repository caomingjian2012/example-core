package com.palmtech.ad.manager;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.ServiceInterface;
import com.palmtech.ad.entity.st.StPushApp;
import com.palmtech.ad.entity.st.StPushAppQuery;


public interface StPushAppManager extends ServiceInterface<StPushApp, String> {
	Page<StPushApp> findPage(StPushAppQuery query);

	
}
