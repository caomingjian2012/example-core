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
import com.palmtech.ad.dao.ApkWhiteListDao;
import com.palmtech.ad.manager.ApkWhiteListManager;
import com.palmtech.ad.entity.ctr.ApkWhiteList;
import com.palmtech.ad.entity.ctr.ApkWhiteListQuery;


@Transactional
@Service 
public class ApkWhiteListManagerImpl extends BaseService<ApkWhiteList, Integer> implements ApkWhiteListManager {
	Logger logger = Logger.getLogger(ApkWhiteListManagerImpl.class);
	
	@Autowired
	ApkWhiteListDao apkWhiteListDao;
	
	
	@Override
	public Page<ApkWhiteList> findPage(ApkWhiteListQuery query) {
		Assert.notNull(query);
		return apkWhiteListDao.findPage(query);
	}

	@Override
	protected DaoInterface<ApkWhiteList, Integer> getDAO() {
		
		return apkWhiteListDao;
	}

	@Override
	public void save(ApkWhiteList entity) {
		Assert.notNull(entity, "对象不能为空");
		Assert.hasText(entity.getName(), "渠道代码不能为空");
		Assert.isTrue(entity.getName().length()<=20, "渠道代码长度必须小于20");
		entity.setCreateTime(new Date());
		super.save(entity);
	}
	
	@Override
	public int findCount(String apkName) {
		String hql ="select count(*) from ApkWhiteList where name='"+apkName+"' ";
		return apkWhiteListDao.hql4Number(hql).intValue();
	}

}
