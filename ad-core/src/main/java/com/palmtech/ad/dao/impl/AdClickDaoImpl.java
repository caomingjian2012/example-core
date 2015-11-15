package com.palmtech.ad.dao.impl;

import org.springframework.stereotype.Repository;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.BaseDao;
import com.palmtech.ad.dao.AdClickDao;
import com.palmtech.ad.entity.act.AdClick;
import com.palmtech.ad.entity.act.AdClickQuery;
@Repository 
public class AdClickDaoImpl  extends BaseDao<AdClick,Long> implements AdClickDao {
	@Override
	public Page<AdClick> findPage(AdClickQuery query) {
		String hql = "select t from AdClick t where 1=1 "
				+ "/~ and ad = {ad} ) ~/"
				+ "/~ and clientId = {clientId} ) ~/"
				+ "/~ order by [sortColumns] ~/";
		return hqlPageFindAll(hql, query);
	}

	

}
