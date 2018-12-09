package org.yin.service;

import org.yin.bean.DemoInfo;

public interface DemoInfoService {
	public DemoInfo findById(long id);

	public void deleteFromCache(long id);

	void test();
}
