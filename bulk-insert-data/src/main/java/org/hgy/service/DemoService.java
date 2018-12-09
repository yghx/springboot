package org.hgy.service;

import java.util.List;

import javax.annotation.Resource;

import org.hgy.dao.IDemoDao;
import org.hgy.pojo.Demo;
import org.springframework.stereotype.Service;

@Service
public class DemoService {
	@Resource 
	private IDemoDao demoDao;
	
	public void insertBulkData(List<Demo> demoList) {
		demoDao.insertBulkData(demoList);
	}
}
