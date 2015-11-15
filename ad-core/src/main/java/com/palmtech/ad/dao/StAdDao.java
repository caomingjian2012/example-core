package com.palmtech.ad.dao;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.DaoInterface;
import com.palmtech.ad.entity.st.StAd;
import com.palmtech.ad.entity.st.StAdQuery;

public interface StAdDao extends DaoInterface<StAd,java.lang.String> {

	Page<StAd> findPage(StAdQuery query);
	

}
