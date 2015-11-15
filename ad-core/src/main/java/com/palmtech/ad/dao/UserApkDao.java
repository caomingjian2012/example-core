package com.palmtech.ad.dao;

import java.util.List;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.DaoInterface;
import com.palmtech.ad.entity.mk.UserApk;
import com.palmtech.ad.entity.mk.UserApkQuery;

public interface UserApkDao  extends DaoInterface<UserApk,java.lang.Integer> {
	Page<UserApk> findPage(UserApkQuery query);

	List<UserApk> findAll(UserApkQuery query);
}
