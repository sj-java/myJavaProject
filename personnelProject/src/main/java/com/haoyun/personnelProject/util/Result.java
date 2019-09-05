package com.haoyun.personnelProject.util;

import java.io.Serializable;

/**
 * 处理结果
 * @author Admin
 *
 */
public class Result implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 668161119780955011L;
	
	private Object data;
	
	private String message;
	
	private int resultCode;
	
	
	//返回成功结果
	public static  Result resultSuccess(Object data) {
		Result result = new Result();
		result.data = data;
		result.message = ResultStatus.SUCCESS.getMessage();
		result.resultCode=ResultStatus.SUCCESS.getCode();
		return result;
	}
 
	//返回失败
	public static  Result resultError(Object data) {
		Result result = new Result();
		result.data = data;
		result.message = ResultStatus.FAIL.getMessage();
		result.resultCode=ResultStatus.FAIL.getCode();
		return result;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	
		

}
