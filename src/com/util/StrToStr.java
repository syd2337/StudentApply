package com.util;

import java.io.UnsupportedEncodingException;

public  class  StrToStr {
	public static String toStr(String str) throws UnsupportedEncodingException{
		 
		return new String(str.getBytes("iso-8859-1"), "utf-8");
		}
		
	
}
