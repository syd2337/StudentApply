package com.util;
/**
 * @author syd2018-9-18����10:01:52
 * @version ����ʱ�䣺2018-9-18 ����10:01:52
 * ��˵��
 */
/**        
 * �����ƣ�TemplateParam   
 * ��������   
 * �����ˣ�syd   
 * ����ʱ�䣺2018-9-18 ����10:01:52      
 * @version    
 *    
 */
public class TemplateParam {
	 // ��������  
    private String name;  
    // ����ֵ  
    private String value;  
    // ��ɫ  
    private String color;  
      
    public TemplateParam(String name,String value,String color){  
        this.name=name;  
        this.value=value;  
        this.color=color;  
    }  
    public String getName() {  
        return name;  
    }  
  
    public void setName(String name) {  
        this.name = name;  
    }  
  
    public String getValue() {  
        return value;  
    }  
  
    public void setValue(String value) {  
        this.value = value;  
    }  
  
    public String getColor() {  
        return color;  
    }  
  
    public void setColor(String color) {  
        this.color = color;  
    }  
}
