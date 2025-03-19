package View;

import java.util.ArrayList;
import java.util.Scanner;

import Controller.ReadPatient;
import Controller.ReadPatientOperations;
import Model.Database;
import Model.Operation;
import Model.Option;
import Model.Patient;
import Model.User;

public class ViewPatientOperations implements Option {

	@Override
	public void operation(Scanner s, Database database, User u) {
		System.out.println("Enter patient ID (-1 to show all patients):");
		int patientID = s.nextInt();
		while (patientID<0) {
			new ViewAllPatients().operation(s, database, u);
			System.out.println("Enter patient ID (-1 to show all patients):");
			patientID = s.nextInt();
		}
		
		Patient p = new ReadPatient(patientID, database).getPatient();
		ArrayList<Operation> operations = new ReadPatientOperations(p, database)
				.getOperations();
		System.out.println("-----------------------------------");
		for (Operation o : operations) {
			System.out.println("ID:\t\t"+o.getID());
			System.out.println("Doctor:\t\t"+o.getDoctor().getName());
			System.out.println("Patient:\t"+o.getPatient().getName());
			System.out.println("Date Time:\t"+o.getDateTime());
			System.out.println("Paid:\t\t"+o.isPaid());
			System.out.println("Diagnosis\t"+o.getDiagnosis());
			System.out.println("-----------------------------------");
		}
	}

	@Override
	public String getName() {
		return "View Patient's Operations";
	}

}
