package com.palmtech.ad.manager.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.BaseService;
import com.common.plugins.myframework.DaoInterface;
import com.palmtech.ad.dao.LaunchDao;
import com.palmtech.ad.entity.act.Launch;
import com.palmtech.ad.entity.act.LaunchQuery;
import com.palmtech.ad.manager.LaunchManager;


@Transactional
@Service("LaunchManager")
public class LaunchManagerImpl extends BaseService<Launch, Long> implements LaunchManager {
	Logger logger = Logger.getLogger(LaunchManagerImpl.class);
	
	@Autowired
	LaunchDao launchDao;
	
	
	@Override
	public Page<Launch> findPage(LaunchQuery query) {
		Assert.notNull(query);
		return launchDao.findPage(query);
	}

	@Override
	protected DaoInterface<Launch, Long> getDAO() {
		
		return launchDao;
	}

	

	

}
