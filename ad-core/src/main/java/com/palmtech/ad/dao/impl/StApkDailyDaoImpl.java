package com.palmtech.ad.dao.impl;

import org.springframework.stereotype.Repository;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.BaseDao;
import com.palmtech.ad.dao.StApkDailyDao;
import com.palmtech.ad.entity.st.StApkDaily;
import com.palmtech.ad.entity.st.StApkDailyQuery;
@Repository
public class StApkDailyDaoImpl  extends BaseDao<StApkDaily,Long> implements StApkDailyDao {
	@Override
	public Page<StApkDaily> findPage(StApkDailyQuery query) {
		String hql = "select t from StApkDaily t where 1=1 "
				+ "/~ and calendar >= {calendarBegin}~/"
				+ "/~ and calendar < {calendarEnd}~/"
				+ "/~ and apkName = {kw}~/"
				+ "/~ order by [sortColumns] ~/";
		return hqlPageFindAll(hql, query);
	}

	

}
