package com.palmtech.ad.dao;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.DaoInterface;
import com.palmtech.ad.entity.ad.PushApp;
import com.palmtech.ad.entity.ad.PushAppQuery;

public interface PushAppDao extends DaoInterface<PushApp,java.lang.String> {

	Page<PushApp> findPage(PushAppQuery query);
	

}
