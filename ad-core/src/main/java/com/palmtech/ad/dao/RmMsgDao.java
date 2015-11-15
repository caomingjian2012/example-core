package com.palmtech.ad.dao;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.DaoInterface;
import com.palmtech.ad.entity.act.RmMsg;
import com.palmtech.ad.entity.act.RmMsgQuery;

public interface RmMsgDao extends DaoInterface<RmMsg,java.lang.Long> {

	Page<RmMsg> findPage(RmMsgQuery query);
	

}
