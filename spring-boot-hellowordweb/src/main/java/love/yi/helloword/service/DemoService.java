package love.yi.helloword.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import love.yi.helloword.bean.Demo;
import love.yi.helloword.dao.DemoDao;
import love.yi.helloword.dao.DemoRepository;
import love.yi.helloword.dao.IListMapStructureDao;

@Service
public class DemoService {
	// 默认使用bean标签中的name属性值进行匹配,找到多个就根据type原始类型进行匹配
	// 全都指定和默认匹配优先级一样
	// 单独指定就只匹配一种方案
	// @Autowire:默认优先级byType进行匹配,然后用byName进行匹配,结果为不为1就会报错
	@Resource(name = "demoRepository", type = DemoRepository.class)
	private DemoRepository demoRepository;

	@Resource
	private DemoDao demoDao;
	@Resource
	private IListMapStructureDao IListMapStructureDao;

	@Transactional
	public void save(Demo demo) {
		demoRepository.save(demo);
	}

	@Transactional
	public Demo getById(long id) {
		// demoRepository.findOne(id);//在demoRepository可以直接使用findOne进行获取.
		return demoDao.getById(id);
	}
	@Transactional
	public List<Map<String, String>> getInfoById(long id) {
		// demoRepository.findOne(id);//在demoRepository可以直接使用findOne进行获取.
		return IListMapStructureDao.getInfoById();
	}
}
