package com.palmtech.ad.manager.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.BaseService;
import com.common.plugins.myframework.DaoInterface;
import com.palmtech.ad.dao.RmBuiltInPackageDao;
import com.palmtech.ad.manager.RmBuiltInPackageManager;
import com.palmtech.ad.entity.RmBuiltInPackage;
import com.palmtech.ad.entity.RmBuiltInPackageQuery;


@Transactional
@Service("RmBuiltInPackageManager")
public class RmBuiltInPackageManagerImpl extends BaseService<RmBuiltInPackage, Integer> implements RmBuiltInPackageManager {
	Logger logger = Logger.getLogger(RmBuiltInPackageManagerImpl.class);
	
	@Autowired
	RmBuiltInPackageDao RmBuiltInPackageDao;
	

	
	
	@Override
	public Page<RmBuiltInPackage> findPage(RmBuiltInPackageQuery query) {
		Assert.notNull(query);
		return RmBuiltInPackageDao.findPage(query);
	}

	@Override
	protected DaoInterface<RmBuiltInPackage, Integer> getDAO() {
		
		return RmBuiltInPackageDao;
	}


	

}
