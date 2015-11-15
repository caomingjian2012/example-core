package com.palmtech.ad.manager.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.BaseService;
import com.common.plugins.myframework.DaoInterface;
import com.palmtech.ad.dao.AdInstallDao;
import com.palmtech.ad.entity.act.AdInstall;
import com.palmtech.ad.entity.act.AdInstallQuery;
import com.palmtech.ad.manager.AdInstallManager;


@Transactional
@Service("AdInstallManager")
public class AdInstallManagerImpl extends BaseService<AdInstall, Long> implements AdInstallManager {
	Logger logger = Logger.getLogger(AdInstallManagerImpl.class);
	
	@Autowired
	AdInstallDao adInstallDao;
	@Override
	public Page<AdInstall> findPage(AdInstallQuery query) {
		Assert.notNull(query);
		return adInstallDao.findPage(query);
	}

	@Override
	protected DaoInterface<AdInstall, Long> getDAO() {
		
		return adInstallDao;
	}


	

}
