package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.CampusMapper;
import com.pojo.Campus;

/**        
 * 类名称：CampusService   
 * 类描述：   
 * 创建人：syd   
 * 创建时间：2018-8-8 下午6:45:42      
 * @version    
 *    
 */
@Service
public class CampusService implements CampusServiceInterface {
	@Resource
	private CampusMapper campusMapper;

	@Override
	public void addCampus(Campus campus) {
		// TODO Auto-generated method stub
		campusMapper.addCampus(campus);
	}

	@Override
	public List<Campus> selectAllCampus() {
		// TODO Auto-generated method stub
		return campusMapper.selectAllCampus();
	}

	@Override
	public void updateCampus(Campus campus) {
		// TODO Auto-generated method stub
		campusMapper.updateCampus(campus);
	}

	@Override
	public void deleteCampus(String id) {
		// TODO Auto-generated method stub
		campusMapper.deleteCampus(id);
	}

	@Override
	public Campus selectCampusById(String id) {
		// TODO Auto-generated method stub
		return campusMapper.selectCampusById(id);
	}

	@Override
	public List<Campus> selectCampusLikeName(String campusName) {
		// TODO Auto-generated method stub
		return campusMapper.selectCampusLikeName(campusName);
	}

	@Override
	public Campus selectCampusByName(String campusName) {
		// TODO Auto-generated method stub
		return campusMapper.selectCampusByName(campusName);
	}

	/* (non-Javadoc)
	 * @see com.service.CampusServiceInterface#selectAllCampusNum()
	 */
	@Override
	public int selectAllCampusNum() {
		// TODO Auto-generated method stub
		return campusMapper.selectAllCampusNum();
	}
	

}
