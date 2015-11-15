package com.palmtech.ad.dao;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.DaoInterface;
import com.palmtech.ad.entity.ad.AdClient;
import com.palmtech.ad.entity.ad.AdClientQuery;

public interface AdClientDao extends DaoInterface<AdClient,java.lang.Long> {

	Page<AdClient> findPage(AdClientQuery query);
	

}
