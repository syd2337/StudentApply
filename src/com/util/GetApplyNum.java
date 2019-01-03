package com.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author syd2018-9-7上午11:32:33
 * @version 创建时间：2018-9-7 上午11:32:33
 * 类说明
 */
/**        
 * 类名称：GetApplyNum   
 * 类描述：   
 * 创建人：syd   
 * 创建时间：2018-9-7 上午11:32:33      
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
