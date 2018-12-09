package org.hgy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.hgy.pojo.Demo;

@Mapper
public interface IDemoDao {
	void insertBulkData(List<Demo> demoList);
}
