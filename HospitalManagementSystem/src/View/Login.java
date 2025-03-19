package View;

import java.util.Scanner;

import Controller.PatientLogin;
import Model.Database;

public class Login {
	
	public Login(Scanner s, Database database) {
		System.out.println("Welocme to hospital management system");
		System.out.println("Enter email:");
		String email = s.next();
		System.out.println("Enter password:");
		String password = s.next();
		
		Controller.EmployeeLogin login = new Controller.EmployeeLogin(email, password, database);
		PatientLogin pLogin = new PatientLogin(email, password, database);
		if (login.isLoggedIn()) {
			login.getUser().showList(s, database);
		} else if (pLogin.isLoggedIn()) {
			pLogin.getPatient().showList(s, database);
		} else {
			System.out.println("Wrong email or password");
		}
	}

}
