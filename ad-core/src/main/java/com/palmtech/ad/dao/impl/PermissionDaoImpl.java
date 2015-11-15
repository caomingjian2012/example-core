package com.palmtech.ad.dao.impl;

import org.springframework.stereotype.Repository;

import com.common.plugins.myframework.BaseDao;
import com.palmtech.ad.dao.PermissionDao;
import com.palmtech.ad.entity.Permission;
@Repository 
public class PermissionDaoImpl  extends BaseDao<Permission,Integer> implements PermissionDao  {

}
