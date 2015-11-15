package com.palmtech.ad.manager;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.ServiceInterface;
import com.palmtech.ad.entity.ctr.ApkWhiteList;
import com.palmtech.ad.entity.ctr.ApkWhiteListQuery;


public interface ApkWhiteListManager extends ServiceInterface<ApkWhiteList, Integer> {
	Page<ApkWhiteList> findPage(ApkWhiteListQuery query);
	int findCount(String apkName);
	
}
