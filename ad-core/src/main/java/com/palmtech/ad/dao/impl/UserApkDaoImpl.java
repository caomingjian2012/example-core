package com.palmtech.ad.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.BaseDao;
import com.palmtech.ad.dao.UserApkDao;
import com.palmtech.ad.entity.mk.UserApk;
import com.palmtech.ad.entity.mk.UserApkQuery;
@Repository 
public class UserApkDaoImpl  extends BaseDao<UserApk,Integer> implements UserApkDao  {

	@Override
	public Page<UserApk> findPage(UserApkQuery query) {
		String hql = "select t from UserApk t where 1=1 "
				+ "/~ and username = {username} ~/"
				+ "/~ and apk = {apk} ~/"
				+ "/~ order by [sortColumns] ~/";
		return hqlPageFindAll(hql, query);
	}
	@Override
	public List<UserApk> findAll(UserApkQuery query) {
		String hql = "select t from UserApk t where 1=1 "
				+ "/~ and username = {username} ~/"
				+ "/~ and apk = {apk} ~/"
				+ "/~ order by [sortColumns] ~/";
		return hqlFindAll(hql, query);
	}
	

}
