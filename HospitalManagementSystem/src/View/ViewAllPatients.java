package View;

import java.util.Scanner;

import Controller.ReadPatients;
import Model.Database;
import Model.Option;
import Model.Patient;
import Model.User;

public class ViewAllPatients implements Option {

	@Override
	public void operation(Scanner s, Database database, User u) {
		System.out.println("-----------------------------");
		for (Patient p : new ReadPatients(database).getPatients()) {
			System.out.println("ID:\t\t"+p.getID());
			System.out.println("Name:\t\t"+p.getFirstName()+" "+p.getLastName());
			System.out.println("Email:\t\t"+p.getEmail());
			System.out.println("Phone Number:\t"+p.getPhoneNumber());
			System.out.println("Blood Group:\t"+p.getBloodGroup());
			System.out.println("-----------------------------");
		}
	}

	@Override
	public String getName() {
		return "View All Patients";
	}

}
