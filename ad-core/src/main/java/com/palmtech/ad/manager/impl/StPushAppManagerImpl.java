package com.palmtech.ad.manager.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.BaseService;
import com.common.plugins.myframework.DaoInterface;
import com.palmtech.ad.dao.StPushAppDao;
import com.palmtech.ad.entity.st.StPushApp;
import com.palmtech.ad.entity.st.StPushAppQuery;
import com.palmtech.ad.manager.StPushAppManager;


@Transactional
@Service
public class StPushAppManagerImpl extends BaseService<StPushApp, String> implements StPushAppManager {
	Logger logger = Logger.getLogger(StPushAppManagerImpl.class);
	
	@Autowired
	StPushAppDao stPushAppDao;
	@Override
	public Page<StPushApp> findPage(StPushAppQuery query) {
		Assert.notNull(query);
		return stPushAppDao.findPage(query);
	}

	@Override
	protected DaoInterface<StPushApp, String> getDAO() {
		
		return stPushAppDao;
	}


	

}
