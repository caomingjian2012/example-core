package com.palmtech.ad.entity.act;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;



/**
 * 安装广告成功
 *
 */
@Entity
@Table(name="ad_active",schema="adact")
public class AdActive implements java.io.Serializable{
	

	private static final long serialVersionUID = 6123446129827319976L;
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "assigned")
	@GeneratedValue(generator = "idGenerator")
	@Column(name="id")
	private  Long id;
	
	@Column(name="clientId")
	private  Long clientId;
	@Column(name="uuid")
	private  String uuid;

	@Column(name="createTime")
	private  Date createTime;
	
	@Column(name="ad")
	private String ad;
	@Column(name="appCd")
	private String appCd;
	
	@Column(name="apkName")
	private String apkName;
	
	 

	public String getApkName() {
		return apkName;
	}

	public void setApkName(String apkName) {
		this.apkName = apkName;
	}

	public String getAppCd() {
		return appCd;
	}

	public void setAppCd(String appCd) {
		this.appCd = appCd;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}


}

