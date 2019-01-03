package com.pojo;

import java.util.Date;

/**
 * @author syd2018-8-2下午4:04:24
 * @version 创建时间：2018-8-2 下午4:04:24
 * 类说明
 */
/**        
 * 类名称：Student   
 * 类描述：   
 * 创建人：syd   
 * 创建时间：2018-8-2 下午4:04:24      
 * @version    
 *    
 */
public class Student {
	/**
	 * 学生id
	 */
	private String id;
	/**
	 * 学生学籍号
	 */
	private String studentCode;
	/**
	 * 学生姓名
	 */
	private String name;
	/**
	 * 学生性别
	 */
	private String sex;
	/**
	 * 学生家长姓名
	 */
	private String parentName;
	/**
	 * 学生电话1
	 */
	private String phoneNumOne;
	/**
	 * 学生电话2
	 */
	private String phoneNumTwo;
	/**
	 * 学生备注
	 */
	private String remark;
	/**
	 * 学生学校名字
	 */
	private String schoolName;
	/**
	 * 学生学校校区
	 */
	private String campusName;
	/**
	 * 学生年级
	 */
	private String gradeName;
	/**
	 * 学生付费信息
	 */
	private String payCondition;
	/**
	 * 报名时间
	 */
	private Date createDate;
	/**
	 * 报名号
	 */
	private int applyNum;
	/**
	 * 小程序接入id
	 */
	private String openId;
	/**
	 * form表单id
	 */
	private String formId;
	/**
	 * 学费总价
	 */
	private int prices;
	/**
	 * 状态1为未缴费，0为删除，2为退费。3为已缴费
	 */
	private int state;
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getPrices() {
		return prices;
	}
	public void setPrices(int prices) {
		this.prices = prices;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getFormId() {
		return formId;
	}
	public void setFormId(String formId) {
		this.formId = formId;
	}
	
	public int getApplyNum() {
		return applyNum;
	}
	public void setApplyNum(int applyNum) {
		this.applyNum = applyNum;
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
	public String getStudentCode() {
		return studentCode;
	}
	public void setStudentCode(String studentCode) {
		this.studentCode = studentCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public String getPhoneNumOne() {
		return phoneNumOne;
	}
	public void setPhoneNumOne(String phoneNumOne) {
		this.phoneNumOne = phoneNumOne;
	}
	public String getPhoneNumTwo() {
		return phoneNumTwo;
	}
	public void setPhoneNumTwo(String phoneNumTwo) {
		this.phoneNumTwo = phoneNumTwo;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getCampusName() {
		return campusName;
	}
	public void setCampusName(String campusName) {
		this.campusName = campusName;
	}
	public String getGradeName() {
		return gradeName;
	}
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}
	public String getPayCondition() {
		return payCondition;
	}
	public void setPayCondition(String payCondition) {
		this.payCondition = payCondition;
	}

}
