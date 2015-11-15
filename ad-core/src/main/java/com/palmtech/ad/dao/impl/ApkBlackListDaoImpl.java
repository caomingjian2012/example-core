package com.palmtech.ad.dao.impl;

import org.springframework.stereotype.Repository;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.BaseDao;
import com.palmtech.ad.dao.ApkBlackListDao;
import com.palmtech.ad.entity.ctr.ApkBlackList;
import com.palmtech.ad.entity.ctr.ApkBlackListQuery;
@Repository
public class ApkBlackListDaoImpl  extends BaseDao<ApkBlackList,Integer> implements ApkBlackListDao {
	@Override
	public Page<ApkBlackList> findPage(ApkBlackListQuery query) {
		String hql = "select t from ApkBlackList t where 1=1 "
				+ "/~ and   name like '%[kw]%' ~/"
				+ "/~ order by [sortColumns] ~/";
		return hqlPageFindAll(hql, query);
	}

	

}
