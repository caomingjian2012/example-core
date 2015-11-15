package com.palmtech.ad.bean;

import com.palmtech.ad.entity.Permission;

public class RolePermissionVo extends Permission {
	Permission permission;
	boolean flag =false;
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	@Override
	public Integer getId() {
		
		return permission.getId();
	}
	@Override
	public String getPermission() {
		
		return permission.getPermission();
	}
	@Override
	public String getContent() {
		
		return permission.getContent();
	}
	public RolePermissionVo(Permission permission, boolean flag) {
		super();
		this.permission = permission;
		this.flag = flag;
	}
	
	
}
