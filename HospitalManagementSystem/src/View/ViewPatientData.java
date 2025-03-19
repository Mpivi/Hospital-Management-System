package View;

import java.util.Scanner;

import Controller.ReadPatient;
import Model.Database;
import Model.Option;
import Model.Patient;
import Model.User;

public class ViewPatientData implements Option {

	@Override
	public void operation(Scanner s, Database database, User u) {
		System.out.println("Enter patient ID (-1 to show all patients):");
		int ID = s.nextInt();
		while (ID<0) {
			new ViewAllPatients().operation(s, database, u);
			System.out.println("Enter patient ID (-1 to show all patients):");
			ID = s.nextInt();
		}
		
		Patient p = new ReadPatient(ID, database).getPatient();
		System.out.println("-----------------------------");
		System.out.println("ID:\t\t"+p.getID());
		System.out.println("Name:\t\t"+p.getName());
		System.out.println("Email:\t\t"+p.getEmail());
		System.out.println("Phone Number:\t"+p.getPhoneNumber());
		System.out.println("Blood Group:\t"+p.getBloodGroup());
		System.out.println("-----------------------------");
	}

	@Override
	public String getName() {
		return "View Patient's Data";
	}

}
