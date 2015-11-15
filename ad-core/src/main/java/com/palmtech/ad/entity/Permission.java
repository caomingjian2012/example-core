package com.palmtech.ad.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.annotations.GenericGenerator;



/**
 * 
 * table (palmcms_acl_permission)
 *
 */
@Entity
@Table(name="palmcms_acl_permission")
public class Permission implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	


	@Id
	@GenericGenerator(name = "idGenerator", strategy = "identity")
	@GeneratedValue(generator = "idGenerator")
	@Column(name="id")
	private java.lang.Integer id;
	
	@Column(name="permission",length=100,unique=true)
	private java.lang.String permission;
	
	@Column(name="content",length=100,unique=true)
	private java.lang.String content;
	

	public Permission(){
	}

	public Permission(
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
	
			
	
	public java.lang.String getPermission() {
		return this.permission;
	}
	
	public void setPermission(java.lang.String value) {
		this.permission = value;
	}
	
			
	
	public java.lang.String getContent() {
		return this.content;
	}
	
	public void setContent(java.lang.String value) {
		this.content = value;
	}
	

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("Permission",getPermission())
			.append("Content",getContent())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Permission == false) return false;
		if(this == obj) return true;
		Permission other = (Permission)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}


	
	
}

