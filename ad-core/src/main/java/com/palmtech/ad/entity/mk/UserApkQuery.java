package com.palmtech.ad.entity.mk;

import com.common.plugins.myframework.BaseQuery;



public class UserApkQuery extends BaseQuery  {
    private static final long serialVersionUID = 3148176768559230877L;
    
    String username;
    String apk;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getApk() {
		return apk;
	}
	public void setApk(String apk) {
		this.apk = apk;
	}
	@Override
	public String toString() {
		return "UserApkQuery [username=" + username + ", apk=" + apk + "]";
	}
    
	
}

