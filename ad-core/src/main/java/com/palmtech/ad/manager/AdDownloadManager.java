package com.palmtech.ad.manager;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.ServiceInterface;
import com.palmtech.ad.entity.act.AdDownload;
import com.palmtech.ad.entity.act.AdDownloadQuery;


public interface AdDownloadManager extends ServiceInterface<AdDownload, Long> {
	Page<AdDownload> findPage(AdDownloadQuery query);

	
}
