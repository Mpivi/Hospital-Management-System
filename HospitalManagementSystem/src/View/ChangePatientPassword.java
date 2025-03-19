package View;

import java.util.Scanner;

import Controller.UpdatePatientPassword;
import Model.Database;
import Model.Option;
import Model.Patient;
import Model.User;

public class ChangePatientPassword implements Option {

	@Override
	public void operation(Scanner s, Database database, User u) {
		String oldPassword;
		do {
			System.out.println("Enter old passowrd:");
			oldPassword = s.next();
		} while (!oldPassword.equals(u.getPassword()));
		System.out.println("Enter new password:");
		String newPassword = s.next();
		String confirmPassword;
		do {
			System.out.println("Confirm passowrd:");
			confirmPassword = s.next();
		} while (!confirmPassword.equals(newPassword));
		
		u.setPassword(newPassword);
		
		if (new UpdatePatientPassword((Patient) u, database).isUpdated()) {
			System.out.println("Password changed successfully");
		}
	}

	@Override
	public String getName() {
		return "Change Password";
	}

}
