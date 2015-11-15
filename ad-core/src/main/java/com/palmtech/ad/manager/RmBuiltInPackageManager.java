package com.palmtech.ad.manager;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.ServiceInterface;
import com.palmtech.ad.entity.RmBuiltInPackage;
import com.palmtech.ad.entity.RmBuiltInPackageQuery;


public interface RmBuiltInPackageManager extends ServiceInterface<RmBuiltInPackage, Integer> {
	Page<RmBuiltInPackage> findPage(RmBuiltInPackageQuery query);

	
}
