package main.java.basic;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Employee implements WorkManager{

	@Override
	public String doIt() {
		return "do work";
	}
	
	@PostConstruct
	public void onCreated() {
		System.out.println("Employee생성");
	}
	
	@PreDestroy
	public void onDestroyed() {
		System.out.println("Employee 소멸");
	}
	
}
