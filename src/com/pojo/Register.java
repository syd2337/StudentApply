package com.pojo;

import java.util.Date;

/**
 * @author syd2018-10-10����9:49:36
 * @version ����ʱ�䣺2018-10-10 ����9:49:36
 * ��˵��
 */
/**        
 * �����ƣ�Register   
 * ��������   �Ͽμ�¼
 * �����ˣ�syd   
 * ����ʱ�䣺2018-10-10 ����9:49:36      
 * @version    
 *    
 */
public class Register {
	private String id;
	private String stuCourseId;
	private Date createDate;
	private String studentId;
	private String courseId;
	private int theTimes;
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
	public int getTheTimes() {
		return theTimes;
	}
	public void setTheTimes(int theTimes) {
		this.theTimes = theTimes;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStuCourseId() {
		return stuCourseId;
	}
	public void setStuCourseId(String stuCourseId) {
		this.stuCourseId = stuCourseId;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
