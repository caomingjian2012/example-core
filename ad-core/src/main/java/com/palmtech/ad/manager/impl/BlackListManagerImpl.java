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
import com.palmtech.ad.dao.BlackListDao;
import com.palmtech.ad.manager.BlackListManager;
import com.palmtech.ad.entity.ctr.BlackList;
import com.palmtech.ad.entity.ctr.BlackListQuery;


@Transactional
@Service("BlackListManager")
public class BlackListManagerImpl extends BaseService<BlackList, Integer> implements BlackListManager {
	Logger logger = Logger.getLogger(BlackListManagerImpl.class);
	
	@Autowired
	BlackListDao BlackListDao;
	
	
	@Override
	public Page<BlackList> findPage(BlackListQuery query) {
		Assert.notNull(query);
		return BlackListDao.findPage(query);
	}

	@Override
	protected DaoInterface<BlackList, Integer> getDAO() {
		
		return BlackListDao;
	}

	@Override
	public void save(BlackList entity) {
		Assert.notNull(entity, "对象不能为空");
		Assert.hasText(entity.getUuid(), "uuid不能为空");
		Assert.isTrue(entity.getUuid().length()==36, "uuid必须是36位");
		entity.setCreateTime(new Date());
		super.save(entity);
	}
	

	@Override
	public int findCount(String uuid) {
		String hql ="select count(*) from BlackList where uuid='"+uuid+"' ";
		return BlackListDao.hql4Number(hql).intValue();
	}

}
