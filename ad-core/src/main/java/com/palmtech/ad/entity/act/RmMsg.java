package com.palmtech.ad.entity.act;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/***
 * 删除信息
 * @author kid
 *
 */
@Entity
@Table(name="rm_msg",schema="adact")
public class RmMsg {
	
	

	@Id
	@GenericGenerator(name = "idGenerator", strategy = "assigned")
	@GeneratedValue(generator = "idGenerator")
	@Column(name="id")
	private Long id;
	
	
	@Column(name="packageName")
	private String packageName;
	
	@Column(name="userCd")
	private String userCd;
	
	@Column(name="msg")
	private String msg;
	@Column(name="createTime")
	private Date createTime;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public String getUserCd() {
		return userCd;
	}
	public void setUserCd(String userCd) {
		this.userCd = userCd;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "RmMsg [id=" + id + ", packageName=" + packageName + ", userCd="
				+ userCd + ", msg=" + msg + ", createTime=" + createTime + "]";
	}
	
	
}
