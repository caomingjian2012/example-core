package com.palmtech.ad.manager.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.plugins.myframework.BaseService;
import com.common.plugins.myframework.DaoInterface;
import com.palmtech.ad.dao.CountryDao;
import com.palmtech.ad.entity.Country;
import com.palmtech.ad.manager.CountryManager;


@Transactional
@Service
public class CountryManagerImpl extends BaseService<Country, String> implements CountryManager {
	Logger logger = Logger.getLogger(CountryManagerImpl.class);
	
	@Autowired
	CountryDao countryDao;
	
	
	
	
	

	@Override
	protected DaoInterface<Country, String> getDAO() {
		
		return countryDao;
	}

	

	@Override
	public Map<String, Country> findAll2Map() {
		List<Country> list =getDAO().findAll("");
		Map<String,Country> rt = new HashMap<String, Country>();
		for(Country o :list){
			rt.put(o.getCode(), o);
		}
		
		return rt ;
	}
	
	

}
