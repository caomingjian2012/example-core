package com.palmtech.ad.manager.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.BaseService;
import com.common.plugins.myframework.DaoInterface;
import com.palmtech.ad.dao.AdShowDao;
import com.palmtech.ad.entity.act.AdShow;
import com.palmtech.ad.entity.act.AdShowQuery;
import com.palmtech.ad.manager.AdShowManager;


@Transactional
@Service("AdShowManager")
public class AdShowManagerImpl extends BaseService<AdShow, Long> implements AdShowManager {
	Logger logger = Logger.getLogger(AdShowManagerImpl.class);
	
	@Autowired
	AdShowDao adShowDao;
	@Override
	public Page<AdShow> findPage(AdShowQuery query) {
		Assert.notNull(query);
		return adShowDao.findPage(query);
	}

	@Override
	protected DaoInterface<AdShow, Long> getDAO() {
		
		return adShowDao;
	}


	

}
