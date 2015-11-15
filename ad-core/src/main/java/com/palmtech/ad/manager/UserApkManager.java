package com.palmtech.ad.manager;

import java.util.List;
import java.util.Map;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.ServiceInterface;
import com.palmtech.ad.entity.mk.UserApk;
import com.palmtech.ad.entity.mk.UserApkQuery;

public interface UserApkManager extends ServiceInterface<UserApk, Integer> {
	/**
	 * 分页查询
	 * @param query
	 * @return
	 */
	Page<UserApk> findPage(UserApkQuery query);
	/**
	 * 查询所有
	 * @param query
	 * @return
	 */
	 List<UserApk> findAll(UserApkQuery query);
	 
	 Map findUserApkMap();
	
	 
}
