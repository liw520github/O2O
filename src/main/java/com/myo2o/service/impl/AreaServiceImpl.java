 package com.myo2o.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myo2o.dao.AreaDao;
import com.myo2o.entity.Area;
import com.myo2o.service.AreaService;
@Service
public class AreaServiceImpl implements AreaService{
	@Autowired
	private AreaDao areaDao;
	@Override
	public List<Area> getAreaList() {
		// TODO Auto-generated method stub
		return areaDao.queryArea();
	}

}
