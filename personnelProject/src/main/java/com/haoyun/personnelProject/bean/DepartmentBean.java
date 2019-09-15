package com.haoyun.personnelProject.bean;

public class DepartmentBean {
	/**
	 * 部门ID
	 */
	private String id;
	/**
	 * 部门名称
	 */
	private String departmentName;
	/**
	 * 部门编号
	 */
	private String departmentCode;
	/**
	 * 部门等级（1级2级）
	 */
	private String departmentRank;
	/**
	 * 部门描述
	 */
	private String departmentDescribe;
	/**
	 * 父级部门ID
	 */
	private String fatherDepartmentId;
	/**
	 * 部门状态(0可用，1不可用)
	 */
	private String departmentState;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getDepartmentCode() {
		return departmentCode;
	}
	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}
	public String getDepartmentRank() {
		return departmentRank;
	}
	public void setDepartmentRank(String departmentRank) {
		this.departmentRank = departmentRank;
	}
	public String getDepartmentDescribe() {
		return departmentDescribe;
	}
	public void setDepartmentDescribe(String departmentDescribe) {
		this.departmentDescribe = departmentDescribe;
	}
	public String getFatherDepartmentId() {
		return fatherDepartmentId;
	}
	public void setFatherDepartmentId(String fatherDepartmentId) {
		this.fatherDepartmentId = fatherDepartmentId;
	}
	
	public String getDepartmentState() {
		return departmentState;
	}
	public void setDepartmentState(String departmentState) {
		this.departmentState = departmentState;
	}
	@Override
	public String toString() {
		return "DepartmentBean [id=" + id + ", departmentName=" + departmentName + ", departmentCode=" + departmentCode
				+ ", departmentRank=" + departmentRank + ", departmentDescribe=" + departmentDescribe
				+ ", fatherDepartmentId=" + fatherDepartmentId + ", departmentState=" + departmentState + "]";
	}
		
}
