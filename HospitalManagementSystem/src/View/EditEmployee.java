package View;

import java.util.Scanner;

import Controller.ReadEmployee;
import Controller.UpdateEmployee;
import Model.Cashier;
import Model.Database;
import Model.Doctor;
import Model.Employee;
import Model.Option;
import Model.Receptionist;
import Model.User;

public class EditEmployee implements Option {

	@Override
	public void operation(Scanner s, Database database, User u) {
		System.out.println("Enter employee ID (int):\n(-1 to show all employees)");
		int ID = s.nextInt();
		
		while (ID<0) {
			new ViewEmployees().operation(s, database, u);
			System.out.println("Enter employee ID (int):\n(-1 to show all employees)");
			ID = s.nextInt();
		}
		
		Employee e = new ReadEmployee(ID, database).getEmployee();
		
		System.out.println("Enter first name (-1 to keep old value):");
		String firstName = s.next();
		if (!firstName.equals("-1")) e.setFirstName(firstName);
		
		System.out.println("Enter last name (-1 to keep old value):");
		String lastName = s.next();
		if (!lastName.equals("-1")) e.setLastName(lastName);
		
		System.out.println("Enter email (-1 to keep old value):");
		String email = s.next();
		if (!email.equals("-1")) e.setEmail(email);
		
		System.out.println("Enter phone number (-1 to keep old value):");
		String phoneNumber = s.next();
		if (!phoneNumber.equals("-1")) e.setPhoneNumber(phoneNumber);
		
		System.out.println("Enter salary (-1 to keep old value):");
		double salary = s.nextDouble();
		if (salary!=-1) e.setSalary(salary);
		
		if (e.getJob()==0) {
			System.out.println("Enter specialization (-1 to keep old value):");
			String specialization = s.next();
			if (!specialization.equals("-1"))
				((Doctor) e).setSpecialization(specialization);
		}
		
		System.out.println("Enter job (-1 to keep old value)\n0. Doctor\n1. Cashier\n2. Receptionist:");
		int job = s.nextInt();
		switch (job) {
		case 0:
			System.out.println("Enter specialization:");
			String spec = s.next();
			Employee d = new Doctor();
			d.setID(e.getID());
			d.setFirstName(e.getFirstName());
			d.setLastName(e.getLastName());
			d.setEmail(e.getEmail());
			d.setPhoneNumber(e.getPhoneNumber());
			d.setPassword(e.getPassword());
			d.setSalary(e.getSalary());
			((Doctor) d).setSpecialization(spec);
			e = d;
			break;
		case 1:
			Cashier c = new Cashier();
			c.setID(e.getID());
			c.setFirstName(e.getFirstName());
			c.setLastName(e.getLastName());
			c.setEmail(e.getEmail());
			c.setPhoneNumber(e.getPhoneNumber());
			c.setPassword(e.getPassword());
			c.setSalary(e.getSalary());
			e = c;
			break;
		case 2:
			Receptionist r = new Receptionist();
			r.setID(e.getID());
			r.setFirstName(e.getFirstName());
			r.setLastName(e.getLastName());
			r.setEmail(e.getEmail());
			r.setPhoneNumber(e.getPhoneNumber());
			r.setPassword(e.getPassword());
			r.setSalary(e.getSalary());
			e = r;
			break;
		case -1:
			break;
			default:
				System.out.println("Invalid job!");
				return;
		}
		
		if (new UpdateEmployee(e, database).isUpdated()) {
			System.out.println("Employee updated successfully");
		}
		
	}

	@Override
	public String getName() {
		return "Edit Employee";
	}

}
