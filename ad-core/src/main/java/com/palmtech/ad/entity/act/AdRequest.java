package com.palmtech.ad.entity.act;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;



/**
 * 广告请求
 *
 */
@Entity
@Table(name="ad_request",schema="adact")
public class AdRequest implements java.io.Serializable{
	

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
	
	@Column(name="type")
	private Integer type;
	
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

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "AdRequest [id=" + id + ", clientId=" + clientId
				+ ", createTime=" + createTime + ", type=" + type + "]";
	}

	
	
	

}

