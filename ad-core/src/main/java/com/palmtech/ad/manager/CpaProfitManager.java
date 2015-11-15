package com.palmtech.ad.manager;

import java.util.Map;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.ServiceInterface;
import com.palmtech.ad.entity.mk.CpaProfit;
import com.palmtech.ad.entity.mk.CpaProfitQuery;

public interface CpaProfitManager extends ServiceInterface<CpaProfit, Integer> {
	Page<CpaProfit> findPage(CpaProfitQuery query);
	/**
	 * 总数
	 * @param query
	 * @return
	 */
	Map findSum(CpaProfitQuery query);
	 

	
}
