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
 * table (palmcms_acl_role)
 *
 */
@Entity
@Table(name="palmcms_acl_role")
public class Role implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	


	@Id
	@GenericGenerator(name = "idGenerator", strategy = "identity")
	@GeneratedValue(generator = "idGenerator")
	@Column(name="id")
	private java.lang.Integer id;
	
	@Column(name="name",length=100,unique=true)
	private java.lang.String name;
	
	@Column(name="content",length=100,unique=true)
	private java.lang.String content;
	@Column(name="create_time")
	private java.util.Date createTime;
	@Column(name="lastedit_time")
	private java.util.Date lasteditTime;
	

	


	public Role(){
	}

	public Role(
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
	
			
	
	public java.lang.String getName() {
		return this.name;
	}
	
	public void setName(java.lang.String value) {
		this.name = value;
	}
	
			
	
	public java.lang.String getContent() {
		return this.content;
	}
	
	public void setContent(java.lang.String value) {
		this.content = value;
	}
	
			
	
	public java.util.Date getCreateTime() {
		return this.createTime;
	}
	
	public void setCreateTime(java.util.Date value) {
		this.createTime = value;
	}
	
			
	

	



	public java.util.Date getLasteditTime() {
		return lasteditTime;
	}

	public void setLasteditTime(java.util.Date lasteditTime) {
		this.lasteditTime = lasteditTime;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("Name",getName())
			.append("Content",getContent())
			.append("CreateTime",getCreateTime())
			.append("LasteditTime",getLasteditTime())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Role == false) return false;
		if(this == obj) return true;
		Role other = (Role)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

