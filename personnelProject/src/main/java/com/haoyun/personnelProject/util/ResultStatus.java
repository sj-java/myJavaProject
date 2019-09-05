package com.haoyun.personnelProject.util;

public enum ResultStatus {
	
	SUCCESS(0,"成功"),
	FAIL(1,"失败"),
	;
	 private final int code;
	 private final String message;
	 
	 ResultStatus(int code,String message){
		 this.code=code;
		 this.message=message;
	 }

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
	 
	 
	
}
