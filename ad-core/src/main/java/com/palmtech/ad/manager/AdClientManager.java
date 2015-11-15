package com.palmtech.ad.manager;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.ServiceInterface;
import com.palmtech.ad.entity.ad.AdClient;
import com.palmtech.ad.entity.ad.AdClientQuery;


public interface AdClientManager extends ServiceInterface<AdClient, Long> {
	Page<AdClient> findPage(AdClientQuery query);
	
	
	AdClient findByUuidAndApkName(String uuid,String apkName);
	
	int findCountByApkName(String apkName);

	
}
