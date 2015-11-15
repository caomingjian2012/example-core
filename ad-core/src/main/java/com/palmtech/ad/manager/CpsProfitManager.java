package com.palmtech.ad.manager;

import java.util.Map;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.ServiceInterface;
import com.palmtech.ad.entity.mk.CpsProfit;
import com.palmtech.ad.entity.mk.CpsProfitQuery;

public interface CpsProfitManager extends ServiceInterface<CpsProfit, Integer> {
	Page<CpsProfit> findPage(CpsProfitQuery query);
	/**
	 * 总数
	 * @param query
	 * @return
	 */
	Map findSum(CpsProfitQuery query);
	 

	
}
