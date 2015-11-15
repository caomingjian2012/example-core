package com.palmtech.ad.dao;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.DaoInterface;
import com.palmtech.ad.entity.act.AdInstall;
import com.palmtech.ad.entity.act.AdInstallQuery;

public interface AdInstallDao extends DaoInterface<AdInstall,java.lang.Long> {

	Page<AdInstall> findPage(AdInstallQuery query);
	

}
