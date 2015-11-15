package com.palmtech.ad.entity.constants;

/**
 * 状态
 * @author Administrator
 *
 */
public enum AdStateType {
	UP(1,"有效"),
	DOWN(0,"无效");
	
	
	
	private int value;
	private String comment;
	private AdStateType(int value,String comment){
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

	public static AdStateType get(int value){
		for (AdStateType o:AdStateType.values()) {
			if(o.value ==value){
				return o;
			}
		}
		return null;
	}
	
}
