package com.palmtech.ad.manager.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.BaseService;
import com.common.plugins.myframework.DaoInterface;
import com.palmtech.ad.dao.MobileDao;
import com.palmtech.ad.entity.ad.Mobile;
import com.palmtech.ad.entity.ad.MobileQuery;
import com.palmtech.ad.manager.MobileManager;


@Transactional
@Service("MobileManager")
public class MobileManagerImpl extends BaseService<Mobile, String> implements MobileManager {
	Logger logger = Logger.getLogger(MobileManagerImpl.class);
	
	@Autowired
	MobileDao mobileDao;
	@Override
	public Page<Mobile> findPage(MobileQuery query) {
		Assert.notNull(query);
		return mobileDao.findPage(query);
	}

	@Override
	protected DaoInterface<Mobile, String> getDAO() {
		
		return mobileDao;
	}

	


	

}
