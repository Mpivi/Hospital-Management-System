package View;

import java.util.ArrayList;
import java.util.Scanner;

import Controller.ReadEmployees;
import Model.Database;
import Model.Doctor;
import Model.Employee;
import Model.Option;
import Model.User;

public class ViewEmployees implements Option {

	@Override
	public void operation(Scanner s, Database database, User u) {
		ArrayList<Employee> employees = new ReadEmployees(database).getEmployees();
		System.out.println("----------------------------------");
		for (Employee e : employees) {
			System.out.println("ID:\t\t"+e.getID());
			System.out.println("Name:\t\t"+e.getFirstName()+" "+e.getLastName());
			System.out.println("Email:\t\t"+e.getEmail());
			System.out.println("Phone Number:\t"+e.getPhoneNumber());
			System.out.println("Salary:\t\t"+e.getSalary()+" $");
			System.out.println("Job:\t\t"+e.getJobToString());
			if (e.getJob()==0)
				System.out.println("Specialization:\t"+((Doctor) e).getSpecialization());
			System.out.println("----------------------------------");
		}
	}

	@Override
	public String getName() {
		return "View All Employees";
	}

}
