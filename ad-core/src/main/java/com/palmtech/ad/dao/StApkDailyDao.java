package com.palmtech.ad.dao;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.DaoInterface;
import com.palmtech.ad.entity.st.StApkDaily;
import com.palmtech.ad.entity.st.StApkDailyQuery;

public interface StApkDailyDao extends DaoInterface<StApkDaily,java.lang.Long> {

	Page<StApkDaily> findPage(StApkDailyQuery query);
	

}
