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
 * table (palmcms_acl_user)
 *
 */
@Entity
@Table(name="palmcms_acl_user")
public class User implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	


	@Id
	@GenericGenerator(name = "idGenerator", strategy = "identity")
	@GeneratedValue(generator = "idGenerator")
	@Column(name="id")
	private java.lang.Integer id;
	@Column(name="username",nullable=true,unique=true)
	private java.lang.String username;
	@Column(name="password")
	private java.lang.String password;
	@Column(name="name")
	private java.lang.String name;
	@Column(name="gender")
	private java.lang.String gender;
	@Column(name="mail")
	private java.lang.String mail;
	@Column(name="telephone")
	private java.lang.String telephone;
	@Column(name="status")
	private java.lang.String status;
	@Column(name="create_time")
	private java.util.Date createTime;
	
	
	public User(){
	}

	public User(
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
	
			
	


	public java.lang.String getUsername() {
		return this.username;
	}
	
	public void setUsername(java.lang.String value) {
		this.username = value;
	}
	
			
	
	public java.lang.String getPassword() {
		return this.password;
	}
	
	public void setPassword(java.lang.String value) {
		this.password = value;
	}
	
			
	
	public java.lang.String getName() {
		return this.name;
	}
	
	public void setName(java.lang.String value) {
		this.name = value;
	}
	
			
	
	public java.lang.String getGender() {
		return this.gender;
	}
	
	public void setGender(java.lang.String value) {
		this.gender = value;
	}
	
			
	
	public java.lang.String getMail() {
		return this.mail;
	}
	
	public void setMail(java.lang.String value) {
		this.mail = value;
	}
	
			
	
	public java.lang.String getTelephone() {
		return this.telephone;
	}
	
	public void setTelephone(java.lang.String value) {
		this.telephone = value;
	}
	
			
	
	public java.lang.String getStatus() {
		return this.status;
	}
	
	public void setStatus(java.lang.String value) {
		this.status = value;
	}
	
			
	
	public java.util.Date getCreateTime() {
		return this.createTime;
	}
	
	public void setCreateTime(java.util.Date value) {
		this.createTime = value;
	}
	

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("Username",getUsername())
			.append("Password",getPassword())
			.append("Name",getName())
			.append("Gender",getGender())
			.append("Mail",getMail())
			.append("Telephone",getTelephone())
			.append("Status",getStatus())
			.append("CreateTime",getCreateTime())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof User == false) return false;
		if(this == obj) return true;
		User other = (User)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

