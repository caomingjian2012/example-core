package com.palmtech.ad.dao;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.DaoInterface;
import com.palmtech.ad.entity.act.Launch;
import com.palmtech.ad.entity.act.LaunchQuery;

public interface LaunchDao extends DaoInterface<Launch,java.lang.Long> {

	Page<Launch> findPage(LaunchQuery query);
	

}
