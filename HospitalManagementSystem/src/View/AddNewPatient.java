package View;

import java.util.Scanner;

import Controller.CreatePatient;
import Model.Database;
import Model.Option;
import Model.Patient;
import Model.User;

public class AddNewPatient implements Option {

	@Override
	public void operation(Scanner s, Database database, User u) {
		Patient patient = new Patient();
		System.out.println("Enter first name:");
		patient.setFirstName(s.next());
		System.out.println("Enter last name:");
		patient.setLastName(s.next());
		System.out.println("Enter email:");
		patient.setEmail(s.next());
		System.out.println("Enter phone number:");
		patient.setPhoneNumber(s.next());
		System.out.println("Enter password:");
		String password = s.next();
		String confirmPassword;
		do {
			System.out.println("Confirm password:");
			confirmPassword = s.next();
		} while (!password.equals(confirmPassword));
		patient.setPassword(password);
		System.out.println("Enter blood group:");
		patient.setBloodGroup(s.next());
		
		if (new CreatePatient(patient, database).isCreated()) {
			System.out.println("Paitent added successfully");
		}
	}

	@Override
	public String getName() {
		return "Add New Patient";
	}

}
