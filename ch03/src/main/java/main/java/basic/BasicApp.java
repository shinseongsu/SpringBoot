package main.java.basic;

public class BasicApp {
	public static void main(String ar[]) {
		
		WorkService workservice = new WorkService();
		WorkManager employee = new Employee();
		WorkManager boss = new Boss();
		
		workservice.setWorkManager(employee);
		workservice.askWork();
		
		workservice.setWorkManager(boss);
		workservice.askWork();
		
	}
}
