package com.palmtech.ad.manager;

import java.util.Map;

import com.common.plugins.myframework.ServiceInterface;
import com.palmtech.ad.entity.Country;


public interface CountryManager extends ServiceInterface<Country, String> {
	
	
	Map<String,Country> findAll2Map();

	
}
