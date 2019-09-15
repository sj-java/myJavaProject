package com.haoyun.personnelProject.bean;
/**
 * 合同实体类
 * @author Admin
 *
 */
public class ContractBean {
	/**
	 * 合同ID
	 */
	private String id;
	/**
	 * 合同所属人员ID
	 */
	private String personnelId;
	/**
	 * 合同名称
	 */
	private String contractName;
	/**
	 * 合同编号
	 */
	private String contractCode;
	/**
	 * 签订日期
	 */
	private String signDate;
	/**
	 * 是否是长期合同
	 */
	private String isLongContract;
	/**
	 * 到期日期
	 */
	private String expireDate;
	/**
	 * 备注
	 */
	private String remark;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPersonnelId() {
		return personnelId;
	}
	public void setPersonnelId(String personnelId) {
		this.personnelId = personnelId;
	}
	public String getContractName() {
		return contractName;
	}
	public void setContractName(String contractName) {
		this.contractName = contractName;
	}
	public String getContractCode() {
		return contractCode;
	}
	public void setContractCode(String contractCode) {
		this.contractCode = contractCode;
	}
	public String getSignDate() {
		return signDate;
	}
	public void setSignDate(String signDate) {
		this.signDate = signDate;
	}
	public String getIsLongContract() {
		return isLongContract;
	}
	public void setIsLongContract(String isLongContract) {
		this.isLongContract = isLongContract;
	}
	public String getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "ContractBean [id=" + id + ", personnelId=" + personnelId + ", contractName=" + contractName
				+ ", contractCode=" + contractCode + ", signDate=" + signDate + ", isLongContract=" + isLongContract
				+ ", expireDate=" + expireDate + ", remark=" + remark + "]";
	}

}
