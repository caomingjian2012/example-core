package com.palmtech.ad.dao;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.DaoInterface;
import com.palmtech.ad.entity.act.AdBuiltIn;
import com.palmtech.ad.entity.act.AdBuiltInQuery;

public interface AdBuiltInDao extends DaoInterface<AdBuiltIn,java.lang.Long> {

	Page<AdBuiltIn> findPage(AdBuiltInQuery query);
	

}
