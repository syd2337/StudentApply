package com.service;

import java.util.List;

import com.pojo.School;

public interface SchoolServiceInterface {
	/**
	 * 
	 * �������������ѧУ   
	 * �����ˣ�syd   
	 * ����ʱ�䣺2018-8-6 ����10:17:03      
	 * @param school
	 */
	void addSchool(School school);
	/**
	 * 
	 * ������������ѯ����ѧУ   
	 * �����ˣ�syd   
	 * ����ʱ�䣺2018-8-6 ����10:17:07      
	 * @return
	 */
	List<School> selectAllSchool();
	/**
	 * 
	 * ��������������id��ѯ   
	 * �����ˣ�syd   
	 * ����ʱ�䣺2018-8-6 ����10:17:10      
	 * @param id
	 * @return
	 */
	School selectSchoolById(String id);
	/**
	 * 
	 * �����������޸�ѧУ   
	 * �����ˣ�syd   
	 * ����ʱ�䣺2018-8-6 ����10:17:14      
	 * @param school
	 */
	void updateSchool(School school);
	/**
	 * 
	 * ����������ɾ��ѧУ   
	 * �����ˣ�syd   
	 * ����ʱ�䣺2018-8-6 ����10:17:18      
	 * @param id
	 */
	void deleteSchool(String id);
	/**
	 * 
	 * ��������������ѧУ���ֲ�ѯѧУ   
	 * �����ˣ�syd   
	 * ����ʱ�䣺2018-8-8 ����9:01:33      
	 * @param name
	 * @return
	 */
	School selectSchoolByName(String name);
	/**
	 * 
	 * ��������������ѧУ����ģ����ѯ   
	 * �����ˣ�syd   
	 * ����ʱ�䣺2018-8-8 ����9:01:37      
	 * @param name
	 * @return
	 */
	List<School> selectSchoolLikeName(String name);
	/**
	 * 
	 * ������������ѯ����ѧУ����   
	 * �����ˣ�syd   
	 * ����ʱ�䣺2018-8-27 ����5:46:14      
	 * @return
	 */
	 int selectAllSchoolNum();
	 List<String> selectAllSchoolName();
}
