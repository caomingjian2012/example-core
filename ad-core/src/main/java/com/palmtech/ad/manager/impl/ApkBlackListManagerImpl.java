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
import com.palmtech.ad.dao.ApkBlackListDao;
import com.palmtech.ad.manager.ApkBlackListManager;
import com.palmtech.ad.entity.ctr.ApkBlackList;
import com.palmtech.ad.entity.ctr.ApkBlackListQuery;


@Transactional
@Service 
public class ApkBlackListManagerImpl extends BaseService<ApkBlackList, Integer> implements ApkBlackListManager {
	Logger logger = Logger.getLogger(ApkBlackListManagerImpl.class);
	
	@Autowired
	ApkBlackListDao apkBlackListDao;
	
	
	@Override
	public Page<ApkBlackList> findPage(ApkBlackListQuery query) {
		Assert.notNull(query);
		return apkBlackListDao.findPage(query);
	}

	@Override
	protected DaoInterface<ApkBlackList, Integer> getDAO() {
		
		return apkBlackListDao;
	}

	@Override
	public void save(ApkBlackList entity) {
		Assert.notNull(entity, "对象不能为空");
		Assert.hasText(entity.getName(), "渠道代码不能为空");
		Assert.isTrue(entity.getName().length()<=20, "渠道代码长度必须小于20");
		entity.setCreateTime(new Date());
		super.save(entity);
	}
	
	@Override
	public int findCount(String apkName) {
		String hql ="select count(*) from ApkBlackList where name='"+apkName+"' ";
		return apkBlackListDao.hql4Number(hql).intValue();
	}

}
