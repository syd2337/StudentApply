package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.SchoolMapper;
import com.pojo.School;

@Service
public class SchoolService implements SchoolServiceInterface {
	@Resource
	private SchoolMapper schoolMapper;

	@Override
	public void addSchool(School school) {
		// TODO Auto-generated method stub
		schoolMapper.addSchool(school);
	}

	@Override
	public List<School> selectAllSchool() {
		// TODO Auto-generated method stub
		return schoolMapper.selectAllSchool();
	}

	@Override
	public School selectSchoolById(String id) {
		// TODO Auto-generated method stub
		return schoolMapper.selectSchoolById(id);
	}

	@Override
	public void updateSchool(School school) {
		// TODO Auto-generated method stub
		schoolMapper.updateSchool(school);
	}

	@Override
	public void deleteSchool(String id) {
		// TODO Auto-generated method stub
		schoolMapper.deleteSchool(id);
	}

	@Override
	public School selectSchoolByName(String name) {
		// TODO Auto-generated method stub
		return schoolMapper.selectSchoolByName(name);
	}

	@Override
	public List<School> selectSchoolLikeName(String name) {
		// TODO Auto-generated method stub
		return schoolMapper.selectSchoolLikeName(name);
	}

	/* (non-Javadoc)
	 * @see com.service.SchoolServiceInterface#selectAllSchoolNum()
	 */
	@Override
	public int selectAllSchoolNum() {
		// TODO Auto-generated method stub
		return schoolMapper.selectAllSchoolNum();
	}
}
