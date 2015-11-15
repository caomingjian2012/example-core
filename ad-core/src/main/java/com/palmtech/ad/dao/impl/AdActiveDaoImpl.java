package com.palmtech.ad.dao.impl;

import org.springframework.stereotype.Repository;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.BaseDao;
import com.palmtech.ad.dao.AdActiveDao;
import com.palmtech.ad.entity.act.AdActive;
import com.palmtech.ad.entity.act.AdActiveQuery;
@Repository 
public class AdActiveDaoImpl  extends BaseDao<AdActive,Long> implements AdActiveDao {
	@Override
	public Page<AdActive> findPage(AdActiveQuery query) {
		String hql = "select t from AdActive t where 1=1 "
				+ "/~ and ad = {ad} ) ~/"
				+ "/~ and clientId = {clientId} ) ~/"
				+ "/~ order by [sortColumns] ~/";
		return hqlPageFindAll(hql, query);
	}

	

}
