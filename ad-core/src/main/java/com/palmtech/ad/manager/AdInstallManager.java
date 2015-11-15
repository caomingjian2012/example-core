package com.palmtech.ad.manager;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.ServiceInterface;
import com.palmtech.ad.entity.act.AdInstall;
import com.palmtech.ad.entity.act.AdInstallQuery;


public interface AdInstallManager extends ServiceInterface<AdInstall, Long> {
	Page<AdInstall> findPage(AdInstallQuery query);

	
}
