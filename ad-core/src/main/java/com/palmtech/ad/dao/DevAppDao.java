package com.palmtech.ad.dao;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.DaoInterface;
import com.palmtech.ad.entity.ad.DevApp;
import com.palmtech.ad.entity.ad.DevAppQuery;

public interface DevAppDao extends DaoInterface<DevApp,java.lang.String> {

	Page<DevApp> findPage(DevAppQuery query);
	

}
