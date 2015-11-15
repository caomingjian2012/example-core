package com.palmtech.ad.manager.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.BaseService;
import com.common.plugins.myframework.DaoInterface;
import com.palmtech.ad.dao.AdClickDao;
import com.palmtech.ad.entity.act.AdClick;
import com.palmtech.ad.entity.act.AdClickQuery;
import com.palmtech.ad.manager.AdClickManager;


@Transactional
@Service("AdClickManager")
public class AdClickManagerImpl extends BaseService<AdClick, Long> implements AdClickManager {
	Logger logger = Logger.getLogger(AdClickManagerImpl.class);
	
	@Autowired
	AdClickDao adClickDao;
	@Override
	public Page<AdClick> findPage(AdClickQuery query) {
		Assert.notNull(query);
		return adClickDao.findPage(query);
	}

	@Override
	protected DaoInterface<AdClick, Long> getDAO() {
		
		return adClickDao;
	}


	

}
