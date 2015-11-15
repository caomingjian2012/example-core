package com.palmtech.ad.dao;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.DaoInterface;
import com.palmtech.ad.entity.ad.Apk;
import com.palmtech.ad.entity.ad.ApkQuery;

public interface ApkDao extends DaoInterface<Apk,java.lang.String> {

	Page<Apk> findPage(ApkQuery query);
	

}
