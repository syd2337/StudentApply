package com.util;
/**
 * @author syd2018-9-18上午10:01:52
 * @version 创建时间：2018-9-18 上午10:01:52
 * 类说明
 */
/**        
 * 类名称：TemplateParam   
 * 类描述：   
 * 创建人：syd   
 * 创建时间：2018-9-18 上午10:01:52      
 * @version    
 *    
 */
public class TemplateParam {
	 // 参数名称  
    private String name;  
    // 参数值  
    private String value;  
    // 颜色  
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
