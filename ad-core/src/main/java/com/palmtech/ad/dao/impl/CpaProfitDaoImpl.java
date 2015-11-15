package com.palmtech.ad.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.BaseDao;
import com.palmtech.ad.dao.CpaProfitDao;
import com.palmtech.ad.entity.mk.CpaProfit;
import com.palmtech.ad.entity.mk.CpaProfitQuery;
@Repository 
public class CpaProfitDaoImpl  extends BaseDao<CpaProfit,Integer> implements CpaProfitDao {
	@Override
	public Page<CpaProfit> findPage(CpaProfitQuery query) {
		String hql = "select t from CpaProfit  t where 1=1 "
				+ "/~ and calendar >= {calendarBegin}~/"
				+ "/~ and calendar <= {calendarEnd}~/"
				+ "/~ and apk = {apk}~/" 	
				+ "/~ order by [sortColumns] ~/";
		return hqlPageFindAll(hql, query);
	}
	
	
	@Override
	public Map findSum(CpaProfitQuery query) {
		String sql = "select  sum(t.actives) as actives,sum(t.marketProfit) as marketProfit "
				+ " from cpa_profit t where 1=1 "
				+ "/~ and calendar >= {calendarBegin}~/"
				+ "/~ and calendar <= {calendarEnd}~/"
				+ "/~ and apk <= {apk}~/" 	
			;
		
		return sqlFindOne(sql, query);
		
	}

	
	

	

}
