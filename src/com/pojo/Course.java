package com.pojo;

import java.util.Date;

/**
 * @author syd2018-8-2����4:20:53
 * @version ����ʱ�䣺2018-8-2 ����4:20:53
 * ��˵��
 */
/**        
 * �����ƣ�Course   
 * ��������   �γ�
 * �����ˣ�syd   
 * ����ʱ�䣺2018-8-2 ����4:20:53      
 * @version    
 *    
 */
public class Course {
	/**
	 * �γ�id
	 */
	private String id;
	/**
	 * �γ��꼶
	 */
	private String gradeName;
	/**
	 * �γ̿�Ŀ
	 */
	private String subjectName;
	/**
	 * �γ̿�ʼʱ��
	 */
	private Date startTime;
	/**
	 * �γ̽���ʱ��
	 */
	private Date endTime;
	/**
	 * �γ�ʱ��
	 */
	private String period;
	/**
	 * �γ��ʷ�
	 */
	private int rates;
	/**
	 * �γ̴���
	 */
	private int times;
	/**
	 * ��ʱ
	 */
	private int theClass;
	/**
	 * У������
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
