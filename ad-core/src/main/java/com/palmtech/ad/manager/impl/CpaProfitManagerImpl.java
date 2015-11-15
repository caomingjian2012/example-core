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
import com.palmtech.ad.dao.CpaProfitDao;
import com.palmtech.ad.entity.ad.Apk;
import com.palmtech.ad.entity.mk.CpaProfit;
import com.palmtech.ad.entity.mk.CpaProfitQuery;
import com.palmtech.ad.manager.ApkManager;
import com.palmtech.ad.manager.CpaProfitManager;
@Transactional
@Service("CpaProfitManager")
public class CpaProfitManagerImpl extends BaseService<CpaProfit, Integer> implements CpaProfitManager {
	Logger logger = Logger.getLogger(CpaProfitManagerImpl.class);
	
	@Autowired
	CpaProfitDao CpaProfitDao;
	@Autowired
	ApkManager apkManager;
	

	
	@Override
	public Page<CpaProfit> findPage(CpaProfitQuery query) {
		Assert.notNull(query);
		return CpaProfitDao.findPage(query);
	}

	@Override
	protected DaoInterface<CpaProfit, Integer> getDAO() {
		
		return CpaProfitDao;
	}
	@Transactional
	@Override
	public Map findSum(CpaProfitQuery query) {
		
		return CpaProfitDao.findSum(query);
	}

	@Override
	public void save(CpaProfit entity) {
		Assert.notNull(entity,"对象不能为空");
		Assert.notNull(entity.getCalendar(),"日期不能为空");
		Date tomorrow =DateUtils.addDays(DateUtils.truncate(new Date(), Calendar.DATE),1) ;
		Assert.isTrue(entity.getCalendar().before(tomorrow),"不能选择未来日期");
		Assert.notNull(entity.getApk(),"APK不能为空");
		
		
		Assert.isTrue(entity.getActives()!=null&&entity.getActives()>=0,"激活用户不能小于0");
		Assert.isTrue(entity.getPrice()!=null&&entity.getPrice()>=0,"单价不能小于0");
		Assert.isTrue(entity.getMarketProfit()!=null&&entity.getMarketProfit()>=0,"总收益不能小于0");
		
		Apk apk = apkManager.getByPk(entity.getApk());
		Assert.notNull(apk,"APK不存在："+entity.getApk());
		Assert.isTrue(apk.getType().equalsIgnoreCase("cpa"),"APK："+entity.getApk()+"不是CPA");
		
		Date now = new Date();
		String user = SecurityUtils.getSubject().getPrincipal()==null?"system": SecurityUtils.getSubject().getPrincipal().toString();
		entity.setCreateTime(now);
		entity.setLastEditTime(now);
		entity.setLastEditor(user);
		super.save(entity);
	}

	@Override
	public void update(CpaProfit entity) {
		Assert.notNull(entity,"对象不能为空");
	
		Assert.notNull(entity.getCalendar(),"日期不能为空");
		Date tomorrow =DateUtils.addDays(DateUtils.truncate(new Date(), Calendar.DATE),1) ;
		Assert.isTrue(entity.getCalendar().before(tomorrow),"不能选择未来日期");
		Assert.notNull(entity.getApk(),"APK不能为空");
		Assert.isTrue(entity.getActives()!=null&&entity.getActives()>=0,"激活用户不能小于0");
		Assert.isTrue(entity.getPrice()!=null&&entity.getPrice()>=0,"单价不能小于0");
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
