package com.palmtech.ad.entity.ad;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 客户端用户
 * @author kid
 *
 */
@Entity
@Table(name="ad_client")
public class AdClient {

	@Id
	@GenericGenerator(name = "idGenerator", strategy = "assigned")
	@GeneratedValue(generator = "idGenerator")
	@Column(name="clientId")
	private Long clientId;
	
	@ManyToOne
	@JoinColumn(name="uuid")
	private Mobile mobile;
	
	@Column(name="apkName")
	private String apkName;
	@Column(name="network")
	private String network;//网络类型
	@Column(name="updateTime")
	private Date updateTime;
	@Column(name="createTime")
	private Date createTime;

	

	

	public Mobile getMobile() {
		return mobile;
	}

	public void setMobile(Mobile mobile) {
		this.mobile = mobile;
	}

	public String getApkName() {
		return apkName;
	}

	public void setApkName(String apkName) {
		this.apkName = apkName;
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
 

	public String getNetwork() {
		return network;
	}

	public void setNetwork(String network) {
		this.network = network;
	}
}
