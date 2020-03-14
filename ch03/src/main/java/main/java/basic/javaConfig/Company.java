package main.java.basic.javaConfig;

public class Company {
	
	private String name;
	
	Company(String name) {
		this.name = name;
	}
	
	public String getname() {
		System.out.println(name);
		return name;
	}
	
}
