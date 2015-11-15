package com.palmtech.ad.entity.ad;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="dev_app")
public class DevApp {
	

	@Id
	@GenericGenerator(name = "idGenerator", strategy = "assigned")
	@GeneratedValue(generator = "idGenerator")
	@Column(name="code")
	private String code;  //appCd

	@Column(name="appKey")
	private String appKey; //AppKey

	@Column(name="name")
	private String name;
	
	@Column(name="state")
	private Integer state;
	@Column(name="remark")
	private String remark;
	@Column(name="updateTime")
	private Date updateTime;
	@Column(name="createTime")
	private Date createTime;



	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	
	

	public String getAppKey() {
		return appKey;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	@Override
	public String toString() {
		return "DevApp [code=" + code + ", key=" + appKey + ", name=" + name
				+ ", state=" + state + ", remark=" + remark + ", updateTime="
				+ updateTime + ", createTime=" + createTime + "]";
	}
	
	
}
