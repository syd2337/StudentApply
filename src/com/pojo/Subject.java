package com.pojo;

import java.util.Date;

/**
 * @author syd2018-8-2����4:00:54
 * @version ����ʱ�䣺2018-8-2 ����4:00:54
 * ��˵��
 */
/**        
 * �����ƣ�Subject   
 * ��������   
 * �����ˣ�syd   
 * ����ʱ�䣺2018-8-2 ����4:00:54      
 * @version    
 *    
 */
public class Subject {
	/**
	 * ��Ŀid
	 */
	private String id;
	/**
	 * ��Ŀ����
	 */
	private String name;
	private Date createDate;
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
