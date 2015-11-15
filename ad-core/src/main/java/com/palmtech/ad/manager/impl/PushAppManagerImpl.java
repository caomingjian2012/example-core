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
import com.palmtech.ad.dao.PushAppDao;
import com.palmtech.ad.entity.ad.Apk;
import com.palmtech.ad.entity.ad.PushApp;
import com.palmtech.ad.entity.ad.PushAppQuery;
import com.palmtech.ad.entity.constants.AdStateType;
import com.palmtech.ad.manager.PushAppManager;
import com.palmtech.ad.manager.SeqManager;


@Transactional
@Service("PushAppManager")
public class PushAppManagerImpl extends BaseService<PushApp, String> implements PushAppManager {
	Logger logger = Logger.getLogger(PushAppManagerImpl.class);
	
	@Autowired
	PushAppDao PushAppDao;
	
	@Autowired
	SeqManager seqManager;
	
	
	@Override
	public Page<PushApp> findPage(PushAppQuery query) {
		Assert.notNull(query);
		return PushAppDao.findPage(query);
	}

	@Override
	protected DaoInterface<PushApp, String> getDAO() {
		
		return PushAppDao;
	}

	@Override
	public void save(PushApp entity) {
		Assert.notNull(entity, "对象不能为空");
		Assert.hasText(entity.getName(), "名称不能为空");
		Assert.hasText(entity.getUrl(), "APK地址不能为空");
		Assert.hasText(entity.getIcon(), "ICON不能为空");
		
		
		String code = "PA"+seqManager.getSeq("appCd");
		
		entity.setCode(code);		
		entity.setState(1);
		entity.setCreateTime(new Date());
		super.save(entity);
	}

	@Override
	public Map<String, PushApp> findAll2Map() {
		List<PushApp> list =getDAO().findAll("");
		Map<String,PushApp> rt = new HashMap<String, PushApp>();
		for(PushApp o :list){
			rt.put(o.getCode(), o);
		}
		
		return rt ;
	}

	@Override
	public List<PushApp> findAbleApp() {
		List<PushApp> list = PushAppDao.findAllByProperty("state", AdStateType.UP.getValue(), "");
		return list;
	}
	
	
	

}
