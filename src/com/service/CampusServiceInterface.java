package com.service;

import java.util.List;

import com.pojo.Campus;

/**
 * @author syd2018-8-8����6:45:25
 * @version ����ʱ�䣺2018-8-8 ����6:45:25
 * ��˵��
 */
/**        
 * �����ƣ�CampusServiceInterface   
 * ��������   
 * �����ˣ�syd   
 * ����ʱ�䣺2018-8-8 ����6:45:25      
 * @version    
 *    
 */
public interface CampusServiceInterface {
	/**
	 * 
	 * �������������У��   
	 * �����ˣ�syd   
	 * ����ʱ�䣺2018-8-6 ����9:11:07      
	 * @param campus
	 */
	void addCampus(Campus campus);
	/**
	 * 
	 * ������������ѯ����У��   
	 * �����ˣ�syd   
	 * ����ʱ�䣺2018-8-6 ����9:11:25      
	 * @return
	 */
	List<Campus>  selectAllCampus();
	/**
	 * 
	 * �����������޸�У��   
	 * �����ˣ�syd   
	 * ����ʱ�䣺2018-8-6 ����9:11:44      
	 * @param id
	 */
	void updateCampus(Campus campus);
	/**
	 * 
	 * ����������ɾ��У��   
	 * �����ˣ�syd   
	 * ����ʱ�䣺2018-8-6 ����9:11:48      
	 * @param id
	 */
	void deleteCampus(String id); 
	/**
	 * 
	 * ����������  ����id��ѯУ�� 
	 * �����ˣ�syd   
	 * ����ʱ�䣺2018-8-6 ����9:16:40      
	 * @param id
	 * @return
	 */
	Campus selectCampusById(String id);
	/**
	 * 
	 * ����������  ��������ģ����ѯ 
	 * �����ˣ�syd   
	 * ����ʱ�䣺2018-8-7 ����9:13:27      
	 * @param campusName
	 * @return
	 */
	List<Campus>selectCampusLikeName(String campusName);
	/**
	 * 
	 * ����������   �������ֲ�ѯ 
	 * �����ˣ�syd   
	 * ����ʱ�䣺2018-8-8 ����9:03:53      
	 * @param campusName
	 * @return
	 */
	Campus selectCampusByName(String campusName);
	/**
	 * 
	 * ����������   
	 * �����ˣ�syd   
	 * ����ʱ�䣺2018-8-27 ����5:51:01      
	 * @return
	 */
	int selectAllCampusNum();
}
