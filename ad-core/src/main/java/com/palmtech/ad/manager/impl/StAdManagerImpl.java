package com.palmtech.ad.manager.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.BaseService;
import com.common.plugins.myframework.DaoInterface;
import com.palmtech.ad.dao.StAdDao;
import com.palmtech.ad.entity.st.StAd;
import com.palmtech.ad.entity.st.StAdQuery;
import com.palmtech.ad.manager.StAdManager;


@Transactional
@Service
public class StAdManagerImpl extends BaseService<StAd, String> implements StAdManager {
	Logger logger = Logger.getLogger(StAdManagerImpl.class);
	
	@Autowired
	StAdDao stAdDao;
	@Override
	public Page<StAd> findPage(StAdQuery query) {
		Assert.notNull(query);
		return stAdDao.findPage(query);
	}

	@Override
	protected DaoInterface<StAd, String> getDAO() {
		
		return stAdDao;
	}


	

}
