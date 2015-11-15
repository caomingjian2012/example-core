package com.palmtech.ad.manager.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.BaseService;
import com.common.plugins.myframework.DaoInterface;
import com.palmtech.ad.dao.AdActiveDao;
import com.palmtech.ad.entity.act.AdActive;
import com.palmtech.ad.entity.act.AdActiveQuery;
import com.palmtech.ad.manager.AdActiveManager;


@Transactional
@Service 
public class AdActiveManagerImpl extends BaseService<AdActive, Long> implements AdActiveManager {
	Logger logger = Logger.getLogger(AdActiveManagerImpl.class);
	
	@Autowired
	AdActiveDao adActiveDao;
	@Override
	public Page<AdActive> findPage(AdActiveQuery query) {
		Assert.notNull(query);
		return adActiveDao.findPage(query);
	}

	@Override
	protected DaoInterface<AdActive, Long> getDAO() {
		
		return adActiveDao;
	}


	

}
