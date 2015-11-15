package com.palmtech.ad.entity.mk;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="cpa_profit")
public class CpaProfit  implements Serializable{
	
	private static final long serialVersionUID = -3334110188362104102L;

	@Id
	@GenericGenerator(name = "idGenerator", strategy = "identity")
	@GeneratedValue(generator = "idGenerator")
	@Column(name="id")
	private Integer id;
	
	@Column(name="calendar")
	private Date calendar;
	
	@Column(name="apk")
	private String apk;
	

	
	@Column(name="actives")
	private Integer actives;

	@Column(name="price")
	private Integer price;
	
	@Column(name="marketProfit")
	private Integer marketProfit;
	
	
	
	@Column(name="createTime")
	private Date createTime;
	
	@Column(name="lastEditTime")
	private Date lastEditTime;
	
	@Column(name="lastEditor")
	private String lastEditor;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCalendar() {
		return calendar;
	}

	public void setCalendar(Date calendar) {
		this.calendar = calendar;
	}

	public Date getLastEditTime() {
		return lastEditTime;
	}

	public void setLastEditTime(Date lastEditTime) {
		this.lastEditTime = lastEditTime;
	}

	public String getLastEditor() {
		return lastEditor;
	}

	public void setLastEditor(String lastEditor) {
		this.lastEditor = lastEditor;
	}

	

	public Integer getMarketProfit() {
		return marketProfit;
	}

	public void setMarketProfit(Integer marketProfit) {
		this.marketProfit = marketProfit;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getActives() {
		return actives;
	}

	public void setActives(Integer actives) {
		this.actives = actives;
	}



	public Integer getPrice() {
		return price;
	}

	
	public String getApk() {
		return apk;
	}

	public void setApk(String apk) {
		this.apk = apk;
	}

	public BigDecimal getPriceByYuan() {
		return new BigDecimal(this.price/100);
	}

	public void setPriceByYuan(BigDecimal priceByYuan) {
		this.price = priceByYuan.multiply(new BigDecimal(100)).intValue();
	}

	public BigDecimal getMarketProfitByYuan() {
		BigDecimal d=  new BigDecimal((this.marketProfit+0.0f)/100);
		BigDecimal rt=   d.setScale(2, BigDecimal.ROUND_HALF_UP);
		  return rt;
		
	}

	public void setMarketProfitByYuan(BigDecimal marketProfitByYuan) {
		
		this.marketProfit =marketProfitByYuan.multiply(new BigDecimal(100)).intValue();
	}
	
	

}
