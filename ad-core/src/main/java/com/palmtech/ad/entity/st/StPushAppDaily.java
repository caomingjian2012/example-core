package com.palmtech.ad.entity.st;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;



/**
 * 每日统计PUSHAPP
 *
 */
@Entity
@Table(name="st_pushapp_daily",schema="adst")
public class StPushAppDaily implements java.io.Serializable{
	

	private static final long serialVersionUID = 6123446129827319976L;
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "identity")
	@GeneratedValue(generator = "idGenerator")
	@Column(name="id")
	private  Long id;
	
	@Column(name="calendar")
	private  Date calendar;
	
	@Column(name="appCd")
	private  String appCd;

	
	
	@Column(name="responses")
	private Long responses;
	
	@Column(name="responsemans")
	private Long responsemans;
	
	@Column(name="shows")
	private Long shows;
	
	@Column(name="showmans")
	private Long showmans;
	
	@Column(name="clicks")
	private Long clicks;
	
	@Column(name="clickmans")
	private Long clickmans;
	
	@Column(name="downloads")
	private Long downloads;
	
	@Column(name="downloadmans")
	private Long downloadmans;
	
	@Column(name="installs")
	private Long installs;
	
	@Column(name="installmans")
	private Long installmans;
	
	@Column(name="actives")
	private Long actives;

	@Column(name="activemans")
	private Long activemans;
	
	 

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCalendar() {
		return calendar;
	}

	public void setCalendar(Date calendar) {
		this.calendar = calendar;
	}



	public String getAppCd() {
		return appCd;
	}

	public void setAppCd(String appCd) {
		this.appCd = appCd;
	}

	public Long getResponses() {
		return responses;
	}

	public void setResponses(Long responses) {
		this.responses = responses;
	}

	public Long getShows() {
		return shows;
	}

	public void setShows(Long shows) {
		this.shows = shows;
	}

	public Long getShowmans() {
		return showmans;
	}

	public void setShowmans(Long showmans) {
		this.showmans = showmans;
	}

	public Long getClicks() {
		return clicks;
	}

	public void setClicks(Long clicks) {
		this.clicks = clicks;
	}

	public Long getClickmans() {
		return clickmans;
	}

	public void setClickmans(Long clickmans) {
		this.clickmans = clickmans;
	}

	public Long getDownloads() {
		return downloads;
	}

	public void setDownloads(Long downloads) {
		this.downloads = downloads;
	}

	public Long getDownloadmans() {
		return downloadmans;
	}

	public void setDownloadmans(Long downloadmans) {
		this.downloadmans = downloadmans;
	}

	public Long getInstalls() {
		return installs;
	}

	public void setInstalls(Long installs) {
		this.installs = installs;
	}

	public Long getInstallmans() {
		return installmans;
	}

	public void setInstallmans(Long installmans) {
		this.installmans = installmans;
	}

	public Long getActives() {
		return actives;
	}

	public void setActives(Long actives) {
		this.actives = actives;
	}

	public Long getActivemans() {
		return activemans;
	}

	public void setActivemans(Long activemans) {
		this.activemans = activemans;
	}

	

	@Override
	public String toString() {
		return "StPushAppDaily [id=" + id + ", calendar=" + calendar
				+ ", appCd=" + appCd + ", responses=" + responses
				+ ", responsemans=" + responsemans + ", shows=" + shows
				+ ", showmans=" + showmans + ", clicks=" + clicks
				+ ", clickmans=" + clickmans + ", downloads=" + downloads
				+ ", downloadmans=" + downloadmans + ", installs=" + installs
				+ ", installmans=" + installmans + ", actives=" + actives
				+ ", activemans=" + activemans + "]";
	}

	public Long getResponsemans() {
		return responsemans;
	}

	public void setResponsemans(Long responsemans) {
		this.responsemans = responsemans;
	}

	

}

