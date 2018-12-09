package love.yi.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
@Controller
public class AppTest {
	@Value("1")
	public String driverClass;
	@Test
	public void test() throws Exception {
		System.out.println(driverClass);
		//Class.forName(driverClass);
		
	}
}
