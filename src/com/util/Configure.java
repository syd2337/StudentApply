package com.util;
/**
 * @author syd2018-9-18����10:00:15
 * @version ����ʱ�䣺2018-9-18 ����10:00:15
 * ��˵��
 */
/**        
 * �����ƣ�Configure   
 * ��������   
 * �����ˣ�syd   
 * ����ʱ�䣺2018-9-18 ����10:00:15      
 * @version    
 *    
 */
public class Configure {
	private static String key = "acfc3de40b4a895dbdf8a15c7e850ea3";

	//С����ID	
	private static String appID = "wx3b3717e26f02a074";
	//�̻���
	private static String mch_id = "����̻���";
	//
	private static String secret = "882acd0bd64c9858a573997a27328eb3";

	public static String getSecret() {
		return secret;
	}

	public static void setSecret(String secret) {
		Configure.secret = secret;
	}

	public static String getKey() {
		return key;
	}

	public static void setKey(String key) {
		Configure.key = key;
	}

	public static String getAppID() {
		return appID;
	}

	public static void setAppID(String appID) {
		Configure.appID = appID;
	}

	public static String getMch_id() {
		return mch_id;
	}

	public static void setMch_id(String mch_id) {
		Configure.mch_id = mch_id;
	}

}
