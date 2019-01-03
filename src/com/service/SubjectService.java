package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.SubjectMapper;
import com.pojo.Subject;

@Service
public class SubjectService implements SubjectServiceInterface {
	@Resource
	private SubjectMapper subjectMapper;

	@Override
	public void addSubject(Subject subject) {
		// TODO Auto-generated method stub
		subjectMapper.addSubject(subject);
	}

	@Override
	public List<Subject> selectAllSubject() {
		// TODO Auto-generated method stub
		return subjectMapper.selectAllSubject();
	}

	@Override
	public Subject selectSubjectById(String id) {
		// TODO Auto-generated method stub
		return subjectMapper.selectSubjectById(id);
	}

	@Override
	public List<Subject> selectSubjectLikeName(String name) {
		// TODO Auto-generated method stub
		return subjectMapper.selectSubjectLikeName(name);
	}

	@Override
	public Subject selectSubjectByName(String name) {
		// TODO Auto-generated method stub
		return subjectMapper.selectSubjectByName(name);
	}

	@Override
	public void updateSubject(Subject subject) {
		// TODO Auto-generated method stub
		subjectMapper.updateSubject(subject);
	}

	@Override
	public void deleteSubject(String id) {
		// TODO Auto-generated method stub
		subjectMapper.deleteSubject(id);
	}
}
