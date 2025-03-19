package View;

import java.util.Scanner;

import Model.Database;
import Model.Option;
import Model.Patient;
import Model.User;

public class ViewPatientUserData implements Option {

	@Override
	public void operation(Scanner s, Database database, User u) {
		System.out.println("-----------------------------");
		System.out.println("ID:\t\t"+u.getID());
		System.out.println("Name:\t\t"+u.getFirstName()+" "+u.getLastName());
		System.out.println("Email:\t\t"+u.getEmail());
		System.out.println("Phone Number:\t"+u.getPhoneNumber());
		System.out.println("Blood Group:\t"+((Patient) u).getBloodGroup());
		System.out.println("-----------------------------");
	}

	@Override
	public String getName() {
		return "View My Data";
	}

}
