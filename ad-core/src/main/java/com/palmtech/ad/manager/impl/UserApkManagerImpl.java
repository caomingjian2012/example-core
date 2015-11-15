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
import com.palmtech.ad.dao.UserApkDao;
import com.palmtech.ad.entity.mk.UserApk;
import com.palmtech.ad.entity.mk.UserApkQuery;
import com.palmtech.ad.manager.UserApkManager;
@Transactional
@Service("UserChannelManager")
public class UserApkManagerImpl extends BaseService<UserApk, Integer> implements UserApkManager {
	Logger logger = Logger.getLogger(UserApkManagerImpl.class);
	
	@Autowired
	UserApkDao userApkDao;
	

	
	@Override
	public Page<UserApk> findPage(UserApkQuery query) {
		Assert.notNull(query);
		return userApkDao.findPage(query);
	}

	@Override
	protected DaoInterface<UserApk, Integer> getDAO() {
		
		return userApkDao;
	}

	@Override
	public List<UserApk> findAll(UserApkQuery query) {
		
		return userApkDao.findAll(query);
	}

	@Override
	public void save(UserApk entity) {
		Assert.notNull(entity,"对象不能为空");
		Assert.notNull(entity.getUsername(),"用户不能为空");
		Assert.notNull(entity.getApk(),"APK不能为空");
		
		
		
		entity.setCreateTime(new Date());
		super.save(entity);
	}

	@Override
	public void update(UserApk entity) {
		Assert.notNull(entity,"对象不能为空");
		Assert.notNull(entity.getUsername(),"用户不能为空");
		Assert.notNull(entity.getApk(),"APK不能为空");
		
	
		super.update(entity);
	}

	@Override
	public Map findUserApkMap() {
		String sql ="select username  ,group_concat(apk) as apks from user_apk   group by username";
		
		List<Map> list = userApkDao.sqlFindAll(sql, new HashMap());
		Map map =new HashMap();
		for(Map m :list){
			map.put(m.get("username"),m.get("apks"));
			
		}
		return map;
	}


	
	
	

}
