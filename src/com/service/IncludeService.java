package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.IncludeMapper;
import com.pojo.Include;
@Service
public class IncludeService implements IncludeServiceInterface {
	@Resource
	private IncludeMapper includeMapper;
	@Override
	public void addInclude(Include include) {
		// TODO Auto-generated method stub
		includeMapper.addInclude(include);
	}

	@Override
	public Include selectIncludeById(String id) {
		// TODO Auto-generated method stub
		return includeMapper.selectIncludeById(id);
	}

	@Override
	public List<Include> selectIncludeByTitleType(String titleType) {
		// TODO Auto-generated method stub
		return includeMapper.selectIncludeByTitleType(titleType);
	}

	@Override
	public void updateInclude(Include include) {
		// TODO Auto-generated method stub
		includeMapper.updateInclude(include);
	}

	@Override
	public void deleteInclude(String id) {
		// TODO Auto-generated method stub
		includeMapper.deleteInclude(id);
	}

	@Override
	public List<Include> selectAllInclude() {
		// TODO Auto-generated method stub
		return includeMapper.selectAllInclude();
	}

}
