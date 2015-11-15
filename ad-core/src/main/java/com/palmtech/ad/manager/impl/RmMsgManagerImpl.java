package com.palmtech.ad.manager.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.BaseService;
import com.common.plugins.myframework.DaoInterface;
import com.palmtech.ad.dao.RmMsgDao;
import com.palmtech.ad.manager.RmMsgManager;
import com.palmtech.ad.entity.act.RmMsg;
import com.palmtech.ad.entity.act.RmMsgQuery;


@Transactional
@Service("RmMsgManager")
public class RmMsgManagerImpl extends BaseService<RmMsg, Long> implements RmMsgManager {
	Logger logger = Logger.getLogger(RmMsgManagerImpl.class);
	
	@Autowired
	RmMsgDao RmMsgDao;
	

	
	
	@Override
	public Page<RmMsg> findPage(RmMsgQuery query) {
		Assert.notNull(query);
		return RmMsgDao.findPage(query);
	}

	@Override
	protected DaoInterface<RmMsg, Long> getDAO() {
		
		return RmMsgDao;
	}


	

}
