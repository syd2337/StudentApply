package com.util;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author syd2018-8-14下午4:16:14
 * @version 创建时间：2018-8-14 下午4:16:14
 * 类说明
 */
/**        
 * 类名称：StringToDate   
 * 类描述：   
 * 创建人：syd   
 * 创建时间：2018-8-14 下午4:16:14      
 * @version    
 *    
 */
public class StringToDate {
	public Date stringToDate(String strDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if(strDate!="" & strDate!=null){
        return sdf.parse(strDate);
        }
        return null;
    }
	public static String dateToString(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		String strDate = sdf.format(date);
		return strDate;
		
	}
	public static boolean compareDate(Date createDate) throws ParseException{
		boolean flag = false;
		//long day = 0;
		//long hour = 0;
		long min = 0;
	    //long sec = 0; 
		String dateInfo = "2017-07-05 07:40:46";
		SimpleDateFormat date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date createTime = date1.parse(dateInfo);
		Date nowTime = new Date();
		long nowTimeOne = nowTime.getTime();
		long createTimeOne = createDate.getTime();
		BigDecimal bigOne = new BigDecimal(nowTimeOne);
		BigDecimal bigTwo = new BigDecimal(createTimeOne);
		long nmint =0;
		BigDecimal bigThree = new BigDecimal(nmint);
		bigThree = bigOne.subtract(bigTwo);
		long diff = bigThree.longValue();
		//day = diff / (24 * 60 * 60 * 1000);  
		//hour = (diff / (60 * 60 * 1000) - day * 24);  
		//min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);  
		min = diff / (60 * 1000);
		if(min >30){
			flag = true;
			}else{
				flag = false;
				}
		return flag;
		
	}
	public static String getCode(){
		Calendar cale = null;  
        cale = Calendar.getInstance();  
        int year = cale.get(Calendar.YEAR);  
        int month = cale.get(Calendar.MONTH) + 1;
        int day=cale.get(Calendar.DATE);//获取日
        int hour=cale.get(Calendar.HOUR);//小时
        int minute=cale.get(Calendar.MINUTE);//分           
        int second=cale.get(Calendar.SECOND);//秒
        System.out.println(month);
        if(month>=3&&month<=5){
        	return "A";
        }
        if(month>=6&&month<=8){
        	return "B";
        }
        if(month>=9&&month<=11){
        	return "C";
        }
        if(month>=12){
        	return "D";
        }
		return "D";
		
	}
	/**
	 * 
	 * 方法描述： 确定是上的那一节课  
	 * 创建人：syd   
	 * 创建时间：2018-11-13 上午11:29:29      
	 * @param period
	 * @return
	 */
	public static boolean compare(String period){
		boolean flag=false;
		Calendar cale = null;  
        cale = Calendar.getInstance();  
        int hour=cale.get(Calendar.HOUR);//小时
        
        int endHour =Integer.parseInt(period.substring(period.indexOf("-")+1, period.indexOf(":", period.indexOf(":")+1)));
        int startHour=Integer.parseInt(period.substring(0, period.indexOf(":")));
        if(hour>startHour-1&&hour<startHour+1){
        	flag=true;
        	
        }
		return flag;
		
	}
	public static int thePeriod(String period){
		
		Calendar cale = null;  
        cale = Calendar.getInstance();  
        int hour=cale.get(Calendar.HOUR);//小时
        
        int endHour =Integer.parseInt(period.substring(period.indexOf("-")+1, period.indexOf(":", period.indexOf(":")+1)));
        int startHour=Integer.parseInt(period.substring(0, period.indexOf(":")));       
		return endHour-startHour;
		
	}
}
