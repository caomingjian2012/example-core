package com.palmtech.ad.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.BaseDao;
import com.palmtech.ad.dao.CpsProfitDao;
import com.palmtech.ad.entity.mk.CpsProfit;
import com.palmtech.ad.entity.mk.CpsProfitQuery;
@Repository
public class CpsProfitDaoImpl  extends BaseDao<CpsProfit,Integer> implements CpsProfitDao {
	@Override
	public Page<CpsProfit> findPage(CpsProfitQuery query) {
		String hql = "select t from CpsProfit  t where 1=1 "
				+ "/~ and calendar >= {calendarBegin}~/"
				+ "/~ and calendar <= {calendarEnd}~/"
				+ "/~ and apk = {apk}~/" 	
				+ "/~ order by [sortColumns] ~/";
		return hqlPageFindAll(hql, query);
	}
	
	
	@Override
	public Map findSum(CpsProfitQuery query) {
		String sql = "select sum(t.marketProfit) as marketProfit "
				+ " from cps_profit t where 1=1 "
				+ "/~ and calendar >= {calendarBegin}~/"
				+ "/~ and calendar <= {calendarEnd}~/"
				+ "/~ and apk <= {apk}~/" 	
			;
		
		return sqlFindOne(sql, query);
		
	}

	
	

	

}
