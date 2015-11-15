package com.palmtech.ad.dao.impl;

import org.springframework.stereotype.Repository;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.BaseDao;
import com.palmtech.ad.dao.LaunchDao;
import com.palmtech.ad.entity.act.Launch;
import com.palmtech.ad.entity.act.LaunchQuery;
@Repository 
public class LaunchDaoImpl  extends BaseDao<Launch,Long> implements LaunchDao {
	@Override
	public Page<Launch> findPage(LaunchQuery query) {
		String hql = "select t from Launch t where 1=1 "
			
				+ "/~ and clientId = {clientId} ) ~/"
				+ "/~ order by [sortColumns] ~/";
		return hqlPageFindAll(hql, query);
	}

	

}
