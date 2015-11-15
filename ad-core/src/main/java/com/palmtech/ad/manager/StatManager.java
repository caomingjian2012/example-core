package com.palmtech.ad.manager;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface StatManager {
	/**
	 * 统计广告效果
	 * @param adcd 广告CD
	 * @param begin 
	 * @param end
	 * @return
	 */
	public List<Map> statAd(String adcd,Date begin,Date end);
	
	/**
	 * 统计APP推广效果
	 * @param adcd 广告CD
	 * @param begin 
	 * @param end
	 * @return
	 */
	public List<Map> statApp(String apcd,Date begin,Date end);
	
	/**
	 * 统计渠道
	 * @return
	 */
	public List<Map> statChannel();

}
