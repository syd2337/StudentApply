package com.util;

import java.util.ArrayList;
import java.util.List;

import com.pojo.Student;

/**
 * @author syd2018-8-21下午8:17:25
 * @version 创建时间：2018-8-21 下午8:17:25
 * 类说明
 */
/**        
 * 类名称：Paging   
 * 类描述：   
 * 创建人：syd   
 * 创建时间：2018-8-21 下午8:17:25      
 * @version    
 *    
 */
public class Paging {
	public static Tabs studentTabs(List<Student> allStudent,String strPageNo){
		Tabs tabs = new Tabs();
		List<Student> studentList = new ArrayList<Student>();
		int totalPage=1;//总页数
		int count=0;//总数据数
		int pageSize=10;//每页个数
		int pageNo=1;
		int fromIndex=0;
		int toIndex=0;
		if(null!=allStudent && allStudent.size()>0){
			 count = allStudent.size();
			//设每页数据为15条
			 if(count>pageSize){
				 if(count/pageSize==0){//可以整除15
						totalPage=count/pageSize;
					}else{
						totalPage=count/pageSize+1;
					} 
			 }		
			if(strPageNo!=""&&strPageNo!=null){
				pageNo = Integer.parseInt(strPageNo);
			}
			 fromIndex = (pageNo-1) * pageSize;
			 toIndex = pageNo * pageSize;
			if(toIndex > count) {
				toIndex = count;
			}
			studentList=allStudent.subList(fromIndex, toIndex);
		}
		tabs.setStudentList(studentList);
		tabs.setTotalPage(totalPage);
		tabs.setPageNo(pageNo);
		return tabs;
	}
}
