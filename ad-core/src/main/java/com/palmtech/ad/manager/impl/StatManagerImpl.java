package com.palmtech.ad.manager.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.common.plugins.myframework.ComplexSqlBean;
import com.palmtech.ad.dao.AdClientDao;
import com.palmtech.ad.manager.StatManager;
@Service("StatManager")
public class StatManagerImpl implements StatManager {
	
	@Autowired
	AdClientDao appUserDao;

	@Override
	public List<Map> statAd(String adcd, Date begin, Date end) {
		Assert.notNull(begin,"开始时间不能为空");
		Assert.notNull(end,"结束时间不能为空");
		Assert.isTrue(end.after(begin),"开始时间不能大于结束时间");
	
		Assert.isTrue(end.before(DateUtils.addYears(begin, 1)),"时间跨度不能超过1年");
		String statAdSql = ComplexSqlBean.getSql("statAdSql");
		
		HashMap<String, Object> map =new HashMap<String, Object>();
		map.put("begin", begin);
		map.put("end", end);
		map.put("adcd", adcd);
		
		List<Map> list= appUserDao.sqlFindAll( statAdSql, map);
		return list;
		
		
	}

	@Override
	public List<Map> statApp(String appcd, Date begin, Date end) {
		Assert.notNull(begin,"开始时间不能为空");
		Assert.notNull(end,"结束时间不能为空");
		Assert.isTrue(end.after(begin),"开始时间不能大于结束时间");
	
		Assert.isTrue(end.before(DateUtils.addYears(begin, 1)),"时间跨度不能超过1年");
		String statAppSql = ComplexSqlBean.getSql("statAppSql");
		
		HashMap<String, Object> map =new HashMap<String, Object>();
		map.put("begin", begin);
		map.put("end", end);
		map.put("appcd", appcd);
		
		List<Map> list= appUserDao.sqlFindAll( statAppSql, map);
		return list;
	}
	
	@Override
	public List<Map> statChannel() {
		
		
		HashMap<String, Object> map =new HashMap<String, Object>();
		String sql = "select count(1) as mans,u_channel as channel from t_user group by u_channel ";
		
		List<Map> list= appUserDao.sqlFindAll( sql, map);
		return list;
	}

}
