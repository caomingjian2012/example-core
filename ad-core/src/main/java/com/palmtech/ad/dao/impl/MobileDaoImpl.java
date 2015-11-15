package com.palmtech.ad.dao.impl;

import org.springframework.stereotype.Repository;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.BaseDao;
import com.palmtech.ad.dao.MobileDao;
import com.palmtech.ad.entity.ad.Mobile;
import com.palmtech.ad.entity.ad.MobileQuery;
@Repository 
public class MobileDaoImpl  extends BaseDao<Mobile,String> implements MobileDao {
	@Override
	public Page<Mobile> findPage(MobileQuery query) {
		String hql = "select t from Mobile t where 1=1 "
				+ "/~ and   uuid ={kw}  ~/"
				+ "/~ order by [sortColumns] ~/";
		return hqlPageFindAll(hql, query);
	}

	

}
