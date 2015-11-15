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
import com.palmtech.ad.dao.WhiteListDao;
import com.palmtech.ad.manager.WhiteListManager;
import com.palmtech.ad.entity.ctr.WhiteList;
import com.palmtech.ad.entity.ctr.WhiteListQuery;


@Transactional
@Service("WhiteListManager")
public class WhiteListManagerImpl extends BaseService<WhiteList, Integer> implements WhiteListManager {
	Logger logger = Logger.getLogger(WhiteListManagerImpl.class);
	
	@Autowired
	WhiteListDao whiteListDao;
	
	
	@Override
	public Page<WhiteList> findPage(WhiteListQuery query) {
		Assert.notNull(query);
		return whiteListDao.findPage(query);
	}

	@Override
	protected DaoInterface<WhiteList, Integer> getDAO() {
		
		return whiteListDao;
	}

	@Override
	public void save(WhiteList entity) {
		Assert.notNull(entity, "对象不能为空");
		Assert.hasText(entity.getUuid(), "uuid不能为空");
		Assert.isTrue(entity.getUuid().length()==36, "uuid必须是36位");
		entity.setCreateTime(new Date());
		super.save(entity);
	}

	@Override
	public int findCount(String uuid) {
		String hql ="select count(*) from WhiteList where uuid='"+uuid+"' ";
		return whiteListDao.hql4Number(hql).intValue();
	}
	
	

}
