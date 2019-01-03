package com.service;

import java.util.List;

import com.pojo.Include;

public interface IncludeServiceInterface {
	void addInclude(Include include);
	Include selectIncludeById(String id);
	List<Include> selectIncludeByTitleType(String titleType);
	void updateInclude(Include include);
	void deleteInclude(String id);
	List<Include> selectAllInclude();
}
