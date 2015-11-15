package com.palmtech.ad.dao;

import java.util.Map;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.DaoInterface;
import com.palmtech.ad.entity.mk.CpsProfit;
import com.palmtech.ad.entity.mk.CpsProfitQuery;

public interface CpsProfitDao extends DaoInterface<CpsProfit,java.lang.Integer> {

	Page<CpsProfit> findPage(CpsProfitQuery query);

	Map findSum(CpsProfitQuery query);
	
	
	

}
