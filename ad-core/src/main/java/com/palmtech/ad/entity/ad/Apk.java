package com.palmtech.ad.entity.ad;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 包
 * @author kid
 *
 */
@Entity
@Table(name="apk")
public class Apk {

	@Id
	@GenericGenerator(name = "idGenerator", strategy = "assigned")
	@GeneratedValue(generator = "idGenerator")
	@Column(name="code")
	private String code; 
	
	@Column(name="market")
	private String market;
	

	@Column(name="app")
	private String app;
	
	@Column(name="remark")
	private String remark;
	@Column(name="status")
	private Integer status;
	@Column(name="createTime")
	private Date createTime;
	
	@Column(name="type")
	private String type; //cps  cpa
	
	
	@Column(name="rate")
	private Integer rate; //cpa 比列
	
	@Column(name="unitPrice")
	private Integer unitPrice; //cpa 比列
	
	
	
	
	public String getApp() {
		return app;
	}
	public void setApp(String app) {
		this.app = app;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	
	public String getMarket() {
		return market;
	}
	public void setMarket(String market) {
		this.market = market;
	}
	public String getStatusStr(){
		if(0 == status){
			return "运营";
		}
		if(1 == status){
			return "暂停";
		}
		return "未知";
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getRate() {
		return rate;
	}
	public void setRate(Integer rate) {
		this.rate = rate;
	}
	public Integer getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	
}
