package com.palmtech.ad.manager.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.BaseService;
import com.common.plugins.myframework.DaoInterface;
import com.palmtech.ad.dao.StAdDailyDao;
import com.palmtech.ad.entity.st.StAdDaily;
import com.palmtech.ad.entity.st.StAdDailyQuery;
import com.palmtech.ad.manager.StAdDailyManager;


@Transactional
@Service
public class StAdDailyManagerImpl extends BaseService<StAdDaily, Long> implements StAdDailyManager {
	Logger logger = Logger.getLogger(StAdDailyManagerImpl.class);
	
	@Autowired
	StAdDailyDao stAdDailyDao;
	@Override
	public Page<StAdDaily> findPage(StAdDailyQuery query) {
		Assert.notNull(query);
		return stAdDailyDao.findPage(query);
	}

	@Override
	protected DaoInterface<StAdDaily, Long> getDAO() {
		
		return stAdDailyDao;
	}


	

}
