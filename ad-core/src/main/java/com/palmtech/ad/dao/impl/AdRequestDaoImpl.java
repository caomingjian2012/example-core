package com.palmtech.ad.dao.impl;

import org.springframework.stereotype.Repository;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.BaseDao;
import com.palmtech.ad.dao.AdRequestDao;
import com.palmtech.ad.entity.act.AdRequest;
import com.palmtech.ad.entity.act.AdRequestQuery;
@Repository 
public class AdRequestDaoImpl  extends BaseDao<AdRequest,Long> implements AdRequestDao {
	@Override
	public Page<AdRequest> findPage(AdRequestQuery query) {
		String hql = "select t from AdRequest t where 1=1 "
				
				+ "/~ and clientId = {clientId} ) ~/"
				+ "/~ and type = {type} ) ~/"
				+ "/~ order by [sortColumns] ~/";
		return hqlPageFindAll(hql, query);
	}

	

}
