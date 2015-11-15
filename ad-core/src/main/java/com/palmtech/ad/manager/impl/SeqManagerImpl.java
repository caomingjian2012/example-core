package com.palmtech.ad.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.palmtech.ad.dao.SeqDao;
import com.palmtech.ad.manager.SeqManager;

@Service
public class SeqManagerImpl  implements SeqManager{
	@Autowired
	SeqDao seqDao;

	@Override
	public Integer getSeq(String key) {
		String sql ="select seq('"+key+"') as seq";
		return seqDao.sql4Number(sql).intValue();
	}
	
	@Override
	public Long getSeqLong(String key) {
		String sql ="select seq('"+key+"') as seq";
		return seqDao.sql4Number(sql).longValue();
	}

}
