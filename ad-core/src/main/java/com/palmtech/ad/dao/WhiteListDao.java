package com.palmtech.ad.dao;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.DaoInterface;
import com.palmtech.ad.entity.ctr.WhiteList;
import com.palmtech.ad.entity.ctr.WhiteListQuery;

public interface WhiteListDao extends DaoInterface<WhiteList,java.lang.Integer> {

	Page<WhiteList> findPage(WhiteListQuery query);
	

}
