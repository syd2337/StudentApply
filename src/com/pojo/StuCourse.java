package com.pojo;

import java.util.Date;

/**
 * @author syd2018-8-2����4:27:44
 * @version ����ʱ�䣺2018-8-2 ����4:27:44
 * ��˵��
 */
/**        
 * �����ƣ�StuCourse   
 * ��������   
 * �����ˣ�syd   
 * ����ʱ�䣺2018-8-2 ����4:27:44      
 * @version    
 *    
 */
public class StuCourse {
	/**
	 * ѧ���γ�id
	 */
	private String id;
	/**
	 * ѧ���γ�ѧ��
	 */
	private String studentId;
	/**
	 * ѧ���γ�
	 */
	private String courseId;
	/**
	 * ѧ���γ̴���ʱ��
	 */
	private Date createTime;
	/**
	 * ɾ��״̬
	 */
	private int state;
	/**
	 * �Ͽδ���
	 */
	private int times;
	/**
	 * �ܼ�
	 */
	private int prices;
	/**
	 * �ɷ�״̬
	 */
	private String payState;
	public String getPayState() {
		return payState;
	}
	public void setPayState(String payState) {
		this.payState = payState;
	}
	public int getTimes() {
		return times;
	}
	public void setTimes(int times) {
		this.times = times;
	}
	public int getPrices() {
		return prices;
	}
	public void setPrices(int prices) {
		this.prices = prices;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
