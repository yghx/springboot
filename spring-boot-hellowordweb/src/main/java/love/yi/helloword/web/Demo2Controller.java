package love.yi.helloword.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import love.yi.helloword.bean.Demo;
import love.yi.helloword.service.DemoService;

@RestController
@RequestMapping("/demo2")
public class Demo2Controller {
	@Resource
	private DemoService demoService;

	@RequestMapping("/listMap")
	public String getInfoById() {
		List<Map<String, String>> infoById = demoService.getInfoById(1);
		String s = JSONArray.toJSON(infoById).toString();
		return s;
	}
	/**
	 * 测试保存数据方法.
	 * 
	 * @return
	 */
	@RequestMapping("/save")
	public String save() {
		Demo d = new Demo();
		d.setName("Angel");
		demoService.save(d);// 保存数据.
		return "ok.Demo2Controller.save";
	}

	// 地址：http://127.0.0.1:8080/demo2/getById?id=1
	@RequestMapping("/getById")
	public Demo getById(long id) {
		return demoService.getById(id);
	}
}