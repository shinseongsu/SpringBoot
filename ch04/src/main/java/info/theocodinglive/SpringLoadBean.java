package info.theocodinglive;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

public class SpringLoadBean {
	public static void main(String ar[]) {
		ApplicationContext context = SpringApplication.run(SpringLoadBean.class, ar);
		String[] beanNames = context.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for(String name : beanNames) {
			System.out.println(beanNames);
		}
		
	}
}
