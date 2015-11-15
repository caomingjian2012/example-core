package com.palmtech.ad.dao.impl;

import org.springframework.stereotype.Repository;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.BaseDao;
import com.palmtech.ad.dao.PushAppDao;
import com.palmtech.ad.entity.ad.PushApp;
import com.palmtech.ad.entity.ad.PushAppQuery;
@Repository 
public class PushAppDaoImpl  extends BaseDao<PushApp,String> implements PushAppDao {
	@Override
	public Page<PushApp> findPage(PushAppQuery query) {
		String hql = "select t from PushApp t where 1=1 "
			
				+ "/~ order by [sortColumns] ~/";
		return hqlPageFindAll(hql, query);
	}

	

}
