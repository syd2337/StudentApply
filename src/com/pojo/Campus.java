package com.pojo;

import java.util.Date;

/**
 * @author syd2018-8-2����4:24:47
 * @version ����ʱ�䣺2018-8-2 ����4:24:47
 * ��˵��
 */
/**        
 * �����ƣ�Campus   
 * ��������   У��
 * �����ˣ�syd   
 * ����ʱ�䣺2018-8-2 ����4:24:47      
 * @version    
 *    
 */
public class Campus {
	/**
	 * У��id
	 */
	private String id;
	/**
	 * У������
	 */
	private String campusName;
	/**
	 * У����ע
	 */
	private String remark;
	/**
	 * ����ʱ��
	 */
	private Date createDate;
	/**
	 * У������
	 */
	private String code;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCampusName() {
		return campusName;
	}
	public void setCampusName(String campusName) {
		this.campusName = campusName;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

}
