package com.palmtech.ad.entity.constants;

/**
 * 计费类型
 * @author Administrator
 *
 */
public enum FeeType {
	CPA(1,"CPA"),
	CPS(2,"CPS");
	
	
	
	private int value;
	private String comment;
	private FeeType(int value,String comment){
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

	public static FeeType get(int value){
		for (FeeType o:FeeType.values()) {
			if(o.value ==value){
				return o;
			}
		}
		return null;
	}
	
}
