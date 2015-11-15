package com.palmtech.ad.dao.impl;

import org.springframework.stereotype.Repository;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.BaseDao;
import com.palmtech.ad.dao.BlackListDao;
import com.palmtech.ad.entity.ctr.BlackList;
import com.palmtech.ad.entity.ctr.BlackListQuery;
@Repository 
public class BlackListDaoImpl  extends BaseDao<BlackList,Integer> implements BlackListDao {
	@Override
	public Page<BlackList> findPage(BlackListQuery query) {
		String hql = "select t from BlackList t where 1=1 "
				+ "/~ and   uuid like '%[kw]%'  ~/"
				+ "/~ order by [sortColumns] ~/";
		return hqlPageFindAll(hql, query);
	}

	

}
