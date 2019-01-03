package com.pojo;

import java.util.Date;

/**
 * @author syd2018-8-2下午4:15:29
 * @version 创建时间：2018-8-2 下午4:15:29
 * 类说明
 */
/**        
 * 类名称：School   
 * 类描述：   
 * 创建人：syd   
 * 创建时间：2018-8-2 下午4:15:29      
 * @version    
 *    
 */
public class School {
	/**
	 * 学校id
	 */
	private String id;
	/**
	 * 学校名字
	 */
	private String name;
	/**
	 * 学校备注
	 */
	private String remark;
	/**
	 * 创建时间
	 */
	private Date createDate;
	/**
	 * 年级编码
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
