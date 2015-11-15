package com.palmtech.ad.manager.impl;

import java.util.Date;
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
import com.palmtech.ad.dao.StApkDailyDao;
import com.palmtech.ad.entity.st.StApkDaily;
import com.palmtech.ad.entity.st.StApkDailyQuery;
import com.palmtech.ad.manager.StApkDailyManager;


@Transactional
@Service
public class StApkDailyManagerImpl extends BaseService<StApkDaily, Long> implements StApkDailyManager {
	Logger logger = Logger.getLogger(StApkDailyManagerImpl.class);
	
	@Autowired
	StApkDailyDao stApkDailyDao;
	@Override
	public Page<StApkDaily> findPage(StApkDailyQuery query) {
		Assert.notNull(query);
		return stApkDailyDao.findPage(query);
	}

	@Override
	protected DaoInterface<StApkDaily, Long> getDAO() {
		
		return stApkDailyDao;
	}

	@Override
	public long findIncreaments(String apk, Date calendar) {
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("apkName", apk);
		paramsMap.put("calendar", calendar);
		StApkDaily rt = stApkDailyDao.findByPropertys(paramsMap);
		return rt==null?0:rt.getMobiles();
	}


	

}
