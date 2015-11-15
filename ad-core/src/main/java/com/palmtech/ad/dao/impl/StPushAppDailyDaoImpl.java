package com.palmtech.ad.dao.impl;

import org.springframework.stereotype.Repository;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.BaseDao;
import com.palmtech.ad.dao.StPushAppDailyDao;
import com.palmtech.ad.entity.st.StPushAppDaily;
import com.palmtech.ad.entity.st.StPushAppDailyQuery;
@Repository 
public class StPushAppDailyDaoImpl  extends BaseDao<StPushAppDaily,Long> implements StPushAppDailyDao {
	@Override
	public Page<StPushAppDaily> findPage(StPushAppDailyQuery query) {
		String hql = "select t from StPushAppDaily t where 1=1 "
				+ "/~ and calendar >= {calendarBegin}~/"
				+ "/~ and calendar < {calendarEnd}~/"
				+ "/~ and appCd = {kw}~/"
				+ "/~ order by [sortColumns] ~/";
		return hqlPageFindAll(hql, query);
	}

	

}
