package main.java.info.thecodinglive;

import org.springframework.context.support.GenericXmlApplicationContext;

import main.java.basic.WorkService;

public class XmlSpringApp {
	
	public static void main(String ar[]) {
		
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		WorkService yourWorkService = context.getBean("yourWorkService", WorkService.class);
		yourWorkService.askWork();
		
		WorkService workService = context.getBean("myWorkService", WorkService.class);
		
		context.close();
		
	}
}
