package com.pojo;

import java.util.Date;

/**
 * @author syd2018-9-4����11:28:47
 * @version ����ʱ�䣺2018-9-4 ����11:28:47
 * ��˵��
 */
/**        
 * �����ƣ�AboutUs   
 * ��������   
 * �����ˣ�syd   
 * ����ʱ�䣺2018-9-4 ����11:28:47      
 * @version    
 *    
 */
public class AboutUs {
	private String id;
	private String title;
	private String content;
	private Date createDate;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
