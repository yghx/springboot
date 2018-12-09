package love.yi.helloword.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		int i = 3;
		if(1< i) {
			registry.addResourceHandler("/myres2/**").addResourceLocations("classpath:/myres/");
			super.addResourceHandlers(registry);
		}else {
			registry.addResourceHandler("/myres/**").addResourceLocations("classpath:/myres2/");
			super.addResourceHandlers(registry);
		}
	}
}