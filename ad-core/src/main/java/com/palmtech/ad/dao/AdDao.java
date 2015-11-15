package com.palmtech.ad.dao;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.DaoInterface;
import com.palmtech.ad.entity.ad.Ad;
import com.palmtech.ad.entity.ad.AdQuery;

public interface AdDao extends DaoInterface<Ad,java.lang.String> {

	Page<Ad> findPage(AdQuery query);
	

}
