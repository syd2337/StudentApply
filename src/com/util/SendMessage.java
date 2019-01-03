package com.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pojo.Student;
import com.service.StudentServiceInterface;

import net.sf.json.JSONObject;

/**
 * @author syd2018-9-19����4:10:12
 * @version ����ʱ�䣺2018-9-19 ����4:10:12
 * ��˵��
 */
/**        
 * �����ƣ�SendMessage   
 * ��������   
 * �����ˣ�syd   
 * ����ʱ�䣺2018-9-19 ����4:10:12      
 * @version    
 *    
 */
@Component
public class SendMessage {
	@Autowired
	private StudentServiceInterface studentServiceInterface;
	
	public void sendMessage(String code,String formId,Student student,List<ShowStuCourse> stuCourseList)throws IOException{
		 String requestUrlOpenId="https://api.weixin.qq.com/sns/jscode2session?appid="+Configure.getAppID()+"&secret="+Configure.getSecret()+"&js_code="+code+"&grant_type=authorization_code";  
	        JSONObject jsonResultOpenId=CommonUtil.httpsRequest(requestUrlOpenId, "POST", null);
	        System.out.println(code+"++++++++"+formId+jsonResultOpenId);
	       
	        String openId ="";
	        if(jsonResultOpenId!=null){  
	           openId=jsonResultOpenId.getString("openid");
	           System.out.println(openId);
	        }
	        Template tem=new Template();  
			//tem.setTemplateId("39HSRwzyjfrnffp6gFzzCZVOUrLwvD0lo7qwbFmIHE4");  
			tem.setFormId(formId);
			tem.setTopColor("#00DD00");  
			tem.setToUser(openId);  
			tem.setUrl("");
			List<TemplateParam> paras=new ArrayList<TemplateParam>();
			if(student.getPayCondition().equals("�ѽɷ�")){
				tem.setTemplateId("39HSRwzyjfrnffp6gFzzCZVOUrLwvD0lo7qwbFmIHE4");
				paras=getApply(stuCourseList);
				tem.setTemplateParamList(paras);
			}else{
				tem.setTemplateId("DXZ11dSRUO42e0hwQ1hHg4ge7MFqZU4VjXLa_ycSXZE");
				paras=getSing(student);
				tem.setTemplateParamList(paras);
			}
	        String requestUrlToken="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+Configure.getAppID()+"&secret="+Configure.getSecret();  
	        JSONObject jsonResultToken=CommonUtil.httpsRequest(requestUrlToken, "POST", tem.toJSON());
	        String access_token="";
	        if(jsonResultToken!=null){  
	             access_token=jsonResultToken.getString("access_token");         
	        }
	        boolean flag=false;   
	        String requestUrl="https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token=ACCESS_TOKEN";  
	        requestUrl=requestUrl.replace("ACCESS_TOKEN", access_token);  
	        String jsonString = tem.toJSON();
	        JSONObject jsonResult=CommonUtil.httpsRequest(requestUrl, "POST", jsonString);  
	        if(jsonResult!=null){  
	            int errorCode=jsonResult.getInt("errcode");  
	            String errorMessage=jsonResult.getString("errmsg");  
	            if(errorCode==0){  
	                flag=true;  
	            }else{  
	                System.out.println("ģ����Ϣ����ʧ��:"+errorCode+","+errorMessage);  
	                flag=false;  
	            }  
	        }
	          
	}
	public void applySendMessage(Student student,List<ShowStuCourse> stuCourseList)throws IOException{		
	        String openId =student.getOpenId();
	        String formId=student.getFormId();
	        Template tem=new Template();  
			//tem.setTemplateId("39HSRwzyjfrnffp6gFzzCZVOUrLwvD0lo7qwbFmIHE4");  
			tem.setFormId(formId);
			tem.setTopColor("#00DD00");  
			tem.setToUser(openId);  
			tem.setUrl("");
			List<TemplateParam> paras=new ArrayList<TemplateParam>();
			if(student.getPayCondition().equals("�ѽɷ�")){
				tem.setTemplateId("hyi2Tp5f0H0pjLXW8zJzS3KZvtWffseqENdHW6_odUo");
				paras=getApply(stuCourseList);
				tem.setTemplateParamList(paras);
			}else{
				tem.setTemplateId("DXZ11dSRUO42e0hwQ1hHg4ge7MFqZU4VjXLa_ycSXZE");
				paras=getSing(student);
				tem.setTemplateParamList(paras);
			}
	        String requestUrlToken="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+Configure.getAppID()+"&secret="+Configure.getSecret();  
	        JSONObject jsonResultToken=CommonUtil.httpsRequest(requestUrlToken, "POST", tem.toJSON());
	        String access_token="";
	        if(jsonResultToken!=null){  
	             access_token=jsonResultToken.getString("access_token");         
	        }
	        boolean flag=false;   
	        String requestUrl="https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token=ACCESS_TOKEN";  
	        requestUrl=requestUrl.replace("ACCESS_TOKEN", access_token);  
	        String jsonString = tem.toJSON();
	        JSONObject jsonResult=CommonUtil.httpsRequest(requestUrl, "POST", jsonString);  
	        if(jsonResult!=null){  
	            int errorCode=jsonResult.getInt("errcode");  
	            String errorMessage=jsonResult.getString("errmsg");  
	            if(errorCode==0){  
	                flag=true;  
	            }else{  
	                System.out.println("ģ����Ϣ����ʧ��:"+errorCode+","+errorMessage);  
	                flag=false;  
	            }  
	        }
	          
	}
	/**
	 * 
	 * ��������������������Ϣ   
	 * �����ˣ�syd   
	 * ����ʱ�䣺2018-9-19 ����4:23:41      
	 * @return
	 * 
	 * DXZ11dSRUO42e0hwQ1hHg4ge7MFqZU4VjXLa_ycSXZE
	 */
	public static List<TemplateParam> getSing(Student student){
		List<TemplateParam> paras=new ArrayList<TemplateParam>();
		Date nowTime = new Date();
		String applyTime = StringToDate.dateToString(nowTime);
		paras.add(new TemplateParam("keyword1",applyTime,"#0044BB"));  
		paras.add(new TemplateParam("keyword2",student.getName(),"#0044BB"));  
		paras.add(new TemplateParam("keyword3",student.getPhoneNumOne(),"#AAAAAA"));  
		paras.add(new TemplateParam("keyword4","����ѧ����ѵ�γ�","#0044BB"));  
		paras.add(new TemplateParam("keyword5","���ѳɹ�����","#AAAAAA")); 
		return paras;
		
	}
	/**
	 * 
	 * ������������������   
	 * �����ˣ�syd   
	 * ����ʱ�䣺2018-9-19 ����4:24:20      
	 * @return
	 * hyi2Tp5f0H0pjLXW8zJzS3KZvtWffseqENdHW6_odUo
	 * hyi2Tp5f0H0pjLXW8zJzS3KZvtWffseqENdHW6_odUo
	 */
	public static List<TemplateParam> getApply(List<ShowStuCourse> stuCourseList){
		List<TemplateParam> paras=new ArrayList<TemplateParam>();
		String strDate = StringToDate.dateToString(stuCourseList.get(0).getCourse().getStartTime())+"-"+StringToDate.dateToString(stuCourseList.get(0).getCourse().getEndTime());
		paras.add(new TemplateParam("keyword1",stuCourseList.get(0).getCourse().getSubjectName(),"#0044BB")); //�γ����� 
		paras.add(new TemplateParam("keyword2",strDate,"#0044BB"));  //����ʱ��
		paras.add(new TemplateParam("keyword3",stuCourseList.get(0).getCourse().getPeriod(),"#AAAAAA")); // �̿�ʱ��
		paras.add(new TemplateParam("keyword4","��׼ʱ�Ͽ�Ŷ","#0044BB"));  //��ע
		//paras.add(new TemplateParam("keyword5","131123456789","#AAAAAA")); 
		return paras;
		
	}
}
