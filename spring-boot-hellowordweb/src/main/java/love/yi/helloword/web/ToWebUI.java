package love.yi.helloword.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ToWebUI {
	@RequestMapping("/picUpload")
	public String picUpload() {
		return "file";
	}
}
