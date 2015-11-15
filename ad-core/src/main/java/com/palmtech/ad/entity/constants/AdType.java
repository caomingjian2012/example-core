package com.palmtech.ad.entity.constants;

import java.util.Map;
import java.util.TreeMap;

/**
 * 广告类型
 * @author Administrator
 *
 */
public enum AdType {
	CHAPIN(1,"插屏"),
	PUSH(2,"PUSH"),
	BANNER(3,"BANNER"),
	BUILTIN(4,"ROOT内置"),
	SILENCE(5,"静默");
	
	
	private int value;
	private String comment;
	private AdType(int value,String comment){
		this.value = value;
		this.comment =comment;
	}
	
	public int getValue(){
		return value;
		
	}
	public String getComment(){
		return comment;
	}
	
	@Override
	public String toString() {
		
		return comment;
	}

	public static AdType get(int value){
		for (AdType o:AdType.values()) {
			if(o.value ==value){
				return o;
			}
		}
		return null;
	}
	
	public static Map<Integer,AdType> getMap(){
		AdType[] adTypes=AdType.values();
		Map<Integer, AdType> map =new TreeMap<Integer, AdType>();
		for(AdType o :adTypes){
			map.put(o.getValue(), o);
		}
		return map;
	}
	
}
