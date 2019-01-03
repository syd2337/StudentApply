package com.util;

import java.util.List;

import com.pojo.Student;

/**
 * @author syd2018-8-23下午5:57:55
 * @version 创建时间：2018-8-23 下午5:57:55
 * 类说明
 */
/**        
 * 类名称：Tabs   
 * 类描述：   
 * 创建人：syd   
 * 创建时间：2018-8-23 下午5:57:55      
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
