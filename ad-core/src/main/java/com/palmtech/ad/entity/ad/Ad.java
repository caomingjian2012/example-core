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

/***
 * 广告实体
 * @author kid
 *
 */
@Entity
@Table(name="ad")
public class Ad {
	
	

	
	
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "assigned")
	@GeneratedValue(generator = "idGenerator")
	@Column(name="code")
	private String code;
	
	@Column(name="appCd")
	private String appCd;
	
	@Column(name="adname")
	private String adname;
	@Column(name="slogan")
	private String slogan;
	@Column(name="type")
	private Integer type;//广告类型  属于 1：插屏，2：push，3：banner

	@Column(name="img")
	private String img;
	
	@Column(name="state")
	private Integer  state;
	@Column(name="createtime")
	private Date createTime;
	@Column(name="updatetime")
	private Date updateTime;
	
	@Column(name="orderId")
	private String  orderId;

	@Column(name="showtime")
	private Date showTime;
	@Column(name="endtime")
	private Date endTime;
	
	@Column(name="channels")
	private String channels;
	
	
	
	@Transient
	private String channelArr;
	@Column(name="responsemansMax")
	private Long responsemansMax;
	@Column(name="showmansMax")
	private Long showmansMax;
	@Column(name="installmansMax")
	private Long installmansMax;
	@Column(name="activemansMax")
	private Long activemansMax;
	


	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getAppCd() {
		return appCd;
	}

	public void setAppCd(String appCd) {
		this.appCd = appCd;
	}

	public String getSlogan() {
		return slogan;
	}

	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}
	
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	
	


	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}




	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getAdname() {
		return adname;
	}

	public void setAdname(String adname) {
		this.adname = adname;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}



	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Date getShowTime() {
		return showTime;
	}

	public void setShowTime(Date showTime) {
		this.showTime = showTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getChannels() {
		return channels;
	}

	public void setChannels(String channels) {
		this.channels = channels;
	}

	public String getChannelArr() {
		if(StringUtils.hasText(channelArr)){
			return channelArr;
		}
		if(StringUtils.hasText(channels)){
			return ConvertTools.jsonStr2commaString(channels);
		}
		
		return "";
	}

	public void setChannelArr(String channelArr) {
		
		this.channelArr = channelArr;
	}

	public Long getResponsemansMax() {
		return responsemansMax;
	}

	public void setResponsemansMax(Long responsemansMax) {
		this.responsemansMax = responsemansMax;
	}

	public Long getShowmansMax() {
		return showmansMax;
	}

	public void setShowmansMax(Long showmansMax) {
		this.showmansMax = showmansMax;
	}

	public Long getInstallmansMax() {
		return installmansMax;
	}

	public void setInstallmansMax(Long installmansMax) {
		this.installmansMax = installmansMax;
	}

	public Long getActivemansMax() {
		return activemansMax;
	}

	public void setActivemansMax(Long activemansMax) {
		this.activemansMax = activemansMax;
	}
	
	public String getMaxStr(){
		StringBuffer buffer =new StringBuffer();
		if(null!=responsemansMax){
			buffer.append("投放人数上限："+responsemansMax+"<br>");
		}
		if(null!=showmansMax){
			buffer.append("展示人数上限："+showmansMax+"<br>");
		}
		if(null!=installmansMax){
			buffer.append("安装人数上限："+installmansMax+"<br>");
		}
		if(null!=activemansMax){
			buffer.append("激活人数上限："+activemansMax+"");
		}
		return buffer.toString();
	}
}
