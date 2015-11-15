package com.palmtech.ad.manager;

import java.util.Map;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.ServiceInterface;
import com.palmtech.ad.entity.ad.Ad;
import com.palmtech.ad.entity.ad.AdQuery;


public interface AdManager extends ServiceInterface<Ad, String> {
	Page<Ad> findPage(AdQuery query);
	/**
	 * 自动下架
	 */
	void autoDown();
	
	Map<String,Ad> findAll2Map();

	
}
