package com.palmtech.ad.manager;

import java.util.List;
import java.util.Map;

import cn.org.rapid_framework.page.Page;

import com.palmtech.ad.entity.User;
import com.palmtech.ad.entity.UserQuery;

/**
 * 角色管理
 * @author Administrator
 *
 */
public interface UserManager {
	public void save(User user) ;

	/**
	 * 超级管理员不能被删除
	 * 
	 * @param role
	 * @throws Exception
	 */
	public void delete(User user);
	/**
	 * 超级管理员不能被删除
	 * 
	 * @param role
	 * @throws Exception
	 */
	public void deleteById(Integer id) ;

	/**
	 * 超级管理员不能被修改
	 * 
	 * @param role
	 * @throws Exception
	 */
	public void update(User user) ;

	public User findById(Integer id) ;
	public User findByUsername(String username) ;

	public List<User> findAll();

	Page<User> findPage(UserQuery query);

	Map findUserRoles();


	

	
	

}
