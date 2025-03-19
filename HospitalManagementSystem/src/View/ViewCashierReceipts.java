package View;

import java.util.ArrayList;
import java.util.Scanner;

import Controller.ReadCashierReceipts;
import Controller.ReadOperation;
import Controller.ReadReport;
import Model.Cashier;
import Model.Database;
import Model.Operation;
import Model.Option;
import Model.Receipt;
import Model.Report;
import Model.User;

public class ViewCashierReceipts implements Option {

	@Override
	public void operation(Scanner s, Database database, User u) {
		ArrayList<Receipt> receipts = new ReadCashierReceipts(
				(Cashier) u, database).getReceipts();
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
		return "View My Receipts";
	}

}
