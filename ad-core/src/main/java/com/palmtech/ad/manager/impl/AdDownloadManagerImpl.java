package com.palmtech.ad.manager.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.BaseService;
import com.common.plugins.myframework.DaoInterface;
import com.palmtech.ad.dao.AdDownloadDao;
import com.palmtech.ad.entity.act.AdDownload;
import com.palmtech.ad.entity.act.AdDownloadQuery;
import com.palmtech.ad.manager.AdDownloadManager;


@Transactional
@Service("AdDownloadManager")
public class AdDownloadManagerImpl extends BaseService<AdDownload, Long> implements AdDownloadManager {
	Logger logger = Logger.getLogger(AdDownloadManagerImpl.class);
	
	@Autowired
	AdDownloadDao adDownloadDao;
	@Override
	public Page<AdDownload> findPage(AdDownloadQuery query) {
		Assert.notNull(query);
		return adDownloadDao.findPage(query);
	}

	@Override
	protected DaoInterface<AdDownload, Long> getDAO() {
		
		return adDownloadDao;
	}


	

}
