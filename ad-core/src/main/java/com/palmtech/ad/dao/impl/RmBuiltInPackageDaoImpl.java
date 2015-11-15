package com.palmtech.ad.dao.impl;

import org.springframework.stereotype.Repository;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.BaseDao;
import com.palmtech.ad.dao.RmBuiltInPackageDao;
import com.palmtech.ad.entity.RmBuiltInPackage;
import com.palmtech.ad.entity.RmBuiltInPackageQuery;
@Repository 
public class RmBuiltInPackageDaoImpl  extends BaseDao<RmBuiltInPackage,Integer> implements RmBuiltInPackageDao {
	@Override
	public Page<RmBuiltInPackage> findPage(RmBuiltInPackageQuery query) {
		String hql = "select t from RmBuiltInPackage t where 1=1 "
				+ "/~ and packageName = {packageName} ~/"
				+ "/~ order by [sortColumns] ~/";
		return hqlPageFindAll(hql, query);
	}

	

}
