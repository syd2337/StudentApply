package com.util;

import java.util.List;

import com.pojo.Student;

/**
 * @author syd2018-8-23����5:57:55
 * @version ����ʱ�䣺2018-8-23 ����5:57:55
 * ��˵��
 */
/**        
 * �����ƣ�Tabs   
 * ��������   
 * �����ˣ�syd   
 * ����ʱ�䣺2018-8-23 ����5:57:55      
 * @version    
 *    
 */
public class Tabs {
	private int pageNo;
	
	private int totalPage;
	
	private List<Student> studentList;
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<Student> getStudentList() {
		return studentList;
	}
	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

}
