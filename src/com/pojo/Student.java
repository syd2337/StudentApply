package com.pojo;

import java.util.Date;

/**
 * @author syd2018-8-2����4:04:24
 * @version ����ʱ�䣺2018-8-2 ����4:04:24
 * ��˵��
 */
/**        
 * �����ƣ�Student   
 * ��������   
 * �����ˣ�syd   
 * ����ʱ�䣺2018-8-2 ����4:04:24      
 * @version    
 *    
 */
public class Student {
	/**
	 * ѧ��id
	 */
	private String id;
	/**
	 * ѧ��ѧ����
	 */
	private String studentCode;
	/**
	 * ѧ������
	 */
	private String name;
	/**
	 * ѧ���Ա�
	 */
	private String sex;
	/**
	 * ѧ���ҳ�����
	 */
	private String parentName;
	/**
	 * ѧ���绰1
	 */
	private String phoneNumOne;
	/**
	 * ѧ���绰2
	 */
	private String phoneNumTwo;
	/**
	 * ѧ����ע
	 */
	private String remark;
	/**
	 * ѧ��ѧУ����
	 */
	private String schoolName;
	/**
	 * ѧ��ѧУУ��
	 */
	private String campusName;
	/**
	 * ѧ���꼶
	 */
	private String gradeName;
	/**
	 * ѧ��������Ϣ
	 */
	private String payCondition;
	/**
	 * ����ʱ��
	 */
	private Date createDate;
	/**
	 * ������
	 */
	private int applyNum;
	/**
	 * С�������id
	 */
	private String openId;
	/**
	 * form��id
	 */
	private String formId;
	/**
	 * ѧ���ܼ�
	 */
	private int prices;
	/**
	 * ״̬1Ϊδ�ɷѣ�0Ϊɾ����2Ϊ�˷ѡ�3Ϊ�ѽɷ�
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
