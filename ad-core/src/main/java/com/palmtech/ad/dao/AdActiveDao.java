package com.palmtech.ad.dao;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.DaoInterface;
import com.palmtech.ad.entity.act.AdActive;
import com.palmtech.ad.entity.act.AdActiveQuery;

public interface AdActiveDao extends DaoInterface<AdActive,java.lang.Long> {

	Page<AdActive> findPage(AdActiveQuery query);
	

}
