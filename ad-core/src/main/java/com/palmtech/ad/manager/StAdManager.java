package com.palmtech.ad.manager;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.ServiceInterface;
import com.palmtech.ad.entity.st.StAd;
import com.palmtech.ad.entity.st.StAdQuery;


public interface StAdManager extends ServiceInterface<StAd, String> {
	Page<StAd> findPage(StAdQuery query);

	
}
