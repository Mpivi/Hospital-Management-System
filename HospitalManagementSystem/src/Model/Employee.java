package Model;

public abstract class Employee extends User {
	
	private double salary;
	
	public Employee() {
		super();
	}
	
	public double getSalary() {
		return salary;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public abstract int getJob();
	
	public abstract String getJobToString();

}
