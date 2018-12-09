package love.yi.helloword;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

//让spring boot自动程序进行必要的配置
//等价于以默认属性使用
//@Configuration，@EnableAutoConfiguration和@ComponentScan
@SpringBootApplication
@ServletComponentScan // 使得spring能够扫描到我们自己编写的servlet和filter
public class App {
/*	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		return multipartResolver;
	}*/
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
