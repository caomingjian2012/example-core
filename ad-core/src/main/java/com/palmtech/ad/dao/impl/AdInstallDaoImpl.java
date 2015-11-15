package com.palmtech.ad.dao.impl;

import org.springframework.stereotype.Repository;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.BaseDao;
import com.palmtech.ad.dao.AdInstallDao;
import com.palmtech.ad.entity.act.AdInstall;
import com.palmtech.ad.entity.act.AdInstallQuery;
@Repository 
public class AdInstallDaoImpl  extends BaseDao<AdInstall,Long> implements AdInstallDao {
	@Override
	public Page<AdInstall> findPage(AdInstallQuery query) {
		String hql = "select t from AdInstall t where 1=1 "
				+ "/~ and ad = {ad} ) ~/"
				+ "/~ and clientId = {clientId} ) ~/"
				+ "/~ order by [sortColumns] ~/";
		return hqlPageFindAll(hql, query);
	}

	

}
