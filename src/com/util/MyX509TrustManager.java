package com.util;
/**
 * @author syd2018-9-18����10:00:29
 * @version ����ʱ�䣺2018-9-18 ����10:00:29
 * ��˵��
 */
import java.security.cert.CertificateException;  
import java.security.cert.X509Certificate;  
  
import javax.net.ssl.X509TrustManager;  
  
public class MyX509TrustManager implements X509TrustManager {  
  
    public void checkClientTrusted(X509Certificate[] chain, String authType)  
            throws CertificateException {  
    }  
  
    public void checkServerTrusted(X509Certificate[] chain, String authType)  
            throws CertificateException {  
    }  
  
    public X509Certificate[] getAcceptedIssuers() {  
        return null;  
    }  
}
