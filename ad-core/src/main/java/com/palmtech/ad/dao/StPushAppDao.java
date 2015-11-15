package com.palmtech.ad.dao;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.DaoInterface;
import com.palmtech.ad.entity.st.StPushApp;
import com.palmtech.ad.entity.st.StPushAppQuery;

public interface StPushAppDao extends DaoInterface<StPushApp,java.lang.String> {

	Page<StPushApp> findPage(StPushAppQuery query);
	

}
