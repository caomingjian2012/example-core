package com.palmtech.ad.manager.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.BaseService;
import com.common.plugins.myframework.DaoInterface;
import com.palmtech.ad.dao.CpsProfitDao;
import com.palmtech.ad.entity.ad.Apk;
import com.palmtech.ad.entity.mk.CpsProfit;
import com.palmtech.ad.entity.mk.CpsProfitQuery;
import com.palmtech.ad.manager.ApkManager;
import com.palmtech.ad.manager.CpsProfitManager;
@Transactional
@Service("CpsProfitManager")
public class CpsProfitManagerImpl extends BaseService<CpsProfit, Integer> implements CpsProfitManager {
	Logger logger = Logger.getLogger(CpsProfitManagerImpl.class);
	
	@Autowired
	CpsProfitDao CpsProfitDao;
	@Autowired
	ApkManager apkManager;
	

	
	@Override
	public Page<CpsProfit> findPage(CpsProfitQuery query) {
		Assert.notNull(query);
		return CpsProfitDao.findPage(query);
	}

	@Override
	protected DaoInterface<CpsProfit, Integer> getDAO() {
		
		return CpsProfitDao;
	}
	@Transactional
	@Override
	public Map findSum(CpsProfitQuery query) {
		
		return CpsProfitDao.findSum(query);
	}

	@Override
	public void save(CpsProfit entity) {
		Assert.notNull(entity,"对象不能为空");
		Assert.notNull(entity.getCalendar(),"日期不能为空");
		Date tomorrow =DateUtils.addDays(DateUtils.truncate(new Date(), Calendar.DATE),1) ;
		Assert.isTrue(entity.getCalendar().before(tomorrow),"不能选择未来日期");
		Assert.notNull(entity.getApk(),"APK不能为空");
		
		
		 
		Assert.isTrue(entity.getMarketProfit()!=null&&entity.getMarketProfit()>=0,"总收益不能小于0");
		
		Apk apk = apkManager.getByPk(entity.getApk());
		Assert.notNull(apk,"APK不存在："+entity.getApk());
		Assert.isTrue(apk.getType().equalsIgnoreCase("cps"),"APK："+entity.getApk()+"不是CPS");
		
		Date now = new Date();
		String user = SecurityUtils.getSubject().getPrincipal()==null?"system": SecurityUtils.getSubject().getPrincipal().toString();
		entity.setCreateTime(now);
		entity.setLastEditTime(now);
		entity.setLastEditor(user);
		super.save(entity);
	}

	@Override
	public void update(CpsProfit entity) {
		Assert.notNull(entity,"对象不能为空");
	
		Assert.notNull(entity.getCalendar(),"日期不能为空");
		Date tomorrow =DateUtils.addDays(DateUtils.truncate(new Date(), Calendar.DATE),1) ;
		Assert.isTrue(entity.getCalendar().before(tomorrow),"不能选择未来日期");
		Assert.notNull(entity.getApk(),"APK不能为空");
	 
		Assert.isTrue(entity.getMarketProfit()!=null&&entity.getMarketProfit()>=0,"总收益不能小于0");
		
		Apk apk = apkManager.getByPk(entity.getApk());
		Assert.notNull(apk,"APK不存在："+entity.getApk());
		
		Date now = new Date();
		
		Subject subject =SecurityUtils.getSubject();
		Object p = subject.getPrincipal();
		String user = SecurityUtils.getSubject().getPrincipal()==null?"system": SecurityUtils.getSubject().getPrincipal().toString();
		
		
		entity.setLastEditTime(now);
		entity.setLastEditor(user);
		super.update(entity);
	}

	

	
	
	

	
	
	
	
	

}
