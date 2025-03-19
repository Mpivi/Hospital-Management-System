package View;

import java.util.Scanner;

import Controller.DeletePatient;
import Model.Database;
import Model.Option;
import Model.User;

public class RemovePatient implements Option {

	@Override
	public void operation(Scanner s, Database database, User u) {
		System.out.println("Enter patient ID (-1 to show all patients):");
		int ID = s.nextInt();
		while (ID<0) {
			new ViewAllPatients().operation(s, database, u);
			System.out.println("Enter patient ID (-1 to show all patients):");
			ID = s.nextInt();
		}
		
		if (new DeletePatient(ID, database).isDeleted()) {
			System.out.println("Patient deleted successfully");
		}
	}

	@Override
	public String getName() {
		return "Remove Patient";
	}
	
	

}
