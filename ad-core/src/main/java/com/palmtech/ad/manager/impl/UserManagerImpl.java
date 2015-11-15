package com.palmtech.ad.manager.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import cn.org.rapid_framework.page.Page;

import com.palmtech.ad.dao.UserDao;
import com.palmtech.ad.entity.User;
import com.palmtech.ad.manager.UserManager;
import com.palmtech.ad.entity.UserQuery;
@Transactional
@Service("userManager")
public class UserManagerImpl implements UserManager {
	@Autowired
	UserDao userDao;
	

	@Override
	public void save(User user) {
		Assert.notNull(user, "用户不存在");
		Assert.hasText(user.getUsername(), "用户名不能为空");
		Assert.hasText(user.getPassword(), "用户密码不能为空");
		
		user.setCreateTime(new Date());
		userDao.save(user);
		
		
	}

	@Override
	public void delete(User user) {
		
		Assert.notNull(user, "用户不存在");
		Assert.isTrue(user.getId() != 1, "超级管理不能被删除");
		userDao.delete(user);
		
	}

	@Override
	public void deleteById(Integer id) {
		User user = userDao.getByPk(id);
		delete(user);
		
		
	}

	@Override
	public void update(User user) {
		Assert.notNull(user, "用户不存在");
		Assert.hasText(user.getUsername(), "用户名不能为空");
		Assert.hasText(user.getPassword(), "用户密码不能为空");
		userDao.update(user);
		
	}

	@Override
	public User findById(Integer id) {
		Assert.notNull(id);
		return userDao.getByPk(id);
	}

	@Override
	public List<User> findAll() {
		
		return userDao.findAll(null);
	}

	@Override
	public User findByUsername(String username) {
		return 	userDao.findByProperty("username", username);
	}
	@Override
	public Page<User> findPage(UserQuery query) {
		Assert.notNull(query);
		return userDao.findPage(query);
	}

	@Override
	public Map findUserRoles(){
		String sql ="select t1.u_id as uid,group_concat(t2.name) as rolenames from palmcms_acl_user_role t1 left  join palmcms_acl_role t2 on t1.role_id =t2.id group by u_id";
		
		List<Map> list = userDao.sqlFindAll(sql, new HashMap());
		Map map =new HashMap();
		for(Map m :list){
			map.put(m.get("uid"),m.get("rolenames"));
			
		}
		return map;
	}


}
