package love.yi.helloword.web;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 模板测试.
 * 
 * @author Administrator
 *
 */
@Controller
public class TemplateController {
	/**
	 * 返回html模板.
	 */
	@RequestMapping("/helloHtml")
	public String helloHtml(Map<String, Object> map) {
		map.put("hello", "from TemplateController.helloHtml");
		return "/helloHtml";// 默认在/src/main/resource/templates下面,并且去掉了后缀
	}

	@RequestMapping("/helloFtl")
	public String helloFtl(Map<String, Object> map) {
		map.put("hello", "from TemplateController.helloFtl");
		return "/helloFtl";
	}
}