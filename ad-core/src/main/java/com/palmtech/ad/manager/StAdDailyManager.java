package com.palmtech.ad.manager;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.ServiceInterface;
import com.palmtech.ad.entity.st.StAdDaily;
import com.palmtech.ad.entity.st.StAdDailyQuery;


public interface StAdDailyManager extends ServiceInterface<StAdDaily, Long> {
	Page<StAdDaily> findPage(StAdDailyQuery query);

	
}
