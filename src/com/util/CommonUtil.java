package com.util;
import java.io.BufferedReader;  
import java.io.InputStream;  
import java.io.InputStreamReader;  
import java.io.OutputStream;  
import java.io.UnsupportedEncodingException;  
import java.net.ConnectException;  
import java.net.HttpURLConnection;  
import java.net.URL;  
  
import javax.net.ssl.HttpsURLConnection;  
import javax.net.ssl.SSLContext;  
import javax.net.ssl.SSLSocketFactory;  
import javax.net.ssl.TrustManager;  
  
import net.sf.json.JSONObject;  
/**
 * @author syd2018-9-18����9:59:56
 * @version ����ʱ�䣺2018-9-18 ����9:59:56
 * ��˵��
 */
/**        
 * �����ƣ�CommonUtil   
 * ��������   
 * �����ˣ�syd   
 * ����ʱ�䣺2018-9-18 ����9:59:56      
 * @version    
 *    
 */
public class CommonUtil {
	 public static JSONObject httpsRequest(String requestUrl, String requestMethod, String outputStr) {   
         
	        JSONObject jsonObject = null;  
	        StringBuffer buffer = new StringBuffer();    
	        try {    
	            // ����SSLContext���󣬲�ʹ������ָ�������ι�������ʼ��    
	            TrustManager[] tm = { new MyX509TrustManager() };    
	            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");    
	            sslContext.init(null, tm, new java.security.SecureRandom());    
	            // ������SSLContext�����еõ�SSLSocketFactory����    
	            SSLSocketFactory ssf = sslContext.getSocketFactory();    
	    
	            URL url = new URL(requestUrl);    
	            HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();    
	            httpUrlConn.setSSLSocketFactory(ssf);    
	    
	            httpUrlConn.setDoOutput(true);    
	            httpUrlConn.setDoInput(true);    
	            httpUrlConn.setUseCaches(false);    
	            // ��������ʽ��GET/POST��    
	            httpUrlConn.setRequestMethod(requestMethod);    
	    
	            if ("GET".equalsIgnoreCase(requestMethod)) {  
	                 httpUrlConn.connect();    
	            }   
	                 
	    
	            // ����������Ҫ�ύʱ    
	            if (null != outputStr) {    
	                OutputStream outputStream = httpUrlConn.getOutputStream();    
	                // ע������ʽ����ֹ��������    
	                outputStream.write(outputStr.getBytes("UTF-8"));    
	                outputStream.close();    
	            }    
	    
	            // �����ص�������ת�����ַ���    
	            InputStream inputStream = httpUrlConn.getInputStream();    
	            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");    
	            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);    
	    
	            String str = null;    
	            while ((str = bufferedReader.readLine()) != null) {    
	                buffer.append(str);    
	            }    
	            bufferedReader.close();    
	            inputStreamReader.close();    
	            // �ͷ���Դ    
	            inputStream.close();    
	            inputStream = null;    
	            httpUrlConn.disconnect();    
	            jsonObject = JSONObject.fromObject(buffer.toString());    
	        } catch (ConnectException ce) {    
	            ce.printStackTrace();  
	        } catch (Exception e) {    
	            e.printStackTrace();  
	        }    
	        return jsonObject;    
	    }  
	      
	    public static String httpRequest(String requestUrl, String requestMethod, String outputStr) {   
	          
	          
	        StringBuffer buffer = new StringBuffer();    
	        try {    
	            
	    
	            URL url = new URL(requestUrl);    
	            HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();    
	             
	    
	            httpUrlConn.setDoOutput(true);    
	            httpUrlConn.setDoInput(true);    
	            httpUrlConn.setUseCaches(false);    
	            // ��������ʽ��GET/POST��    
	            httpUrlConn.setRequestMethod(requestMethod);    
	    
	            if ("GET".equalsIgnoreCase(requestMethod)) {  
	                 httpUrlConn.connect();    
	            }   
	                 
	    
	            // ����������Ҫ�ύʱ    
	            if (null != outputStr) {    
	                OutputStream outputStream = httpUrlConn.getOutputStream();    
	                // ע������ʽ����ֹ��������    
	                outputStream.write(outputStr.getBytes("UTF-8"));    
	                outputStream.close();    
	            }    
	    
	            // �����ص�������ת�����ַ���    
	            InputStream inputStream = httpUrlConn.getInputStream();    
	            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");    
	            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);    
	    
	            String str = null;    
	            while ((str = bufferedReader.readLine()) != null) {    
	                buffer.append(str);    
	            }    
	            bufferedReader.close();    
	            inputStreamReader.close();    
	            // �ͷ���Դ    
	            inputStream.close();    
	            inputStream = null;    
	            httpUrlConn.disconnect();    
	            //jsonObject = JSONObject.fromObject(buffer.toString());    
	        } catch (ConnectException ce) {    
	            ce.printStackTrace();  
	        } catch (Exception e) {    
	            e.printStackTrace();  
	        }    
	        return buffer.toString();    
	    }  
	    public static String urlEncodeUTF8(String source){  
	        String result = source;  
	        try {  
	            result = java.net.URLEncoder.encode(source,"utf-8");  
	        } catch (UnsupportedEncodingException e) {  
	            e.printStackTrace();  
	        }  
	        return result;  
	    }  
	      
	    public static String httpsRequestForStr(String requestUrl, String requestMethod, String outputStr) {   
	          
	        String result="";  
	        StringBuffer buffer = new StringBuffer();    
	        try {    
	            // ����SSLContext���󣬲�ʹ������ָ�������ι�������ʼ��    
	            TrustManager[] tm = { new MyX509TrustManager() };    
	            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");    
	            sslContext.init(null, tm, new java.security.SecureRandom());    
	            // ������SSLContext�����еõ�SSLSocketFactory����    
	            SSLSocketFactory ssf = sslContext.getSocketFactory();    
	    
	            URL url = new URL(requestUrl);    
	            HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();    
	            httpUrlConn.setSSLSocketFactory(ssf);    
	    
	            httpUrlConn.setDoOutput(true);    
	            httpUrlConn.setDoInput(true);    
	            httpUrlConn.setUseCaches(false);    
	            // ��������ʽ��GET/POST��    
	            httpUrlConn.setRequestMethod(requestMethod);    
	    
	            if ("GET".equalsIgnoreCase(requestMethod)) {  
	                 httpUrlConn.connect();    
	            }   
	                 
	    
	            // ����������Ҫ�ύʱ    
	            if (null != outputStr) {    
	                OutputStream outputStream = httpUrlConn.getOutputStream();    
	                // ע������ʽ����ֹ��������    
	                outputStream.write(outputStr.getBytes("UTF-8"));    
	                outputStream.close();    
	            }    
	    
	            // �����ص�������ת�����ַ���    
	            InputStream inputStream = httpUrlConn.getInputStream();    
	            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");    
	            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);    
	    
	            String str = null;    
	            while ((str = bufferedReader.readLine()) != null) {    
	                buffer.append(str);    
	            }    
	            bufferedReader.close();    
	            inputStreamReader.close();    
	            // �ͷ���Դ    
	            inputStream.close();    
	            inputStream = null;    
	            httpUrlConn.disconnect();    
	            result=buffer.toString();    
	        } catch (ConnectException ce) {    
	            ce.printStackTrace();  
	        } catch (Exception e) {    
	            e.printStackTrace();  
	        }    
	        return result;    
	    }  
}
