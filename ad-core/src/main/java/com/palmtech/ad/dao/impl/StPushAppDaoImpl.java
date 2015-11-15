package com.palmtech.ad.dao.impl;

import org.springframework.stereotype.Repository;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.BaseDao;
import com.palmtech.ad.dao.StPushAppDao;
import com.palmtech.ad.entity.st.StPushApp;
import com.palmtech.ad.entity.st.StPushAppQuery;
@Repository 
public class StPushAppDaoImpl  extends BaseDao<StPushApp,String> implements StPushAppDao {
	@Override
	public Page<StPushApp> findPage(StPushAppQuery query) {
		String hql = "select t from StPushApp t where 1=1 "
				
				+ "/~ and appCd = {kw}~/"
				+ "/~ order by [sortColumns] ~/";
		return hqlPageFindAll(hql, query);
	}

	

}
