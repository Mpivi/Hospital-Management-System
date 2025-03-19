package View;

import java.util.Scanner;

import Controller.CreateOperation;
import Controller.ReadPatient;
import Model.Database;
import Model.Doctor;
import Model.Operation;
import Model.Option;
import Model.User;

public class AddNewOperation implements Option {

	@Override
	public void operation(Scanner s, Database database, User u) {
		
		Operation operation = new Operation();
		operation.setDoctor((Doctor) u);
		
		System.out.println("Enter patient ID (-1 to show all patients):");
		int patientID = s.nextInt();
		while (patientID<0) {
			new ViewAllPatients().operation(s, database, u);
			System.out.println("Enter patient ID (-1 to show all patients):");
			patientID = s.nextInt();
		}
		
		operation.setPatient(new ReadPatient(patientID, database).getPatient());
		
		System.out.println("Enter Date Time with format ("+ operation.getDateTimeFormat()+"):");
		operation.setDateTime(s.next());
		operation.setPaid(false);
		System.out.println("Enter diagnosis:");
		operation.setDiagnosis(s.next());
		
		System.out.println("\nDoctor:\t\t"+operation.getDoctor().getName());
		System.out.println("Patient:\t"+operation.getPatient().getName());
		System.out.println("Date Time:\t"+operation.getDateTime());
		System.out.println("Paid:\t\t"+operation.isPaid());
		System.out.println("Diagnosis:\t"+operation.getDiagnosis());
		
		System.out.println("\nAre you sure that you want to continue?\n"
				+ "These data cannot be updated later\n"
				+ "1. Continue");
		if (s.nextInt()==1) {
			if (new CreateOperation(operation, database).isCreated()) {
				System.out.println("Operation added successfully");
			}
		}
	}

	@Override
	public String getName() {
		return "Add New Operation";
	}

}
