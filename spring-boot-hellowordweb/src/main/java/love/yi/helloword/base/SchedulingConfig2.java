package love.yi.helloword.base;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class SchedulingConfig2 {
	@Scheduled(cron = "0/30 * * * * ?") // 每20秒执行一次
	public void scheduler() {
		System.out.println(">>>>>>>>> SchedulingConfig.scheduler()"+SchedulingConfig.i++);
	}
}
