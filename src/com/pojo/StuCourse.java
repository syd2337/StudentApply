package com.pojo;

import java.util.Date;

/**
 * @author syd2018-8-2下午4:27:44
 * @version 创建时间：2018-8-2 下午4:27:44
 * 类说明
 */
/**        
 * 类名称：StuCourse   
 * 类描述：   
 * 创建人：syd   
 * 创建时间：2018-8-2 下午4:27:44      
 * @version    
 *    
 */
public class StuCourse {
	/**
	 * 学生课程id
	 */
	private String id;
	/**
	 * 学生课程学生
	 */
	private String studentId;
	/**
	 * 学生课程
	 */
	private String courseId;
	/**
	 * 学生课程创建时间
	 */
	private Date createTime;
	/**
	 * 删除状态
	 */
	private int state;
	/**
	 * 上课次数
	 */
	private int times;
	/**
	 * 总价
	 */
	private int prices;
	/**
	 * 缴费状态
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
