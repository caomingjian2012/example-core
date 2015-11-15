package com.palmtech.ad.manager.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.palmtech.ad.dao.PermissionDao;
import com.palmtech.ad.dao.RoleDao;
import com.palmtech.ad.dao.RolePermissionDao;
import com.palmtech.ad.dao.UserDao;
import com.palmtech.ad.dao.UserRoleDao;
import com.palmtech.ad.entity.Permission;
import com.palmtech.ad.entity.Role;
import com.palmtech.ad.entity.RolePermission;
import com.palmtech.ad.entity.User;
import com.palmtech.ad.entity.UserRole;
import com.palmtech.ad.manager.RoleManager;
@Transactional
@Service("roleManager")
public class RoleManagerImpl implements RoleManager {

	static Logger logger = Logger.getLogger(RoleManagerImpl.class);
	@Autowired
	RoleDao roleDao;
	@Autowired
	UserRoleDao userRoleDao;
	@Autowired
	RolePermissionDao rolePermissionDao;
	@Autowired
	UserDao userDao;
	@Autowired
	PermissionDao permissionDao;
	
	
	

	public void save(Role role) {
		Assert.notNull(role, "角色不存在");
		Assert.hasText(role.getName(), "角色名称不能为空");
		Assert.hasText(role.getContent(), "显示名称不能为空");
		role.setCreateTime(new Date());
		role.setLasteditTime(new Date());
		
		roleDao.save(role);
	}

	/**
	 * 超级管理员不能被删除
	 * 
	 * @param role
	 * @throws Exception
	 */
	public void delete(Role role) {
		Assert.notNull(role, "角色不存在");
		Assert.isTrue(role.getId() != 1, "SU不能被删除");
		
		roleDao.delete(role);
	}
	
	public void deleteById(Integer id) {
		Role role = (Role) roleDao.getByPk(id);
		delete(role);

	}

	/**
	 * 超级管理员不能被修改
	 * 
	 * @param role
	 * @throws Exception
	 */

	public void update(Role role) {
		Assert.notNull(role, "角色不存在");
		Assert.hasText(role.getName(), "角色名称不能为空");
		Assert.hasText(role.getContent(), "显示名称不能为空");

		role.setLasteditTime(new Date());
	
		roleDao.update(role);
	}

	public Role findById(Integer id) {
		Assert.notNull(id);
		return  roleDao.getByPk(id);
	}

	public List<Role> findAll() {
		return  roleDao.findAll(null);
	}
	@Override
	public List<Permission> findAllPermission() {
		return permissionDao.findAll(null);
	}



	/**
	 * 根据用户找userRole
	 * 
	 * @param username
	 * @return
	 */
	@Override
	public List<UserRole> findUserRoles(User user) {
		
		
		return userRoleDao.findAllByProperty("user", user, null);
	}

	/**
	 * 根据role查找userrole
	 * 
	 * @param role
	 * @return
	 */

	public List<UserRole> findUsersByRole(Role role) {
		Assert.notNull(role);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("role", role);
		return  userRoleDao.findAllByPropertys(map, null);
	}

	/**
	 * 根据role查找rolepermission
	 * 
	 * @param role
	 * @return
	 */
	
	public List<RolePermission> findPermissionsByRole(Role role) {
		Assert.notNull(role);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("role", role);
		return  rolePermissionDao.findAllByPropertys( map,null);
	}
	
	@Override
	public void updateUserRoles(Set<Integer> roleIds,Integer userid){
		Assert.notNull(userid, "用户ID不能为空");
		User user = userDao.getByPk(userid);
		Assert.notNull(user, "用户不存在");
		List<UserRole> list = findUserRoles(user);
		for(UserRole userRole : list){  //删除
			if(!roleIds.contains(userRole.getRole().getId())){
				logger.info("用户："+user.getUsername()+" 移除"+userRole.getRole().getName()+"角色");
				userRoleDao.delete(userRole);
			}
		}
		
		for(Integer roleId :roleIds){ //添加
			Role role = roleDao.getByPk(roleId);
			Assert.notNull(role, "角色："+roleId+"不存在");
			boolean flag =true;
			for(UserRole userrole : list){
				if(roleId.equals(userrole.getRole().getId())){
					flag =false;
					break;
				}
			}
			if(flag){//添加
				UserRole userRole =new UserRole();
				userRole.setRole(role);				
				userRole.setUser(user);
				userRoleDao.save(userRole);
				logger.info("用户："+user.getUsername()+" 添加"+role.getName()+"角色");
			}
		}
		
	}

	/**
	 * 修改role与permission关系
	 */
	public void updateRolePermissions(Set<Integer> permissionIds, Integer roleid) {
		Assert.notNull(roleid, "角色ID不能为空");
		Role role = findById(roleid);
		Assert.notNull(role, "角色不存在");
		List<RolePermission> list = findPermissionsByRole(role);
		for (RolePermission rolePermission : list) {// 删除

			if (!permissionIds.contains(rolePermission.getPermission().getId())) {
				logger.info("角色："+role.getName()+" 移除"+rolePermission.getPermission().getPermission()+"权限");
				rolePermissionDao.delete(rolePermission);
			}
		}
		
		for(Integer permissionId:permissionIds){//增加
			Permission permission = (Permission)permissionDao.getByPk(permissionId);
			Assert.notNull(permission, "权限："+permissionId+"不存在");
			boolean flag =true;
			for(RolePermission rolePermission : list){
				if(permissionId.equals(rolePermission.getPermission().getId())){
					flag =false;
					break;
				}
			}
			if(flag){//添加
				RolePermission rolePermission =new RolePermission();
				rolePermission.setRole(role);				
				rolePermission.setPermission(permission);
				rolePermissionDao.save(rolePermission);
				logger.info("角色："+role.getName()+" 添加"+rolePermission.getPermission().getPermission()+"权限");
			}
		}
	//	com.huayang.common.security.RedisCacheManager cacheManager 
	//	=(com.huayang.common.security.RedisCacheManager)SpringContext.getBean("cacheManager");
	//	if(null!= cacheManager && null!=cacheManager.getCache("securityCache")){
	//		cacheManager.getCache("com.huayang.security.shiro.MyRealm.authorizationCache").clear();
	//	}
	
		
	}

	
}
