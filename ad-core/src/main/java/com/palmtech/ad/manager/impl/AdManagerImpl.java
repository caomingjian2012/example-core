package com.palmtech.ad.manager.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.BaseService;
import com.common.plugins.myframework.DaoInterface;
import com.palmtech.ad.dao.AdDao;
import com.palmtech.ad.dao.PushAppDao;
import com.palmtech.ad.entity.ad.Ad;
import com.palmtech.ad.entity.ad.AdQuery;
import com.palmtech.ad.entity.ad.PushApp;
import com.palmtech.ad.entity.constants.AdStateType;
import com.palmtech.ad.manager.AdManager;
import com.palmtech.ad.manager.SeqManager;


@Transactional
@Service("AdManager")
public class AdManagerImpl extends BaseService<Ad, String> implements AdManager {
	Logger logger = Logger.getLogger(AdManagerImpl.class);
	
	@Autowired
	AdDao AdDao;
	
	@Autowired
	SeqManager seqManager;
	
	@Autowired
	PushAppDao pushAppDao;
	
	
	@Override
	public Page<Ad> findPage(AdQuery query) {
		Assert.notNull(query);
		return AdDao.findPage(query);
	}

	@Override
	protected DaoInterface<Ad, String> getDAO() {
		
		return AdDao;
	}

	@Override
	public void save(Ad entity) {
		Assert.notNull(entity, "对象不能为空");
		Assert.notNull(entity.getAppCd(), "APPCD不能为空");
		PushApp app=pushAppDao.getByPk(entity.getAppCd());
		
		Assert.notNull(app, "推广APP不存在");
		String cd = "AD"+seqManager.getSeq("adCd");
		
		entity.setCode(cd);
		
		entity.setCreateTime(new Date());
		entity.setUpdateTime(new Date());
		entity.setState(AdStateType.UP.getValue());
		super.save(entity);
	}

	@Override
	public void autoDown() {
		String sql ="update ad set  state =0  where  endtime < now()";
		AdDao.execute(sql);
		
	}

	@Override
	public Map<String, Ad> findAll2Map() {
		List<Ad> list =getDAO().findAll("");
		Map<String,Ad> rt = new HashMap<String, Ad>();
		for(Ad o :list){
			rt.put(o.getCode(), o);
		}
		
		return rt ;
	}
	
	

}
