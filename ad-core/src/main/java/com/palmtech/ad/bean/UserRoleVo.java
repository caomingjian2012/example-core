package com.palmtech.ad.bean;

import com.palmtech.ad.entity.Role;

public class UserRoleVo extends Role {
	Role role;
	boolean checked = false;
	
	
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	@Override
	public Integer getId() {
		
		return role.getId();
	}
	@Override
	public String getName() {
		return role.getName();
	}
	@Override
	public String getContent() {
		
		return role.getContent();
	}
	public UserRoleVo(Role role, boolean checked) {
		super();
		this.role = role;
		this.checked = checked;
	}

	
	
	
	

}
