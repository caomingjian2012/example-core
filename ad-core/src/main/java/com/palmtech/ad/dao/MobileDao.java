package com.palmtech.ad.dao;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.DaoInterface;
import com.palmtech.ad.entity.ad.Mobile;
import com.palmtech.ad.entity.ad.MobileQuery;

public interface MobileDao extends DaoInterface<Mobile,java.lang.String> {

	Page<Mobile> findPage(MobileQuery query);
	

}
