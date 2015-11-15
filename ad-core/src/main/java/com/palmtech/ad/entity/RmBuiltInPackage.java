package com.palmtech.ad.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.util.StringUtils;

/***
 * 删除内置包
 * @author kid
 *
 */
@Entity
@Table(name="rm_built_in_package")
public class RmBuiltInPackage {
	
	
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "identity")
	@GeneratedValue(generator = "idGenerator")
	@Column(name="id")
	private Integer id;
	
	
	@Column(name="packageName")
	private String packageName;
	
	@Column(name="name")
	private String name;
	
	@Column(name="status")
	private String status;
	@Column(name="createTime")
	private Date createTime;

	
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Boolean isDelStatus(){
		if(StringUtils.hasLength(status)){
			if("Y".equalsIgnoreCase(status)){
				return true;
			}else{
				return false;
			}
		}else{
			return null;
		}
	}
	
}
