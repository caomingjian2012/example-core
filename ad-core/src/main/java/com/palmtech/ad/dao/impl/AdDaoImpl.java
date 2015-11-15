package com.palmtech.ad.dao.impl;

import org.springframework.stereotype.Repository;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.BaseDao;
import com.palmtech.ad.dao.AdDao;
import com.palmtech.ad.entity.ad.Ad;
import com.palmtech.ad.entity.ad.AdQuery;
@Repository 
public class AdDaoImpl  extends BaseDao<Ad,String> implements AdDao {
	@Override
	public Page<Ad> findPage(AdQuery query) {
		String hql = "select t from Ad t  where 1=1 "
				+ "/~  and type={type} ~/"
				+ "/~  and state={state} ~/"
				+ "/~ order by [sortColumns] ~/";
		return hqlPageFindAll(hql, query);
	}

	

}
