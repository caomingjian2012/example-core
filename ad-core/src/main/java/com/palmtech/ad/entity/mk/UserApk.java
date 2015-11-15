package com.palmtech.ad.entity.mk;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="user_apk")
public class UserApk implements Serializable {

	
	private static final long serialVersionUID = -8021353444966274087L;



	@Id
	@GenericGenerator(name = "idGenerator", strategy = "identity")
	@GeneratedValue(generator = "idGenerator")
	@Column(name="id")
	private Integer id;
	
	
	
	@Column(name="username")
	private String  username;
	
	
	@Column(name="apk")
	private String apk;
	
	
	

	@Column(name="createTime")
	private Date createTime;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}


	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getApk() {
		return apk;
	}


	public void setApk(String apk) {
		this.apk = apk;
	}

	
}
