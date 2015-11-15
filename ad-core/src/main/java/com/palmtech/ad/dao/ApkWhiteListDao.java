package com.palmtech.ad.dao;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.DaoInterface;
import com.palmtech.ad.entity.ctr.ApkWhiteList;
import com.palmtech.ad.entity.ctr.ApkWhiteListQuery;

public interface ApkWhiteListDao extends DaoInterface<ApkWhiteList,java.lang.Integer> {

	Page<ApkWhiteList> findPage(ApkWhiteListQuery query);
	

}
