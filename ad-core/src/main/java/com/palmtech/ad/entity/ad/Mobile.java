package com.palmtech.ad.entity.ad;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.util.StringUtils;

/**
 * 客户端用户
 * @author kid
 *
 */
@Entity
@Table(name="mobile")
public class Mobile {

	@Id
	@GenericGenerator(name = "idGenerator", strategy = "assigned")
	@GeneratedValue(generator = "idGenerator")
	@Column(name="uuid")
	private String uuid;//设备产生唯一的UUID
	
	@Column(name="imei")
	private String imei;
	@Column(name="imsi")
	private String imsi;//
	
	@Column(name="model")
	private String model;//手机型号
	@Column(name="azversion")
	private String azversion;//android版本
	@Column(name="carrier")
	private Integer carrier;
	@Column(name="region")
	private Integer region;
	
	@Column(name="country")
	private String country;
	
	@Column(name="accessType")
	private String accessType;
	
	@Column(name="ip")
	private String ip;

	@Column(name="updateTime")
	private Date updateTime;
	@Column(name="createTime")
	private Date createTime;
	@Column(name="initApk")
	private String initApk;
	
	

	public String getInitApk() {
		return initApk;
	}

	public void setInitApk(String initApk) {
		this.initApk = initApk;
	}

	public String getAzversion() {
		return azversion;
	}

	public void setAzversion(String azversion) {
		this.azversion = azversion;
	}

	public Integer getCarrier() {
		return carrier;
	}

	public void setCarrier(Integer carrier) {
		this.carrier = carrier;
	}

	

	public Integer getRegion() {
		return region;
	}

	public void setRegion(Integer region) {
		this.region = region;
	}



	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	 

	 
	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getImsi() {
		return imsi;
	}

	public void setImsi(String imsi) {
		this.imsi = imsi;
	}

	 
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
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

	public String getAccessType() {
		return accessType;
	}

	public void setAccessType(String accessType) {
		this.accessType = accessType;
	}

	public boolean isGpAble(){
		if(StringUtils.hasText(accessType)){
			if(accessType.contains("gp")){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}

	@Override
	public String toString() {
		return "Mobile [uuid=" + uuid + ", imei=" + imei + ", imsi=" + imsi
				+ ", model=" + model + ", azversion=" + azversion
				+ ", carrier=" + carrier + ", region=" + region + ", country="
				+ country + ", accessType=" + accessType + ", ip=" + ip
				+ ", updateTime=" + updateTime + ", createTime=" + createTime
				+ ", initApk=" + initApk + "]";
	}
	
	
}
	 
