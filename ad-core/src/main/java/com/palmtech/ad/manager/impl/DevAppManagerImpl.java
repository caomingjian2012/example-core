package com.palmtech.ad.manager.impl;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.BaseService;
import com.common.plugins.myframework.DaoInterface;
import com.palmtech.ad.dao.DevAppDao;
import com.palmtech.ad.manager.DevAppManager;
import com.palmtech.ad.manager.SeqManager;
import com.palmtech.ad.entity.ad.DevApp;
import com.palmtech.ad.entity.ad.DevAppQuery;
import com.palmtech.ad.utils.CommonUtil;


@Transactional
@Service("DevAppManager")
public class DevAppManagerImpl extends BaseService<DevApp, String> implements DevAppManager {
	Logger logger = Logger.getLogger(DevAppManagerImpl.class);
	
	@Autowired
	DevAppDao devAppDao;
	
	@Autowired
	SeqManager seqManager;
	
	
	@Override
	public Page<DevApp> findPage(DevAppQuery query) {
		Assert.notNull(query);
		return devAppDao.findPage(query);
	}

	@Override
	protected DaoInterface<DevApp, String> getDAO() {
		
		return devAppDao;
	}

	@Override
	public void save(DevApp entity) {
		Assert.notNull(entity, "对象不能为空");
		Assert.hasLength(entity.getName(),"名称不能为空");
		String cd = "DA"+seqManager.getSeq("devAppCd");
		String key = CommonUtil.hash(cd);
		entity.setCode(cd);
		entity.setAppKey(key);
		entity.setState(1);
		entity.setCreateTime(new Date());
		
		super.save(entity);
	}

	@Override
	public DevApp findByAppKey(String appkey) {
		
		return devAppDao.findByProperty("appKey", appkey);
	}
	
	

}
