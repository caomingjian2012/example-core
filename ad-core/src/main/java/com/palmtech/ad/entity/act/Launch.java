package com.palmtech.ad.entity.act;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;



/**
 * 启动
 *
 */
@Entity
@Table(name="launch",schema="adact")
public class Launch implements java.io.Serializable{
	

	private static final long serialVersionUID = 6123446129827319976L;
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "assigned")
	@GeneratedValue(generator = "idGenerator")
	@Column(name="id")
	private  Long id;
	
	@Column(name="clientId")
	private  Long clientId;
	
	@Column(name="uuid")
	private String uuid;

	@Column(name="createTime")
	private  Date createTime;
	
	@Column(name="network")
	private String network;
	
	@Column(name="installationid")
	private String installationid;

	
	@Column(name="apkName")
	private String apkName;
	
	 

	public String getApkName() {
		return apkName;
	}

	public void setApkName(String apkName) {
		this.apkName = apkName;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
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

	public String getNetwork() {
		return network;
	}

	public void setNetwork(String network) {
		this.network = network;
	}

	public String getInstallationid() {
		return installationid;
	}

	public void setInstallationid(String installationid) {
		this.installationid = installationid;
	}
	
	

}

