package com.palmtech.ad.entity.ad;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.util.StringUtils;

import com.common.plugins.ConvertTools;

@Entity
@Table(name="push_app")
public class PushApp {
	

	@Id
	@GenericGenerator(name = "idGenerator", strategy = "assigned")
	@GeneratedValue(generator = "idGenerator")
	@Column(name="code")
	private String code;  //appCd


	@Column(name="name")
	private String name;
	

	@Column(name="packagename")
	private String packageName;
	
	@Column(name="url")
	private String url;
	
	@Column(name="icon")
	private String icon;

	
	
	@Column(name="intro")
	private String intro;
	
	
	@Column(name="size")
	private String size;
	
	@Column(name="version")
	private String version;
	
	
	@Column(name="state")
	private Integer state;

	@Column(name="updatetime")
	private Date updateTime;
	@Column(name="createtime")
	private Date createTime;
	
	@Column(name="type")
	private String type;
	
	
	@Column(name="countrys")
	private String countrys;
	
	
	
	@Transient
	private String countryArr;
	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getVersion() {
		return version;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
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

	public String getCountryArr() {
		if(StringUtils.hasText(countryArr)){
			return countryArr;
		}
		if(StringUtils.hasText(countrys)){
			return ConvertTools.jsonStr2commaString(countrys);
		}
		
		return "";
	}

	public void setCountryArr(String countryArr) {
		
		this.countryArr = countryArr;
	}
	
	
	
	public String getCountrys() {
		return countrys;
	}

	public void setCountrys(String countrys) {
		this.countrys = countrys;
	}

	@Override
	public String toString() {
		return "PushApp [code=" + code + ", name=" + name + ", packageName="
				+ packageName + ", url=" + url + ", icon=" + icon + ", intro="
				+ intro + ", size=" + size + ", version=" + version
				+ ", state=" + state + ", updateTime=" + updateTime
				+ ", createTime=" + createTime + "]";
	}
	
	
}
