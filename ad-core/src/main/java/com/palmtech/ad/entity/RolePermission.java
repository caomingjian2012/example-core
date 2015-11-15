package com.palmtech.ad.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.annotations.GenericGenerator;



/**
 * 
 * table (palmcms_acl_role_permission)
 *
 */

@Entity
@Table(name="palmcms_acl_role_permission")
public class RolePermission implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	


	@Id
	@GenericGenerator(name = "idGenerator", strategy = "identity")
	@GeneratedValue(generator = "idGenerator")
	@Column(name="id")
	private java.lang.Integer id;
	
	@ManyToOne
	@JoinColumn(name="role_id")
	private Role role;
	
	@ManyToOne
	@JoinColumn(name="permission_id")
	private Permission permission;
	


	public RolePermission(){
	}

	public RolePermission(
		java.lang.Integer id
	){
		this.id = id;
	}

	

	public void setId(java.lang.Integer value) {
		this.id = value;
	}
	
	
	public java.lang.Integer getId() {
		return this.id;
	}
	

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Permission getPermission() {
		return permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("RoleId",role.getId())
			.append("PermissionId",permission.getId())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof RolePermission == false) return false;
		if(this == obj) return true;
		RolePermission other = (RolePermission)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

