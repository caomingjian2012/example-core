package com.palmtech.ad.manager;

import java.util.Map;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.ServiceInterface;
import com.palmtech.ad.entity.ad.Ad;
import com.palmtech.ad.entity.ad.Apk;
import com.palmtech.ad.entity.ad.ApkQuery;


public interface ApkManager extends ServiceInterface<Apk, String> {
	Page<Apk> findPage(ApkQuery query);
	Map<String,Apk> findAll2Map();
	
}
