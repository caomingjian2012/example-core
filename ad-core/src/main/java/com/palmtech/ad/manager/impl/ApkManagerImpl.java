package com.palmtech.ad.manager.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.BaseService;
import com.common.plugins.myframework.DaoInterface;
import com.palmtech.ad.dao.ApkDao;
import com.palmtech.ad.entity.ad.Apk;
import com.palmtech.ad.entity.ad.ApkQuery;
import com.palmtech.ad.manager.ApkManager;


@Transactional
@Service("ApkManager")
public class ApkManagerImpl extends BaseService<Apk, String> implements ApkManager {
	Logger logger = Logger.getLogger(ApkManagerImpl.class);
	
	@Autowired
	ApkDao apkDao;
	

	
	
	@Override
	public Page<Apk> findPage(ApkQuery query) {
		Assert.notNull(query);
		return apkDao.findPage(query);
	}

	@Override
	protected DaoInterface<Apk, String> getDAO() {
		
		return apkDao;
	}

	@Override
	public void save(Apk entity) {
		Assert.notNull(entity, "对象不能为空");
		Assert.hasText(entity.getCode(), "code不能为空");
		Assert.hasText(entity.getMarket(), "market不能为空");
		
		Assert.hasLength(entity.getType(),"类型不能为空");
		Assert.isTrue(entity.getType().equals("cpa") || entity.getType().equals("cps"), "合作类型不正确");
		Assert.notNull(entity.getRate(),"比列不能为空");
		Assert.isTrue(entity.getRate()>=0 && entity.getRate() <=100, "比列在0~100之间");
		Assert.notNull(entity.getUnitPrice(),"单价不能为空");
		Assert.isTrue(entity.getUnitPrice()>=0, "单价必须大于0");
		
		
		entity.setCreateTime(new Date());
		entity.setStatus(0);
		super.save(entity);
	}

	@Override
	public void update(Apk entity) {
		Assert.notNull(entity, "对象不能为空");
		Assert.hasText(entity.getCode(), "code不能为空");
		Assert.hasText(entity.getMarket(), "market不能为空");
	
	
		super.update(entity);
	}

	@Override
	public Map<String, Apk> findAll2Map() {
		List<Apk> list =getDAO().findAll("");
		Map<String,Apk> rt = new HashMap<String, Apk>();
		for(Apk o :list){
			rt.put(o.getCode(), o);
		}
		
		return rt ;
	}


	

}
