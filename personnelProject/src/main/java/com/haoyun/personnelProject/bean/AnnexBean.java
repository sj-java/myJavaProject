package com.haoyun.personnelProject.bean;
/**
 * 附件实体类
 * @author Admin
 *
 */
public class AnnexBean {
	/**
	 * 附件ID
	 */
	private String id;
	/**
	 * 附件归属ID
	 */
	private String belongId;
	/**
	 * 附件名
	 */
	private String annexName;
	/**
	 * 附件后缀名
	 */
	private String lastName;
	/**
	 * 附件存储路径
	 */
	private String annexUrl;
	/**
	 * 附件上传时间
	 */
	private String uploadDate;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBelongId() {
		return belongId;
	}
	public void setBelongId(String belongId) {
		this.belongId = belongId;
	}
	public String getAnnexName() {
		return annexName;
	}
	public void setAnnexName(String annexName) {
		this.annexName = annexName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAnnexUrl() {
		return annexUrl;
	}
	public void setAnnexUrl(String annexUrl) {
		this.annexUrl = annexUrl;
	}
	public String getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}
	@Override
	public String toString() {
		return "AnnexBean [id=" + id + ", belongId=" + belongId + ", annexName=" + annexName + ", lastName=" + lastName
				+ ", annexUrl=" + annexUrl + ", uploadDate=" + uploadDate + "]";
	}
		
}
