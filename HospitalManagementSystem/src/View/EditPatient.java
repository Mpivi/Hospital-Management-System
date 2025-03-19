package View;

import java.util.Scanner;

import Controller.ReadPatient;
import Controller.UpdatePatient;
import Model.Database;
import Model.Option;
import Model.Patient;
import Model.User;

public class EditPatient implements Option {

	@Override
	public void operation(Scanner s, Database database, User u) {
		System.out.println("Enter Patient ID (-1 to show all patients):");
		int ID = s.nextInt();
		while (ID<0) {
			new ViewAllPatients().operation(s, database, u);
			System.out.println("Enter Patient ID (-1 to show all patients):");
			ID = s.nextInt();
		}
		
		Patient p = new ReadPatient(ID, database).getPatient();
		System.out.println("Enter first name (-1 to keep old value):");
		String firstName = s.next();
		if (!firstName.equals("-1")) p.setFirstName(firstName);
		
		System.out.println("Enter last name (-1 to keep old value):");
		String lastName = s.next();
		if (!lastName.equals("-1")) p.setLastName(lastName);
		
		System.out.println("Enter email (-1 to keep old value):");
		String email = s.next();
		if (!email.equals("-1")) p.setEmail(email);
		
		System.out.println("Enter phone number (-1 to keep old value):");
		String phoneNumber = s.next();
		if (!phoneNumber.equals("-1")) p.setPhoneNumber(phoneNumber);
		
		System.out.println("Enter blood group (-1 to keep old value):");
		String bloodGroup = s.next();
		if (!bloodGroup.equals("-1")) p.setBloodGroup(bloodGroup);
		
		if (new UpdatePatient(p, database).isUpdated()) {
			System.out.println("Patient updated successfully");
		}
	}

	@Override
	public String getName() {
		return "Edit Patient";
	}

}
