package com.service;

import java.util.List;

import com.pojo.Subject;

public interface SubjectServiceInterface {
	void addSubject(Subject subject);
	List<Subject> selectAllSubject();
	Subject selectSubjectById(String id);
	List<Subject>selectSubjectLikeName(String name);
	Subject selectSubjectByName(String name);
	void updateSubject(Subject subject);
	void deleteSubject(String id);
}
