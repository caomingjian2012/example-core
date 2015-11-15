package com.palmtech.ad.dao.impl;

import org.springframework.stereotype.Repository;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.BaseDao;
import com.palmtech.ad.dao.AdClientDao;
import com.palmtech.ad.entity.ad.AdClient;
import com.palmtech.ad.entity.ad.AdClientQuery;
@Repository 
public class AdClientDaoImpl  extends BaseDao<AdClient,Long> implements AdClientDao {
	@Override
	public Page<AdClient> findPage(AdClientQuery query) {
		String hql = "select t from AdClient t where 1=1 "
				+ "/~ and (apkName = {kw}  or uuid ={kw} ) ~/"
				+ "/~ order by [sortColumns] ~/";
		return hqlPageFindAll(hql, query);
	}

	

}
