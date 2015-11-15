package com.palmtech.ad.dao;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.DaoInterface;
import com.palmtech.ad.entity.st.StAdDaily;
import com.palmtech.ad.entity.st.StAdDailyQuery;

public interface StAdDailyDao extends DaoInterface<StAdDaily,java.lang.Long> {

	Page<StAdDaily> findPage(StAdDailyQuery query);
	

}
