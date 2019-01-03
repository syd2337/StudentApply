package com.pojo;

import java.util.Date;

/**
 * @author syd2018-8-2下午4:20:53
 * @version 创建时间：2018-8-2 下午4:20:53
 * 类说明
 */
/**        
 * 类名称：Course   
 * 类描述：   课程
 * 创建人：syd   
 * 创建时间：2018-8-2 下午4:20:53      
 * @version    
 *    
 */
public class Course {
	/**
	 * 课程id
	 */
	private String id;
	/**
	 * 课程年级
	 */
	private String gradeName;
	/**
	 * 课程科目
	 */
	private String subjectName;
	/**
	 * 课程开始时间
	 */
	private Date startTime;
	/**
	 * 课程结束时间
	 */
	private Date endTime;
	/**
	 * 课程时长
	 */
	private String period;
	/**
	 * 课程资费
	 */
	private int rates;
	/**
	 * 课程次数
	 */
	private int times;
	/**
	 * 课时
	 */
	private int theClass;
	/**
	 * 校区名称
	 */
	private String campusName;
	public String getCampusName() {
		return campusName;
	}
	public void setCampusName(String campusName) {
		this.campusName = campusName;
	}
	public int getTheClass() {
		return theClass;
	}
	public void setTheClass(int theClass) {
		this.theClass = theClass;
	}
	public int getTimes() {
		return times;
	}
	public void setTimes(int times) {
		this.times = times;
	}
	public int getRates() {
		return rates;
	}
	public void setRates(int rates) {
		this.rates = rates;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGradeName() {
		return gradeName;
	}
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}

}
