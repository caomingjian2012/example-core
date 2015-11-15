package com.palmtech.ad.dao.impl;

import org.springframework.stereotype.Repository;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.BaseDao;
import com.palmtech.ad.dao.WhiteListDao;
import com.palmtech.ad.entity.ctr.WhiteList;
import com.palmtech.ad.entity.ctr.WhiteListQuery;
@Repository 
public class WhiteListDaoImpl  extends BaseDao<WhiteList,Integer> implements WhiteListDao {
	@Override
	public Page<WhiteList> findPage(WhiteListQuery query) {
		String hql = "select t from WhiteList t where 1=1 "
				+ "/~ and   uuid like '%[kw]%'  ~/"
				+ "/~ order by [sortColumns] ~/";
		return hqlPageFindAll(hql, query);
	}

	

}
