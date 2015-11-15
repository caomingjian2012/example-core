package com.palmtech.ad.dao;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.DaoInterface;
import com.palmtech.ad.entity.act.AdRequest;
import com.palmtech.ad.entity.act.AdRequestQuery;

public interface AdRequestDao extends DaoInterface<AdRequest,java.lang.Long> {

	Page<AdRequest> findPage(AdRequestQuery query);
	

}
