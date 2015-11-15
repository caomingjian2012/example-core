package com.palmtech.ad.manager.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.BaseService;
import com.common.plugins.myframework.DaoInterface;
import com.palmtech.ad.dao.AdClientDao;
import com.palmtech.ad.entity.ad.AdClient;
import com.palmtech.ad.entity.ad.AdClientQuery;
import com.palmtech.ad.manager.AdClientManager;


@Transactional
@Service("AdClientManager")
public class AdClientManagerImpl extends BaseService<AdClient, Long> implements AdClientManager {
	Logger logger = Logger.getLogger(AdClientManagerImpl.class);
	
	@Autowired
	AdClientDao adClientDao;
	@Override
	public Page<AdClient> findPage(AdClientQuery query) {
		Assert.notNull(query);
		return adClientDao.findPage(query);
	}

	@Override
	protected DaoInterface<AdClient, Long> getDAO() {
		
		return adClientDao;
	}

	@Override
	public AdClient findByUuidAndApkName(String uuid, String apkName) {
		String hql = "from AdClient where 1=1 /~ and mobile.uuid = {uuid} ~//~ and apkName = {apkName} ~/";
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("uuid", uuid);
		map.put("apkName", apkName);
		return adClientDao.hqlFindByPropertys(hql, map);
	}

	@Override
	public int findCountByApkName(String apkName) {
		String sql = "select count(*) from ad_client where 1=1 /~ and apkName = {apkName} ~/";
		
		Map<String,Object> map = new HashMap<String,Object>();
		 
		map.put("apkName", apkName);
		return adClientDao.sql4Number(sql, map).intValue();
	}


	

}
