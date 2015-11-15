package com.palmtech.ad.dao;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.DaoInterface;
import com.palmtech.ad.entity.User;
import com.palmtech.ad.entity.UserQuery;

public interface UserDao extends DaoInterface<User,java.lang.Integer> {

	Page<User> findPage(UserQuery query);
	

}
