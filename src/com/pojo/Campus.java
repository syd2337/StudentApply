package com.pojo;

import java.util.Date;

/**
 * @author syd2018-8-2下午4:24:47
 * @version 创建时间：2018-8-2 下午4:24:47
 * 类说明
 */
/**        
 * 类名称：Campus   
 * 类描述：   校区
 * 创建人：syd   
 * 创建时间：2018-8-2 下午4:24:47      
 * @version    
 *    
 */
public class Campus {
	/**
	 * 校区id
	 */
	private String id;
	/**
	 * 校区名字
	 */
	private String campusName;
	/**
	 * 校区备注
	 */
	private String remark;
	/**
	 * 创建时间
	 */
	private Date createDate;
	/**
	 * 校区编码
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
