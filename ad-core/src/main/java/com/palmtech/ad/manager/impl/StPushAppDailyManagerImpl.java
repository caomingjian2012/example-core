package com.palmtech.ad.manager.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.BaseService;
import com.common.plugins.myframework.DaoInterface;
import com.palmtech.ad.dao.StPushAppDailyDao;
import com.palmtech.ad.entity.st.StPushAppDaily;
import com.palmtech.ad.entity.st.StPushAppDailyQuery;
import com.palmtech.ad.manager.StPushAppDailyManager;


@Transactional
@Service
public class StPushAppDailyManagerImpl extends BaseService<StPushAppDaily, Long> implements StPushAppDailyManager {
	Logger logger = Logger.getLogger(StPushAppDailyManagerImpl.class);
	
	@Autowired
	StPushAppDailyDao stPushAppDailyDao;
	@Override
	public Page<StPushAppDaily> findPage(StPushAppDailyQuery query) {
		Assert.notNull(query);
		return stPushAppDailyDao.findPage(query);
	}

	@Override
	protected DaoInterface<StPushAppDaily, Long> getDAO() {
		
		return stPushAppDailyDao;
	}


	

}
