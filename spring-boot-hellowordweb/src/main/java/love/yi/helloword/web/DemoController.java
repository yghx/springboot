package love.yi.helloword.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import love.yi.helloword.bean.Demo;

@RestController
@RequestMapping("/demo")
public class DemoController {
	/**
	 * 返回demo数据: 请求地址：http://127.0.0.1:8080/demo/getDemo
	 * 
	 * @return
	 */
	@RequestMapping("/getDemo")
	public Demo getDemo() {
		Demo demo = new Demo();
		demo.setId(1);
		demo.setName("Ange3");
		return demo;
	}

	// 地址：http://127.0.0.1:8080/demo/getFastJson
	@RequestMapping("/getFastJson")
	public String getFastJson() {
		Demo demo = new Demo();
		demo.setId(2);
		demo.setName("Angel2");
		// 直接使用ali的fastjson工具转化成json串后直接返回String也是可以的
		return JSONObject.toJSONString(demo);
	}

	@RequestMapping("/zeroException")
	public int zeroException() {
		return 100 / 0;
	}
}
