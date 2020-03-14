package main.java.info.thecodinglive;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import main.java.basic.WorkService;
import main.java.basic.javaConfig.BeanConfig;
import main.java.basic.javaConfig.Company;

public class JavaConfigSpringApp {
	public static void main(String ar[]) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(BeanConfig.class);
		context.refresh();
		
		WorkService yourWorkService = context.getBean("yourWorkService", WorkService.class);
		yourWorkService.askWork();
		
		WorkService myWorkService = context.getBean("myWorkService", WorkService.class);
		myWorkService.askWork();
		
		Company company = context.getBean("company", Company.class);
		company.getname();
		
		context.close();
		
	}
}
