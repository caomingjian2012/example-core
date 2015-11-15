package com.palmtech.ad.dao.impl;

import org.springframework.stereotype.Repository;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.BaseDao;
import com.palmtech.ad.dao.AdBuiltInDao;
import com.palmtech.ad.entity.act.AdBuiltIn;
import com.palmtech.ad.entity.act.AdBuiltInQuery;
@Repository 
public class AdBuiltInDaoImpl  extends BaseDao<AdBuiltIn,Long> implements AdBuiltInDao {
	@Override
	public Page<AdBuiltIn> findPage(AdBuiltInQuery query) {
		String hql = "select t from AdBuiltIn t where 1=1 "
				+ "/~ and ad = {ad} ) ~/"
				+ "/~ and clientId = {clientId} ) ~/"
				+ "/~ order by [sortColumns] ~/";
		return hqlPageFindAll(hql, query);
	}

	

}
