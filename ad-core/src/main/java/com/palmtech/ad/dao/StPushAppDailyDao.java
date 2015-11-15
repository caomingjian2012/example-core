package com.palmtech.ad.dao;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.DaoInterface;
import com.palmtech.ad.entity.st.StPushAppDaily;
import com.palmtech.ad.entity.st.StPushAppDailyQuery;

public interface StPushAppDailyDao extends DaoInterface<StPushAppDaily,java.lang.Long> {

	Page<StPushAppDaily> findPage(StPushAppDailyQuery query);
	

}
