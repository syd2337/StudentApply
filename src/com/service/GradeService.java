package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.GradeMapper;
import com.pojo.Grade;

@Service
public class GradeService implements GradeServiceInterface{
	@Resource
	private GradeMapper gradeMapper;

	@Override
	public void addGrade(Grade grade) {
		// TODO Auto-generated method stub
		gradeMapper.addGrade(grade);
	}

	@Override
	public List<Grade> selectAllGrade() {
		// TODO Auto-generated method stub
		return gradeMapper.selectAllGrade();
	}

	@Override
	public Grade selectGradeById(String id) {
		// TODO Auto-generated method stub
		return gradeMapper.selectGradeById(id);
	}

	@Override
	public void updateGrade(Grade grade) {
		// TODO Auto-generated method stub
		gradeMapper.updateGrade(grade);
	}

	@Override
	public void deleteGrade(String id) {
		// TODO Auto-generated method stub
		gradeMapper.deleteGrade(id);
	}

	@Override
	public List<Grade> selectGradeLikeName(String name) {
		// TODO Auto-generated method stub
		return gradeMapper.selectGradeLikeName(name);
	}

	/* (non-Javadoc)
	 * @see com.service.GradeServiceInterface#selectGradeByName(java.lang.String)
	 */
	@Override
	public Grade selectGradeByName(String name) {
		// TODO Auto-generated method stub
		return gradeMapper.selectGradeByName(name);
	}

}
