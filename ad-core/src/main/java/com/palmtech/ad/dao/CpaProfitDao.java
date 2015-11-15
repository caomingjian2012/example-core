package com.palmtech.ad.dao;

import java.util.Map;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.DaoInterface;
import com.palmtech.ad.entity.mk.CpaProfit;
import com.palmtech.ad.entity.mk.CpaProfitQuery;

public interface CpaProfitDao extends DaoInterface<CpaProfit,java.lang.Integer> {

	Page<CpaProfit> findPage(CpaProfitQuery query);

	Map findSum(CpaProfitQuery query);
	
	
	

}
