package com.palmtech.ad.manager;

import java.util.Date;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.ServiceInterface;
import com.palmtech.ad.entity.st.StApkDaily;
import com.palmtech.ad.entity.st.StApkDailyQuery;


public interface StApkDailyManager extends ServiceInterface<StApkDaily, Long> {
	Page<StApkDaily> findPage(StApkDailyQuery query);
	long findIncreaments(String apk,Date calendar);
	
}
