package com.palmtech.ad.manager;

import cn.org.rapid_framework.page.Page;

import com.common.plugins.myframework.ServiceInterface;
import com.palmtech.ad.entity.act.RmMsg;
import com.palmtech.ad.entity.act.RmMsgQuery;


public interface RmMsgManager extends ServiceInterface<RmMsg, Long> {
	Page<RmMsg> findPage(RmMsgQuery query);

	
}
