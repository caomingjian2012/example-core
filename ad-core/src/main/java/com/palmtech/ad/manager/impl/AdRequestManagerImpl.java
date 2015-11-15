package com.palmtech.ad.manager.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.BaseService;
import com.common.plugins.myframework.DaoInterface;
import com.palmtech.ad.dao.AdRequestDao;
import com.palmtech.ad.entity.act.AdRequest;
import com.palmtech.ad.entity.act.AdRequestQuery;
import com.palmtech.ad.manager.AdRequestManager;
import com.palmtech.ad.manager.SeqManager;


@Transactional
@Service("AdRequestManager")
public class AdRequestManagerImpl extends BaseService<AdRequest, Long> implements AdRequestManager {
	Logger logger = Logger.getLogger(AdRequestManagerImpl.class);
	
	@Autowired
	AdRequestDao adRequestDao;
	@Override
	public Page<AdRequest> findPage(AdRequestQuery query) {
		Assert.notNull(query);
		return adRequestDao.findPage(query);
	}

	@Override
	protected DaoInterface<AdRequest, Long> getDAO() {
		
		return adRequestDao;
	}
	@Autowired
	SeqManager seqManager;
	@Override
	public void save(AdRequest entity) {
		Assert.notNull(entity, "object can't be null");
		long id = seqManager.getSeq("adRequest");
		super.save(entity);
	}


	

}
