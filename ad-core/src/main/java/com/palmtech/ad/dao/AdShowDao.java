package com.palmtech.ad.dao;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.DaoInterface;
import com.palmtech.ad.entity.act.AdShow;
import com.palmtech.ad.entity.act.AdShowQuery;

public interface AdShowDao extends DaoInterface<AdShow,java.lang.Long> {

	Page<AdShow> findPage(AdShowQuery query);
	

}
