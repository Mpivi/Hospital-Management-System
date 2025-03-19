package View;

import java.util.Scanner;

import Controller.CreateEmployee;
import Model.Cashier;
import Model.Database;
import Model.Doctor;
import Model.Employee;
import Model.Option;
import Model.Receptionist;
import Model.User;

public class AddNewEmployee implements Option {

	@Override
	public void operation(Scanner s, Database database, User u) {
		System.out.println("Enter first name:");
		String firstName = s.next();
		System.out.println("Enter last name:");
		String lastName = s.next();
		System.out.println("Enter email:");
		String email = s.next();
		System.out.println("Enter phone number:");
		String phoneNumber = s.next();
		System.out.println("Enter password:");
		String password = s.next();
		String confirmPassword;
		do {
			System.out.println("Confirm password:");
			confirmPassword = s.next();
		} while (!password.equals(confirmPassword));
		System.out.println("Enter salary (double):");
		double salary = s.nextDouble();
		int job;
		do {
			System.out.println("Enter job title:\n0. Doctor\n1. Cashier\n2. Receptionist");
			job = s.nextInt();
		} while (job<0 || job>2);
		
		String specialization = "";
		if (job==0) {
			System.out.println("Enter specialization:");
			specialization = s.next();
		}
		
		Employee employee;
		
		switch (job) {
		case 0:
			employee = new Doctor();
			employee.setFirstName(firstName);
			employee.setLastName(lastName);
			employee.setEmail(email);
			employee.setPhoneNumber(phoneNumber);
			employee.setPassword(password);
			employee.setSalary(salary);
			((Doctor) employee).setSpecialization(specialization);
			break;
		case 1:
			employee = new Cashier();
			employee.setFirstName(firstName);
			employee.setLastName(lastName);
			employee.setEmail(email);
			employee.setPhoneNumber(phoneNumber);
			employee.setPassword(password);
			employee.setSalary(salary);
			break;
		case 2:
			employee = new Receptionist();
			employee.setFirstName(firstName);
			employee.setLastName(lastName);
			employee.setEmail(email);
			employee.setPhoneNumber(phoneNumber);
			employee.setPassword(password);
			employee.setSalary(salary);
			break;
			default:
				employee = new Employee() {
					@Override
					public int getJob() {
						return -1;
					}
					@Override
					public String getJobToString() {
						return "Unknown job";
					}
					@Override
					public void showList(Scanner s, Database database) {
						System.out.println("Unknown job");
					}
				};
		}
		
		if (new CreateEmployee(employee, database).isCreated())
			System.out.println("Employee added successfully");
	}

	@Override
	public String getName() {
		return "Add New Employee";
	}

}
