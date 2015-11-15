package com.palmtech.ad.manager;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.ServiceInterface;
import com.palmtech.ad.entity.ctr.ApkBlackList;
import com.palmtech.ad.entity.ctr.ApkBlackListQuery;


public interface ApkBlackListManager extends ServiceInterface<ApkBlackList, Integer> {
	Page<ApkBlackList> findPage(ApkBlackListQuery query);
	int findCount(String apkName);
	
}
