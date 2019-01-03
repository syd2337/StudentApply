package com.util;

import com.pojo.Course;
import com.pojo.Student;

public class ShowStuCourse {
	private String id;
	private Student student;
	private Course course;
	private String payState;
	private int times;
	private int prices;
	private int theTimes;
	public int getTheTimes() {
		return theTimes;
	}
	public void setTheTimes(int theTimes) {
		this.theTimes = theTimes;
	}
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}

}
