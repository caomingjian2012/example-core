package com.palmtech.ad.dao.impl;

import org.springframework.stereotype.Repository;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.BaseDao;
import com.palmtech.ad.dao.DevAppDao;
import com.palmtech.ad.entity.ad.DevApp;
import com.palmtech.ad.entity.ad.DevAppQuery;
@Repository 
public class DevAppDaoImpl  extends BaseDao<DevApp,String> implements DevAppDao {
	@Override
	public Page<DevApp> findPage(DevAppQuery query) {
		String hql = "select t from DevApp t where 1=1 "
				
				+ "/~ order by [sortColumns] ~/";
		return hqlPageFindAll(hql, query);
	}

	

}
