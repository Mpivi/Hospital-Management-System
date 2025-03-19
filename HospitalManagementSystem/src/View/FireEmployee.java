package View;

import java.util.Scanner;

import Controller.DeleteEmployee;
import Model.Database;
import Model.Option;
import Model.User;

public class FireEmployee implements Option {

	@Override
	public void operation(Scanner s, Database database, User u) {
		System.out.println("Enter Employee ID (-1 to show all employees):");
		int ID = s.nextInt();
		while (ID<0) {
			new ViewEmployees().operation(s, database, u);
			System.out.println("Enter Employee ID (-1 to show all employees):");
			ID = s.nextInt();
		}
		if (new DeleteEmployee(ID, database).isDeleted()) {
			System.out.println("Employee deleted successfully");
		}
	}

	@Override
	public String getName() {
		return "Fire Employee";
	}

}
