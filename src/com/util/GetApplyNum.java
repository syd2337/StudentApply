package com.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author syd2018-9-7����11:32:33
 * @version ����ʱ�䣺2018-9-7 ����11:32:33
 * ��˵��
 */
/**        
 * �����ƣ�GetApplyNum   
 * ��������   
 * �����ˣ�syd   
 * ����ʱ�䣺2018-9-7 ����11:32:33      
 * @version    
 *    
 */
public class GetApplyNum {
	public static int getApplyNum(int theMaxApplyNum,int allStudentNum){
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
	     Date date = new Date();
	     //int year = Integer.parseInt(sdf.format(date));
	     int applyNum=0;
	     if(allStudentNum==0){
	    	 applyNum=Integer.parseInt(sdf.format(date)+"0001");
	     }else{
	    	 applyNum=theMaxApplyNum+1;
	     }
	     //System.out.println(applyNum+"+++++++++++");
		return applyNum;
		
	}

}
