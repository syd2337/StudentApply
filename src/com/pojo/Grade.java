package com.pojo;

import java.util.Date;

/**
 * @author syd2018-8-2����4:18:37
 * @version ����ʱ�䣺2018-8-2 ����4:18:37
 * ��˵��
 */
/**        
 * �����ƣ�Grade   
 * ��������   
 * �����ˣ�syd   
 * ����ʱ�䣺2018-8-2 ����4:18:37      
 * @version    
 *    
 */
public class Grade {
	/**
	 * �꼶id
	 */
	private String id;
	/**
	 * �꼶����
	 */
	private String name;
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

}
