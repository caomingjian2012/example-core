package com.palmtech.ad.dao.impl;

import org.springframework.stereotype.Repository;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.BaseDao;
import com.palmtech.ad.dao.AdShowDao;
import com.palmtech.ad.entity.act.AdShow;
import com.palmtech.ad.entity.act.AdShowQuery;
@Repository 
public class AdShowDaoImpl  extends BaseDao<AdShow,Long> implements AdShowDao {
	@Override
	public Page<AdShow> findPage(AdShowQuery query) {
		String hql = "select t from AdShow t where 1=1 "
				+ "/~ and ad = {ad} ) ~/"
				+ "/~ and clientId = {clientId} ) ~/"
				+ "/~ order by [sortColumns] ~/";
		return hqlPageFindAll(hql, query);
	}

	

}
