package com.palmtech.ad.dao.impl;

import org.springframework.stereotype.Repository;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.BaseDao;
import com.palmtech.ad.dao.UserDao;
import com.palmtech.ad.entity.User;
import com.palmtech.ad.entity.UserQuery;
@Repository 
public class UserDaoImpl  extends BaseDao<User,Integer> implements UserDao {
	@Override
	public Page<User> findPage(UserQuery query) {
		String hql = "select t from User t where 1=1 "
				+ "/~ and   username like '%[wordLike]%'  or  name like '%[wordLike]%' ~/"
				+ "/~ order by [sortColumns] ~/";
		return hqlPageFindAll(hql, query);
	}

	

}
