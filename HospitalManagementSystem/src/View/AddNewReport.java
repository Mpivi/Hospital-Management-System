package View;

import java.util.Scanner;

import Controller.CreateReport;
import Controller.ReadPatient;
import Model.Database;
import Model.Doctor;
import Model.Option;
import Model.Report;
import Model.User;

public class AddNewReport implements Option {

	@Override
	public void operation(Scanner s, Database database, User u) {
		Report r = new Report();
		r.setDoctor((Doctor) u);
		
		System.out.println("Enter patient ID (-1 to show all patients):");
		int patientID = s.nextInt();
		while (patientID<0) {
			new ViewAllPatients().operation(s, database, u);
			System.out.println("Enter patient ID (-1 to show all patients):");
			patientID = s.nextInt();
		}
		
		r.setPatient(new ReadPatient(patientID, database).getPatient());
		
		System.out.println("Enter date time with format ("+r.getDateTimeFormat()+"):");
		r.setDateTime(s.next());
		
		System.out.println("Enter diagnosis:");
		r.setDiagnosis(s.next());
		System.out.println("Enter treatment:");
		r.setTreatment(s.next());
		r.setPaid(false);
		
		System.out.println("\nDoctor:\t\t"+r.getDoctor().getName());
		System.out.println("Patient:\t"+r.getPatient().getName());
		System.out.println("Date Time:\t"+r.getDateTime());
		System.out.println("Diagnosis:\t"+r.getDiagnosis());
		System.out.println("Treatment:\t"+r.getTreatment());
		System.out.println("Paid:\t\t"+r.isPaid());
		
		System.out.println("\nAre you sure that you want to continue?\n"
				+ "These data cannot be updated later\n"
				+ "1. Continue");
		if (s.nextInt()==1) {
			if (new CreateReport(r, database).isCreated()) {
				System.out.println("Report created successfully");
			}
		}
		
	}

	@Override
	public String getName() {
		return "Add New Report";
	}

}
