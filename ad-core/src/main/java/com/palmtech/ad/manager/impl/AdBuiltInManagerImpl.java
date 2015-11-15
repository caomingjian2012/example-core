package com.palmtech.ad.manager.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.BaseService;
import com.common.plugins.myframework.DaoInterface;
import com.palmtech.ad.dao.AdBuiltInDao;
import com.palmtech.ad.entity.act.AdBuiltIn;
import com.palmtech.ad.entity.act.AdBuiltInQuery;
import com.palmtech.ad.manager.AdBuiltInManager;


@Transactional
@Service("AdBuiltInManager")
public class AdBuiltInManagerImpl extends BaseService<AdBuiltIn, Long> implements AdBuiltInManager {
	Logger logger = Logger.getLogger(AdBuiltInManagerImpl.class);
	
	@Autowired
	AdBuiltInDao adBuiltInDao;
	@Override
	public Page<AdBuiltIn> findPage(AdBuiltInQuery query) {
		Assert.notNull(query);
		return adBuiltInDao.findPage(query);
	}

	@Override
	protected DaoInterface<AdBuiltIn, Long> getDAO() {
		
		return adBuiltInDao;
	}


	

}
