package com.palmtech.ad.manager;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.ServiceInterface;
import com.palmtech.ad.entity.ctr.BlackList;
import com.palmtech.ad.entity.ctr.BlackListQuery;


public interface BlackListManager extends ServiceInterface<BlackList, Integer> {
	Page<BlackList> findPage(BlackListQuery query);
	int findCount(String uuid);
	

	
}
