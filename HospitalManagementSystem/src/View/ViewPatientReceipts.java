package View;

import java.util.ArrayList;
import java.util.Scanner;

import Controller.ReadOperation;
import Controller.ReadPatient;
import Controller.ReadPatientReceipts;
import Controller.ReadReport;
import Model.Database;
import Model.Operation;
import Model.Option;
import Model.Patient;
import Model.Receipt;
import Model.Report;
import Model.User;

public class ViewPatientReceipts implements Option {

	@Override
	public void operation(Scanner s, Database database, User u) {
		System.out.println("Enter Patient ID (-1 to show all patients):");
		int patientID = s.nextInt();
		while (patientID<0) {
			new ViewAllPatients().operation(s, database, u);
			System.out.println("Enter Patient ID (-1 to show all patients):");
			patientID = s.nextInt();
		}
		
		Patient p = new ReadPatient(patientID, database).getPatient();
		ArrayList<Receipt> receipts = new ReadPatientReceipts(p, database)
				.getReceipts();
		System.out.println("--------------------------");
		for (Receipt r : receipts) {
			System.out.println("ID:\t\t"+r.getID());
			System.out.println("Cashier:\t"+r.getCashier().getName());
			System.out.println("Patient:\t"+r.getPatient().getName());
			System.out.println("Amount:\t\t"+r.getAmount()+"$");
			System.out.println("Type:\t\t"+r.getTypeToString());
			System.out.println("Item ID:\t"+r.getItemID());
			System.out.println("====== "+r.getTypeToString()+" Details ======");
			if (r.getType()==0) {
				Operation o = new ReadOperation(r.getItemID(), database)
						.getOperation();
				System.out.println("Doctor:\t\t"+o.getDoctor().getName());
				System.out.println("Patient:\t"+o.getPatient().getName());
				System.out.println("Date Time:\t"+o.getDateTime());
				System.out.println("Paid:\t\t"+o.isPaid());
				System.out.println("Diagnosis\t"+o.getDiagnosis());
			} else if (r.getType()==1) {
				Report report = new ReadReport(r.getItemID(), database).getReport();
				System.out.println("Doctor:\t\t"+report.getDoctor().getName());
				System.out.println("Patient:\t"+report.getPatient().getName());
				System.out.println("Date Time:\t"+report.getDateTime());
				System.out.println("Diagnosis:\t"+report.getDiagnosis());
				System.out.println("Treatment:\t"+report.getTreatment());
				System.out.println("Paid:\t\t"+report.isPaid());
			}
			System.out.println("--------------------------");
		}
	}

	@Override
	public String getName() {
		return "View Patient's Receipts";
	}

}
