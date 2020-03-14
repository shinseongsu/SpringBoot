package main.java.basic.javaConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import main.java.basic.Boss;
import main.java.basic.Employee;
import main.java.basic.WorkManager;
import main.java.basic.WorkService;

@Configuration
@Import(CompanyConfig.class)
public class BeanConfig {
	@Bean
	public WorkManager employee() {
		return new Employee();
	}
	
	@Bean
	public WorkManager boss() {
		return new Boss();
	}
	
	@Bean
	public WorkService yourWorkService() {
		WorkService workService = new WorkService();
		workService.setWorkManager(employee());
		return workService;
	}
	
	@Bean
	public WorkService myWorkService() {
		WorkService workService = new WorkService();
		workService.setWorkManager(boss());
		return workService;
	}
	
}
