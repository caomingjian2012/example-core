package com.palmtech.ad.dao.impl;

import org.springframework.stereotype.Repository;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.BaseDao;
import com.palmtech.ad.dao.AdDownloadDao;
import com.palmtech.ad.entity.act.AdDownload;
import com.palmtech.ad.entity.act.AdDownloadQuery;
@Repository 
public class AdDownloadDaoImpl  extends BaseDao<AdDownload,Long> implements AdDownloadDao {
	@Override
	public Page<AdDownload> findPage(AdDownloadQuery query) {
		String hql = "select t from AdDownload t where 1=1 "
				+ "/~ and ad = {ad} ) ~/"
				+ "/~ and clientId = {clientId} ) ~/"
				+ "/~ order by [sortColumns] ~/";
		return hqlPageFindAll(hql, query);
	}

	

}
