package com.palmtech.ad.dao.impl;

import org.springframework.stereotype.Repository;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.BaseDao;
import com.palmtech.ad.dao.RmMsgDao;
import com.palmtech.ad.entity.act.RmMsg;
import com.palmtech.ad.entity.act.RmMsgQuery;
@Repository 
public class RmMsgDaoImpl  extends BaseDao<RmMsg,Long> implements RmMsgDao {
	@Override
	public Page<RmMsg> findPage(RmMsgQuery query) {
		String hql = "select t from RmMsg t where 1=1 "
				
				+ "/~ order by [sortColumns] ~/";
		return hqlPageFindAll(hql, query);
	}

	

}
