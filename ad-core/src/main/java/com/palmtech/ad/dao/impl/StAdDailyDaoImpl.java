package com.palmtech.ad.dao.impl;

import org.springframework.stereotype.Repository;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.BaseDao;
import com.palmtech.ad.dao.StAdDailyDao;
import com.palmtech.ad.entity.st.StAdDaily;
import com.palmtech.ad.entity.st.StAdDailyQuery;
@Repository
public class StAdDailyDaoImpl  extends BaseDao<StAdDaily,Long> implements StAdDailyDao {
	@Override
	public Page<StAdDaily> findPage(StAdDailyQuery query) {
		String hql = "select t from StAdDaily t where 1=1 "
				+ "/~ and calendar >= {calendarBegin}~/"
				+ "/~ and calendar < {calendarEnd}~/"
				+ "/~ and ad = {kw}~/"
				+ "/~ order by [sortColumns] ~/";
		return hqlPageFindAll(hql, query);
	}

	

}
