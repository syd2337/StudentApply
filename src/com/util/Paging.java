package com.util;

import java.util.ArrayList;
import java.util.List;

import com.pojo.Student;

/**
 * @author syd2018-8-21����8:17:25
 * @version ����ʱ�䣺2018-8-21 ����8:17:25
 * ��˵��
 */
/**        
 * �����ƣ�Paging   
 * ��������   
 * �����ˣ�syd   
 * ����ʱ�䣺2018-8-21 ����8:17:25      
 * @version    
 *    
 */
public class Paging {
	public static Tabs studentTabs(List<Student> allStudent,String strPageNo){
		Tabs tabs = new Tabs();
		List<Student> studentList = new ArrayList<Student>();
		int totalPage=1;//��ҳ��
		int count=0;//��������
		int pageSize=10;//ÿҳ����
		int pageNo=1;
		int fromIndex=0;
		int toIndex=0;
		if(null!=allStudent && allStudent.size()>0){
			 count = allStudent.size();
			//��ÿҳ����Ϊ15��
			 if(count>pageSize){
				 if(count/pageSize==0){//��������15
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
