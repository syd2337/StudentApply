package com.pojo;

import java.util.Date;

/**
 * @author syd2018-8-2����4:15:29
 * @version ����ʱ�䣺2018-8-2 ����4:15:29
 * ��˵��
 */
/**        
 * �����ƣ�School   
 * ��������   
 * �����ˣ�syd   
 * ����ʱ�䣺2018-8-2 ����4:15:29      
 * @version    
 *    
 */
public class School {
	/**
	 * ѧУid
	 */
	private String id;
	/**
	 * ѧУ����
	 */
	private String name;
	/**
	 * ѧУ��ע
	 */
	private String remark;
	/**
	 * ����ʱ��
	 */
	private Date createDate;
	/**
	 * �꼶����
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

}
