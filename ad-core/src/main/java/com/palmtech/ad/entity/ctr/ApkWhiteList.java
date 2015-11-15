package com.palmtech.ad.entity.ctr;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;



/**
 * 包名单
 *
 */
@Entity
@Table(name="t_apk_whitelist")
public class ApkWhiteList implements java.io.Serializable{
	

	private static final long serialVersionUID = 6123446129827319976L;
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "identity")
	@GeneratedValue(generator = "idGenerator")
	@Column(name="id")
	private  Integer id;
	
	@Column(name="name")
	private  String name;

	@Column(name="createTime")
	private  Date createTime;
	
	@Column(name="remark")
	private String remark;

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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	

}

