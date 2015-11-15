package com.palmtech.ad.dao;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.DaoInterface;
import com.palmtech.ad.entity.RmBuiltInPackage;
import com.palmtech.ad.entity.RmBuiltInPackageQuery;

public interface RmBuiltInPackageDao extends DaoInterface<RmBuiltInPackage,java.lang.Integer> {

	Page<RmBuiltInPackage> findPage(RmBuiltInPackageQuery query);
	

}
