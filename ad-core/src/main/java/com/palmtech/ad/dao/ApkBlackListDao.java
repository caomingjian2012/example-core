package com.palmtech.ad.dao;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.DaoInterface;
import com.palmtech.ad.entity.ctr.ApkBlackList;
import com.palmtech.ad.entity.ctr.ApkBlackListQuery;

public interface ApkBlackListDao extends DaoInterface<ApkBlackList,java.lang.Integer> {

	Page<ApkBlackList> findPage(ApkBlackListQuery query);
	

}
