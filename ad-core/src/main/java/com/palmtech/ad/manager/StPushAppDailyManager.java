package com.palmtech.ad.manager;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.ServiceInterface;
import com.palmtech.ad.entity.st.StPushAppDaily;
import com.palmtech.ad.entity.st.StPushAppDailyQuery;


public interface StPushAppDailyManager extends ServiceInterface<StPushAppDaily, Long> {
	Page<StPushAppDaily> findPage(StPushAppDailyQuery query);

	
}
