package com.palmtech.ad.manager;

import java.util.Date;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.ServiceInterface;
import com.palmtech.ad.entity.ad.Mobile;
import com.palmtech.ad.entity.ad.MobileQuery;


public interface MobileManager extends ServiceInterface<Mobile, String> {
	Page<Mobile> findPage(MobileQuery query);
	

	
}
