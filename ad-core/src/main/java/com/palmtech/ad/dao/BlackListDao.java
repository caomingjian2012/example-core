package com.palmtech.ad.dao;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.DaoInterface;
import com.palmtech.ad.entity.ctr.BlackList;
import com.palmtech.ad.entity.ctr.BlackListQuery;

public interface BlackListDao extends DaoInterface<BlackList,java.lang.Integer> {

	Page<BlackList> findPage(BlackListQuery query);
	

}
