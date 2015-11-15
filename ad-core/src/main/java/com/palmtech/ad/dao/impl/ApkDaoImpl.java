package com.palmtech.ad.dao.impl;

import org.springframework.stereotype.Repository;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.BaseDao;
import com.palmtech.ad.dao.ApkDao;
import com.palmtech.ad.entity.ad.Apk;
import com.palmtech.ad.entity.ad.ApkQuery;
@Repository 
public class ApkDaoImpl  extends BaseDao<Apk,String> implements ApkDao {
	@Override
	public Page<Apk> findPage(ApkQuery query) {
		String hql = "select t from Apk t where 1=1 "
				+ "/~ and code = {code}   ~/"
				+ "/~ order by [sortColumns] ~/";
		return hqlPageFindAll(hql, query);
	}

	

}
