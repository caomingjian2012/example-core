package com.palmtech.ad.dao.impl;

import org.springframework.stereotype.Repository;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.BaseDao;
import com.palmtech.ad.dao.ApkWhiteListDao;
import com.palmtech.ad.entity.ctr.ApkWhiteList;
import com.palmtech.ad.entity.ctr.ApkWhiteListQuery;
@Repository
public class ApkWhiteListDaoImpl  extends BaseDao<ApkWhiteList,Integer> implements ApkWhiteListDao {
	@Override
	public Page<ApkWhiteList> findPage(ApkWhiteListQuery query) {
		String hql = "select t from ApkWhiteList t where 1=1 "
				+ "/~ and   name like '%[kw]%' ~/"
				+ "/~ order by [sortColumns] ~/";
		return hqlPageFindAll(hql, query);
	}

	

}
