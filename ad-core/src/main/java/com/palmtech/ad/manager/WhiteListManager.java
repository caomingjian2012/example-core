package com.palmtech.ad.manager;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.ServiceInterface;
import com.palmtech.ad.entity.ctr.WhiteList;
import com.palmtech.ad.entity.ctr.WhiteListQuery;


public interface WhiteListManager extends ServiceInterface<WhiteList, Integer> {
	Page<WhiteList> findPage(WhiteListQuery query);
	
	int findCount(String uuid);

	
}
