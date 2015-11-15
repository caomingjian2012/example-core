package com.palmtech.ad.manager;

import java.util.List;
import java.util.Set;

import com.palmtech.ad.entity.Permission;
import com.palmtech.ad.entity.Role;
import com.palmtech.ad.entity.RolePermission;
import com.palmtech.ad.entity.User;
import com.palmtech.ad.entity.UserRole;

/**
 * 角色管理
 * @author Administrator
 *
 */
public interface RoleManager {
	public void save(Role role) ;

	/**
	 * 超级管理员不能被删除
	 * 
	 * @param role
	 * @throws Exception
	 */
	public void delete(Role role);
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
	public void update(Role role) ;

	public Role findById(Integer id) ;

	public List<Role> findAll();



	/**
	 * 根据role查找userrole
	 * 
	 * @param role
	 * @return
	 */
	
	public List<UserRole> findUsersByRole(Role role) ;

	/**
	 * 根据role查找rolepermission
	 * 
	 * @param role
	 * @return
	 */

	public List<RolePermission> findPermissionsByRole(Role role) ;
	/**
	 * 修改role与permission关系
	 */
	public void updateRolePermissions(Set<Integer> permissionIds, Integer roleid) ;

	List<UserRole> findUserRoles(User user);

	void updateUserRoles(Set<Integer> roleIds, Integer userid);

	List<Permission> findAllPermission();

}
