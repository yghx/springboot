package org.hgy;

import java.util.ArrayList;
import java.util.List;

import org.hgy.pojo.Demo;
import org.hgy.service.DemoService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App implements ApplicationContextAware  {
	@Autowired
	public static ApplicationContext  applicationContext ;
	public static void main(String[] args) {
//		SpringApplication app = new SpringApplication(App.class);
//		app.setBannerMode(Banner.Mode.OFF);
//		app.run(args);
		SpringApplication.run(App.class, args);
		DemoService bean = (DemoService)applicationContext.getBean("demoService");
		//****************************************************************************
		Demo demo = new Demo();
		List<Demo> demoList = new ArrayList<Demo>();
		demo.setName("wll");
		demoList.add(demo);
		demo.setName("hgy");
		demoList.add(demo);
		demo.setName("lzy");
		for(int i = 0;i<100000000;i++) {
			demoList.add(demo);
			if(demoList.size()>100000) {
				//分批次插入
				bean.insertBulkData(demoList);
				System.out.println(demoList.size());//3:数据都会存进去,但是保存的是相同的引用
				demoList.clear();
			}
		}
		System.out.println(demoList.size());//3:数据都会存进去,但是保存的是相同的引用
		bean.insertBulkData(demoList);
		//****************************************************************************
//		Demo demo = new Demo();
//		Set<Demo> demoList = new HashSet<Demo>();
//		demo.setName("wll");
//		demoList.add(demo);
//		demo.setName("hgy");
//		demoList.add(demo);
//		demo.setName("lzy");
//		demoList.add(demo);
//		System.out.println(demoList.size());//1

		System.out.println(bean.toString());
	}
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		App.applicationContext = applicationContext;
	}

}
