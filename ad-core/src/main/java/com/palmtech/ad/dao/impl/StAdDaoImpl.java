package com.palmtech.ad.dao.impl;

import org.springframework.stereotype.Repository;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.BaseDao;
import com.palmtech.ad.dao.StAdDao;
import com.palmtech.ad.entity.st.StAd;
import com.palmtech.ad.entity.st.StAdQuery;
@Repository 
public class StAdDaoImpl  extends BaseDao<StAd,String> implements StAdDao {
	@Override
	public Page<StAd> findPage(StAdQuery query) {
		String hql = "select t from StAd t where 1=1 "
				
				+ "/~ and ad = {kw}~/"
				+ "/~ order by [sortColumns] ~/";
		return hqlPageFindAll(hql, query);
	}

	

}
