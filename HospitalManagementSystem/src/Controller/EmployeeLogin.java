package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Model.Cashier;
import Model.Database;
import Model.Doctor;
import Model.Receptionist;
import Model.User;

public class EmployeeLogin {
	
	private String email, password;
	private Database database;
	private User u;
	
	public EmployeeLogin(String email, String password, Database database) {
		this.email = email;
		this.password = password;
		this.database = database;
	}
	
	public boolean isLoggedIn() {
		boolean loggedIn = false;
		String select = "SELECT * FROM `employees` WHERE `Email` = '"+email+
				"' AND `Password` = '"+password+"';";
		try {
			ResultSet rs = database.getStatement().executeQuery(select);
			loggedIn = rs.next();
			if (loggedIn) {
				int job = rs.getInt("Job");
				switch (job) {
				case 0:
					u = new Doctor();
					((Doctor) u).setSpecialization(rs.getString("Specialization"));
					break;
				case 1:
					u = new Cashier();
					break;
				case 2:
					u = new Receptionist();
					break;
					default:
						u = new User() {	
							@Override
							public void showList(Scanner s, Database database) {
								System.out.println("Unkonwn job!");
							}
						};
				}
				u.setID(rs.getInt("ID"));
				u.setFirstName(rs.getString("FirstName"));
				u.setLastName(rs.getString("LastName"));
				u.setEmail(rs.getString("Email"));
				u.setPhoneNumber(rs.getString("PhoneNumber"));
				u.setPassword(rs.getString("Password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return loggedIn;
	}
	
	public User getUser() {
		return u;
	}

}
