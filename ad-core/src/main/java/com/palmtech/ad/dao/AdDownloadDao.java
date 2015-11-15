package com.palmtech.ad.dao;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.DaoInterface;
import com.palmtech.ad.entity.act.AdDownload;
import com.palmtech.ad.entity.act.AdDownloadQuery;

public interface AdDownloadDao extends DaoInterface<AdDownload,java.lang.Long> {

	Page<AdDownload> findPage(AdDownloadQuery query);
	

}
